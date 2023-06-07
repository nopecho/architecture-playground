package nopecho.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;


class LongIdGeneratorTest {

    private final int THREAD_COUNT = 200;
    private final int ID_COUNT_PER_THREAD = 4000;

    LongIdGenerator sut;

    @Test
    void name() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<List<Long>>> futures = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            Future<List<Long>> future = executorService.submit(() -> {
                List<Long> ids = new ArrayList<>();
                for (int j = 0; j < ID_COUNT_PER_THREAD; j++) {
                    long gen = sut.gen();
                    ids.add(gen);
                }
                return ids;
            });
            futures.add(future);
        }

        Set<Long> idSet = new HashSet<>();
        for (Future<List<Long>> future : futures) {
            List<Long> ids = future.get();
            for (Long id : ids) {
                if (idSet.contains(id)) {
                    System.out.println("Duplicate ID found!");
                    return;
                }
                idSet.add(id);
            }
        }

        System.out.println("Test passed!");
        executorService.shutdown();
    }
}