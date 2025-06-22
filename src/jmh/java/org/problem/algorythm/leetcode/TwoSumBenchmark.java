package org.problem.algorythm.leetcode;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime) // measures operations per second
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class TwoSumBenchmark {

    @Param({"1000", "10000", "100000", "1000000"})
    public int inputSize;

    private int[] nums;
    private int target;

    @Setup(Level.Invocation)
    public void setup() {
        // Generate large random array for benchmarking
        int size = inputSize;
        nums = new int[size];
        Random rand = new Random(12345);

        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextInt(size * 2);
        }

        // Pick random target guaranteed to be sum of two numbers in the array
        int i = rand.nextInt(size - 1);
        int j = rand.nextInt(size - 1);
        if (i == j) {
            j = (j + 1) % size;
        }

        target = nums[i] + nums[j];
    }

    @Benchmark
    public int[] benchmarkTwoSumHashMap() {
        return TwoSum.twoSumHashMap(nums, target);
    }

    @Benchmark
    public int[] benchmarkTwoSumFastUtil() {
        return TwoSum.twoSumInt2IntOpenHashMap(nums, target);
    }

}
