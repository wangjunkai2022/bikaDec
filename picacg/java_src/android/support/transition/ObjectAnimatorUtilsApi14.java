package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.RequiresApi;
import android.util.Property;
@RequiresApi(14)
/* loaded from: classes.dex */
class ObjectAnimatorUtilsApi14 implements ObjectAnimatorUtilsImpl {
    @Override // android.support.transition.ObjectAnimatorUtilsImpl
    public <T> ObjectAnimator ofInt(T t, String str, String str2, Path path) {
        Class<?> cls = t.getClass();
        return ObjectAnimator.ofFloat(t, new PathProperty(new CastIntegerProperty(Property.of(cls, Integer.class, str)), new CastIntegerProperty(Property.of(cls, Integer.class, str2)), path), 0.0f, 1.0f);
    }

    @Override // android.support.transition.ObjectAnimatorUtilsImpl
    public <T> ObjectAnimator ofInt(T t, Property<T, Integer> property, Property<T, Integer> property2, Path path) {
        return ObjectAnimator.ofFloat(t, new PathProperty(new CastIntegerProperty(property), new CastIntegerProperty(property2), path), 0.0f, 1.0f);
    }

    @Override // android.support.transition.ObjectAnimatorUtilsImpl
    public <T> ObjectAnimator ofFloat(T t, Property<T, Float> property, Property<T, Float> property2, Path path) {
        return ObjectAnimator.ofFloat(t, new PathProperty(property, property2, path), new float[0]);
    }

    /* loaded from: classes.dex */
    private static class CastIntegerProperty<T> extends Property<T, Float> {
        private final Property<T, Integer> mProperty;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(Object obj) {
            return get((CastIntegerProperty<T>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
            set2((CastIntegerProperty<T>) obj, f);
        }

        CastIntegerProperty(Property<T, Integer> property) {
            super(Float.class, property.getName());
            this.mProperty = property;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.util.Property
        public Float get(T t) {
            return Float.valueOf(this.mProperty.get(t).intValue());
        }

        /* renamed from: set  reason: avoid collision after fix types in other method */
        public void set2(T t, Float f) {
            this.mProperty.set(t, Integer.valueOf(Math.round(f.floatValue())));
        }
    }

    /* loaded from: classes.dex */
    private static class PathProperty<T> extends Property<T, Float> {
        private float mCurrentFraction;
        private final float mPathLength;
        private final PathMeasure mPathMeasure;
        private final float[] mPosition;
        private final Property<T, Float> mXProperty;
        private final Property<T, Float> mYProperty;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(Object obj) {
            return get((PathProperty<T>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
            set2((PathProperty<T>) obj, f);
        }

        PathProperty(Property<T, Float> property, Property<T, Float> property2, Path path) {
            super(Float.class, property.getName() + "/" + property2.getName());
            this.mPosition = new float[2];
            this.mXProperty = property;
            this.mYProperty = property2;
            this.mPathMeasure = new PathMeasure(path, false);
            this.mPathLength = this.mPathMeasure.getLength();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.util.Property
        public Float get(T t) {
            return Float.valueOf(this.mCurrentFraction);
        }

        /* renamed from: set  reason: avoid collision after fix types in other method */
        public void set2(T t, Float f) {
            this.mCurrentFraction = f.floatValue();
            this.mPathMeasure.getPosTan(this.mPathLength * f.floatValue(), this.mPosition, null);
            this.mXProperty.set(t, Float.valueOf(this.mPosition[0]));
            this.mYProperty.set(t, Float.valueOf(this.mPosition[1]));
        }
    }
}
