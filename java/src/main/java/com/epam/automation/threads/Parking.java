package com.epam.automation.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking<T> {
    private final static int PERMITS = 5;
    private final Semaphore semaphore = new Semaphore(PERMITS, true);
    private final Queue<T> resources = new LinkedList<>();

    public Parking(Queue<T> source) {
        resources.addAll(source);
    }

    public T getResource(long maxWaitMillis) throws ResourceException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                T resource = resources.poll();
                return resource;
            }
        } catch (InterruptedException e) {
            throw new ResourceException(e);
        }
        throw new ResourceException(": превышено время ожидания");
    }

    public void returnResource(T resource) {
        resources.add(resource);
        semaphore.release();
    }
}
