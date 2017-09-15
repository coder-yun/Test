package com.yun.concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by caiyunwu on 2017/3/22.
 */
public class ArrayBlockingQueue<E> {
    final Object[] items;
    int putIndex, takeIndex, count;
    final ReentrantLock lock;
    final Condition notFull;
    final Condition notEmpty;

    public ArrayBlockingQueue(int capacity, boolean fairness) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        items = new Object[capacity];
        lock = new ReentrantLock(fairness);
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public ArrayBlockingQueue(int capacity) {
        this(capacity, false);
    }

    public void put(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putIndex] = e;
            if (++putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
             E e=(E)items[takeIndex];
            items[takeIndex]=null;
            if (++takeIndex == items.length) {
                takeIndex=0;
            }
            count--;
            notFull.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }
}
