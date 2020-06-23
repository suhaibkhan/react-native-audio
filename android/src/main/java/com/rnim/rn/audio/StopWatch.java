package com.rnim.rn.audio;

import java.lang.System;

public class StopWatch {
    private long start;
    private long elapsedTime = 0;
    private boolean paused = true;

    public StopWatch() {
    }

    public void start() {
        start = System.currentTimeMillis();
        paused = false;
    }

    public float stop() {
        if (!paused) {
            long now = System.currentTimeMillis();
            elapsedTime += (now - start);
            paused = true;
        }

        return elapsedTime;
    }

    public void reset() {
        start = 0;
        elapsedTime = 0;
        paused = true;
    }

    public float getTimeSeconds() {
        return getTimeMillis() / 1000f;
    }

    public long getTimeMillis() {
        long millis;

        if (paused) {
            millis = elapsedTime;
        } else {
            long now = System.currentTimeMillis();
            millis = elapsedTime + (now - start);
        }
        return millis;
    }
}