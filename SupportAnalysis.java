package org.example;

import org.example.exceptions.IncorrectException;
import org.example.interfaces.QueryProcessor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupportAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Record> records = new ArrayList<>();

        processInput(scanner, records);
    }

    private static void processInput(Scanner scanner, List<Record> records) {
        int s = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < s; i++) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            try {
                if (line.startsWith("C")) {
                    Record record = InputParser.parseRecord(line);
                    records.add(record);
                } else if (line.startsWith("D")) {
                    Query query = InputParser.parseQuery(line);
                    QueryProcessor processor = new AverageTimeQueryProcessor(query);
                    processor.process(records);
                } else {
                    System.err.println("Invalid line: " + line);
                }
            } catch (ParseException | IncorrectException e) {
                System.err.println("An error occurred while processing the string: " + line);
                System.err.println(e.getMessage());
            }
        }
    }
}
