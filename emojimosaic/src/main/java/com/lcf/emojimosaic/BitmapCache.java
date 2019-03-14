package com.lcf.emojimosaic;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class BitmapCache extends LruCache<Integer, Bitmap> {

    Set<WeakReference<Bitmap>> referencesSet = new HashSet<>();
    ReferenceQueue<Bitmap> referenceQueue = null;
    Thread threadClearRefQueue = null;
    boolean isShutDown = false;


    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public BitmapCache(int maxSize) {
        super(maxSize);
    }



    @Override
    protected int sizeOf(Integer key, Bitmap value) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            return value.getAllocationByteCount();
        } else {
            return value.getByteCount();
        }
    }



    @Override
    protected void entryRemoved(boolean evicted, Integer key, Bitmap oldValue, Bitmap newValue) {
        if (oldValue.isMutable()) {
            referencesSet.add(new WeakReference<Bitmap>(oldValue, getReferenceQueue()));
        }
        super.entryRemoved(evicted, key, oldValue, newValue);
    }

    private ReferenceQueue<Bitmap> getReferenceQueue() {
        if (referenceQueue == null) {
            referenceQueue = new ReferenceQueue();
            threadClearRefQueue = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!isShutDown) {
                        clearRefenceQueue();
                    }
                }
            });
            threadClearRefQueue.start();
        }
        return referenceQueue;
    }

    private void clearRefenceQueue() {
        try {
            Reference<? extends Bitmap> remove = referenceQueue.remove();
            Bitmap bitmap = remove.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
