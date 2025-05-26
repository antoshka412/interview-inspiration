package org.problem.algorythm;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CharacterFrequencyBenchmark {

    public static void main(String[] args) throws IOException {
        int[] sizes = {1000, 10000, 100000, 1000000};
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@";
        Random random = new Random();


        String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(Instant.now().atZone(ZoneId.systemDefault()));

        try (PrintWriter writer = new PrintWriter("benchmark/CharacterFrequencyBenchmark_" + timestamp + ".csv")) {
            writer.println("Method,InputSize,TimeMillis");

            for (int size : sizes) {
                StringBuilder inputBuilder = new StringBuilder(size);
                for (int i = 0; i < size; i++) {
                    inputBuilder.append(characters.charAt(random.nextInt(characters.length())));
                }
                String input = inputBuilder.toString();

                // Benchmark Method 1: HashMap + TreeMap
                long startTime = System.nanoTime();
                CharacterFrequencySorter.countAndSortCharacters(input);
                long duration = System.nanoTime() - startTime;
                writer.printf("HashMap + TreeMap,%d,%.3f%n", size, duration / 1_000_000.0);

                // Benchmark Method 2: Optimized Array
                startTime = System.nanoTime();
                CharacterFrequencySorter.countAndSortCharactersOptimised(input);
                duration = System.nanoTime() - startTime;
                writer.printf("Optimized Array,%d,%.3f%n", size, duration / 1_000_000.0);

                // Benchmark Method 3: Bitwise operations
                startTime = System.nanoTime();
                CharacterFrequencySorter.countAndSortCharactersBitWise(input);
                duration = System.nanoTime() - startTime;
                writer.printf("Bitwise operations Array,%d,%.3f%n", size, duration / 1_000_000.0);
            }
        }
    }
}