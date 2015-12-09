package com.example.alfredocerezoluna.fragmentniceway.android;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by alfredocerezoluna on 9/12/15.
 */
public class ThreadCommandExecutor implements CommandExecutor {

    private static final int CORE_POLL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    public ThreadCommandExecutor(ThreadPoolExecutor mThreadPoolExecutor) {
        this.mThreadPoolExecutor = mThreadPoolExecutor;
    }

    public ThreadCommandExecutor() {
        this.mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POLL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    public ThreadCommandExecutor(int corePullSize, int maxPollSize, int keepAliveTime, TimeUnit timeUnit) {
        this.mThreadPoolExecutor = new ThreadPoolExecutor(corePullSize, maxPollSize, keepAliveTime, timeUnit, WORK_QUEUE);
    }


    @Override
    public void run(Command command) {
        if (command == null) {
            throw new RuntimeException("command cannot be null");
        }
        mThreadPoolExecutor.submit(command);
    }
}
