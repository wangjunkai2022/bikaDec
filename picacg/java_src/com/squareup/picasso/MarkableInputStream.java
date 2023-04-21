package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
final class MarkableInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private long defaultMark;
    private final InputStream in;
    private long limit;
    private long offset;
    private long reset;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public MarkableInputStream(InputStream inputStream, int i) {
        this.defaultMark = -1L;
        this.in = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.defaultMark = savePosition(i);
    }

    public long savePosition(int i) {
        long j = this.offset + i;
        if (this.limit < j) {
            setLimit(j);
        }
        return this.offset;
    }

    private void setLimit(long j) {
        try {
            if (this.reset < this.offset && this.offset <= this.limit) {
                this.in.reset();
                this.in.mark((int) (j - this.reset));
                skip(this.reset, this.offset);
            } else {
                this.reset = this.offset;
                this.in.mark((int) (j - this.offset));
            }
            this.limit = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        reset(this.defaultMark);
    }

    public void reset(long j) throws IOException {
        if (this.offset > this.limit || j < this.reset) {
            throw new IOException("Cannot reset");
        }
        this.in.reset();
        skip(this.reset, j);
        this.offset = j;
    }

    private void skip(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.in.skip(j2 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                }
                skip = 1;
            }
            j += skip;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.offset++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = this.in.read(bArr);
        if (read != -1) {
            this.offset += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.offset += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.in.skip(j);
        this.offset += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }
}
