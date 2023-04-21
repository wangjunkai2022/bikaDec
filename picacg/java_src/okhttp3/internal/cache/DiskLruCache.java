package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.d;
import okio.e;
import okio.k;
import okio.p;
import okio.q;
/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    d journalWriter;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    int redundantOpCount;
    final int valueCount;
    private long size = 0;
    final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final Runnable cleanupRunnable = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.initialized) || DiskLruCache.this.closed) {
                    return;
                }
                try {
                    DiskLruCache.this.trimToSize();
                } catch (IOException unused) {
                    DiskLruCache.this.mostRecentTrimFailed = true;
                }
                try {
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache.this.mostRecentRebuildFailed = true;
                    DiskLruCache.this.journalWriter = k.b(k.gb());
                }
            }
        }
    };

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public synchronized void initialize() throws IOException {
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException e) {
                Platform platform = Platform.get();
                platform.log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);
                delete();
                this.closed = false;
            }
        }
        rebuildJournal();
        this.initialized = true;
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            }
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void readJournal() throws IOException {
        e b = k.b(this.fileSystem.source(this.journalFile));
        try {
            String fJ = b.fJ();
            String fJ2 = b.fJ();
            String fJ3 = b.fJ();
            String fJ4 = b.fJ();
            String fJ5 = b.fJ();
            if (!MAGIC.equals(fJ) || !VERSION_1.equals(fJ2) || !Integer.toString(this.appVersion).equals(fJ3) || !Integer.toString(this.valueCount).equals(fJ4) || !"".equals(fJ5)) {
                throw new IOException("unexpected journal header: [" + fJ + ", " + fJ2 + ", " + fJ4 + ", " + fJ5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(b.fJ());
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (!b.fB()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = newJournalWriter();
                    }
                    Util.closeQuietly(b);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(b);
            throw th;
        }
    }

    private d newJournalWriter() throws FileNotFoundException {
        return k.b(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) { // from class: okhttp3.internal.cache.DiskLruCache.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // okhttp3.internal.cache.FaultHidingSink
            protected void onException(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == REMOVE.length() && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == CLEAN.length() && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
        } else if (indexOf2 == -1 && indexOf == DIRTY.length() && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry);
        } else if (indexOf2 == -1 && indexOf == READ.length() && str.startsWith(READ)) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i]);
                    this.fileSystem.delete(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        d b = k.b(this.fileSystem.sink(this.journalFileTmp));
        b.aV(MAGIC).at(10);
        b.aV(VERSION_1).at(10);
        b.y(this.appVersion).at(10);
        b.y(this.valueCount).at(10);
        b.at(10);
        for (Entry entry : this.lruEntries.values()) {
            if (entry.currentEditor != null) {
                b.aV(DIRTY).at(32);
                b.aV(entry.key);
                b.at(10);
            } else {
                b.aV(CLEAN).at(32);
                b.aV(entry.key);
                entry.writeLengths(b);
                b.at(10);
            }
        }
        b.close();
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }

    public synchronized Snapshot get(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.readable) {
            Snapshot snapshot = entry.snapshot();
            if (snapshot == null) {
                return null;
            }
            this.redundantOpCount++;
            this.journalWriter.aV(READ).at(32).aV(str).at(10);
            if (journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return snapshot;
        }
        return null;
    }

    @Nullable
    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    synchronized Editor edit(String str, long j) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j == -1 || (entry != null && entry.sequenceNumber == j)) {
            if (entry == null || entry.currentEditor == null) {
                if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                    this.journalWriter.aV(DIRTY).at(32).aV(str).at(10);
                    this.journalWriter.flush();
                    if (this.hasJournalErrors) {
                        return null;
                    }
                    if (entry == null) {
                        entry = new Entry(str);
                        this.lruEntries.put(str, entry);
                    }
                    Editor editor = new Editor(entry);
                    entry.currentEditor = editor;
                    return editor;
                }
                this.executor.execute(this.cleanupRunnable);
                return null;
            }
            return null;
        }
        return null;
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new IllegalStateException();
        }
        if (z && !entry.readable) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!editor.written[i]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!this.fileSystem.exists(entry.dirtyFiles[i])) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            File file = entry.dirtyFiles[i2];
            if (z) {
                if (this.fileSystem.exists(file)) {
                    File file2 = entry.cleanFiles[i2];
                    this.fileSystem.rename(file, file2);
                    long j = entry.lengths[i2];
                    long size = this.fileSystem.size(file2);
                    entry.lengths[i2] = size;
                    this.size = (this.size - j) + size;
                }
            } else {
                this.fileSystem.delete(file);
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable | z) {
            entry.readable = true;
            this.journalWriter.aV(CLEAN).at(32);
            this.journalWriter.aV(entry.key);
            entry.writeLengths(this.journalWriter);
            this.journalWriter.at(10);
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.aV(REMOVE).at(32);
            this.journalWriter.aV(entry.key);
            this.journalWriter.at(10);
        }
        this.journalWriter.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public synchronized boolean remove(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        boolean removeEntry = removeEntry(entry);
        if (removeEntry && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry;
    }

    boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(entry.cleanFiles[i]);
            this.size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.aV(REMOVE).at(32).aV(entry.key).at(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Entry[] entryArr;
        if (this.initialized && !this.closed) {
            for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public synchronized void evictAll() throws IOException {
        initialize();
        for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    private void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() { // from class: okhttp3.internal.cache.DiskLruCache.3
            final Iterator<Entry> delegate;
            Snapshot nextSnapshot;
            Snapshot removeSnapshot;

            {
                this.delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.closed) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        Snapshot snapshot = this.delegate.next().snapshot();
                        if (snapshot != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                }
            }

            @Override // java.util.Iterator
            public Snapshot next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.removeSnapshot = this.nextSnapshot;
                this.nextSnapshot = null;
                return this.removeSnapshot;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.removeSnapshot == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    DiskLruCache.this.remove(this.removeSnapshot.key);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.removeSnapshot = null;
                    throw th;
                }
                this.removeSnapshot = null;
            }
        };
    }

    /* loaded from: classes.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final q[] sources;

        Snapshot(String str, long j, q[] qVarArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = qVarArr;
            this.lengths = jArr;
        }

        public String key() {
            return this.key;
        }

        @Nullable
        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public q getSource(int i) {
            return this.sources[i];
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (q qVar : this.sources) {
                Util.closeQuietly(qVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        void detach() {
            if (this.entry.currentEditor == this) {
                for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                    try {
                        DiskLruCache.this.fileSystem.delete(this.entry.dirtyFiles[i]);
                    } catch (IOException unused) {
                    }
                }
                this.entry.currentEditor = null;
            }
        }

        public q newSource(int i) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.readable && this.entry.currentEditor == this) {
                    try {
                        return DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[i]);
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
                return null;
            }
        }

        public p newSink(int i) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor != this) {
                    return k.gb();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                try {
                    return new FaultHidingSink(DiskLruCache.this.fileSystem.sink(this.entry.dirtyFiles[i])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // okhttp3.internal.cache.FaultHidingSink
                        protected void onException(IOException iOException) {
                            synchronized (DiskLruCache.this) {
                                Editor.this.detach();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return k.gb();
                }
            }
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.done = true;
            }
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, false);
                }
                this.done = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.done && this.entry.currentEditor == this) {
                    try {
                        DiskLruCache.this.completeEdit(this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                sb.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        void writeLengths(d dVar) throws IOException {
            for (long j : this.lengths) {
                dVar.at(32).y(j);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        Snapshot snapshot() {
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            q[] qVarArr = new q[DiskLruCache.this.valueCount];
            long[] jArr = (long[]) this.lengths.clone();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                try {
                    qVarArr[i] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < DiskLruCache.this.valueCount && qVarArr[i2] != null; i2++) {
                        Util.closeQuietly(qVarArr[i2]);
                    }
                    try {
                        DiskLruCache.this.removeEntry(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return new Snapshot(this.key, this.sequenceNumber, qVarArr, jArr);
        }
    }
}
