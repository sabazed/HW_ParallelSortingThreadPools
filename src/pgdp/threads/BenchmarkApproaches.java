package pgdp.threads;

import org.openjdk.jmh.annotations.*;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class BenchmarkApproaches {
    private static final int SIZE = 100_000;

    public static void main(String[] args) throws Exception {

//        Instant start, end;
//        Duration timeElapsed;
//        start = Instant.now();
////        final Comparable[] array1 = Util.randomArrayWithSeed(SIZE, 0);
//        final Integer[] array1 = new Integer[]{1, 4, 6, 3, 7, 2, 0, 5};
//        final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
//        forkJoinPool.invoke(new ParallelMergeSort(array1));
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
//        for (Integer num : array1) System.out.print(num + " ");
//        System.out.println("\n");
//
//        start = Instant.now();
////        final Comparable[] array = Util.randomArrayWithSeed(SIZE, 0);
//        final Integer[] array = new Integer[]{1, 4, 6, 3, 7, 2, 0, 5};
//        MergeSort.mergesort(array);
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
//        for (Integer num : array) System.out.print(num + " ");
//        System.out.println("\n");
//
//        start = Instant.now();
////        final Comparable[] array2 = Util.randomArrayWithSeed(SIZE, 0);
//        final Integer[] array2 = new Integer[]{1, 4, 6, 3, 7, 2, 0, 5};
//        final ForkJoinPool forkJoinPool1 = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
//        forkJoinPool1.invoke(new BetterParallelMergeSort(array2));
//        end = Instant.now();
//        timeElapsed = Duration.between(start, end);
//        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
//        for (Integer num : array2) System.out.print(num + " ");
//        System.out.println("\n");

        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void benchSequential() {
        final Comparable[] array = Util.randomArrayWithSeed(SIZE, 0);
        MergeSort.mergesort(array);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void benchParallel() {
        final Comparable[] array = Util.randomArrayWithSeed(SIZE, 0);
        final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        forkJoinPool.invoke(new ParallelMergeSort(array));
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void benchParallelSmart() {
        final Comparable[] array = Util.randomArrayWithSeed(SIZE, 0);
        final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        forkJoinPool.invoke(new BetterParallelMergeSort(array));
    }
}
