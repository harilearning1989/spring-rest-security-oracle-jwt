package com.web.demo.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    // Runs every 2 minutes (in milliseconds)
    @Scheduled(fixedRate = 60 * 1000) // 1 minutes in milliseconds
    public void runEveryOneMinutes() {
        System.out.println("Running task at " + java.time.LocalDateTime.now());
        Runtime runtime = Runtime.getRuntime();
        long totalHeap = runtime.totalMemory();
        long maxHeap = runtime.maxMemory();
        long freeHeap = runtime.freeMemory();
        long usedHeap = totalHeap - freeHeap;

        System.out.println("Max Heap (bytes): " + (maxHeap / 1024 / 1024 + " MB")
                + "===Initial Heap (totalMemory): " + (totalHeap / 1024 / 1024 + " MB")
                + "===Free Heap (freeMemory): " + (freeHeap / 1024 / 1024 + " MB")
                + "===Used Heap: " + (usedHeap / 1024 / 1024) + " MB");

    }

    // Runs every 5 minutes (in milliseconds)
    @Scheduled(fixedRate = 55 * 60 * 1000) // 55 minutes in milliseconds
    public void runEveryFiveMinutes() {
        System.out.println("Running task at " + java.time.LocalDateTime.now());
        // your method logic here
    }

    // Runs every 15 minutes (in milliseconds)
    @Scheduled(fixedRate = 15 * 60 * 60 * 1000) // 15 hours in milliseconds
    public void runEveryFiveHours() {
        System.out.println("Running every 5 hours at " + java.time.LocalDateTime.now());
    }


}
