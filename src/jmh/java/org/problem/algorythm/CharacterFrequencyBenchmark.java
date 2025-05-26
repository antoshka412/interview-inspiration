package org.problem.algorythm;

import org.apache.commons.text.CharacterPredicate;
import org.apache.commons.text.RandomStringGenerator;
import org.openjdk.jmh.annotations.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class CharacterFrequencyBenchmark {

    @Param({"1000", "10000", "100000", "1000000"})
    public int inputSize;

    private String input;

    @Setup(Level.Trial)
    public void setup() {
        CharacterPredicate letterDigitOrAt = codePoint ->
                (codePoint >= 'a' && codePoint <= 'z') ||
                        (codePoint >= 'A' && codePoint <= 'Z') ||
                        (codePoint >= '0' && codePoint <= '9') ||
                        codePoint == '@';

        RandomStringGenerator generator = new RandomStringGenerator.Builder().filteredBy(letterDigitOrAt).build();

        input = generator.generate(inputSize);
    }

    @Benchmark
    public Map<Character, Integer> baseline() {
        return CharacterFrequencySorter.countAndSortCharacters(input);
    }

    @Benchmark
    public Map<Character, Integer> optimised() {
        return CharacterFrequencySorter.countAndSortCharactersOptimised(input);
    }

    @Benchmark
    public Map<Character, Integer> bitwise() {
        return CharacterFrequencySorter.countAndSortCharactersBitWise(input);
    }
}
