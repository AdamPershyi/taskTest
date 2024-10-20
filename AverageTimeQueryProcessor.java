package org.example;

import org.example.interfaces.QueryProcessor;

import java.util.List;

public class AverageTimeQueryProcessor implements QueryProcessor {
    private final Query query;
    private final RecordFilter recordFilter;

    public AverageTimeQueryProcessor(Query query) {
        this.query = query;
        this.recordFilter = new RecordFilter();
    }

    @Override
    public void process(List<Record> records) {
        List<Record> filteredRecords = recordFilter.filter(records, query);
        int totalTime = 0;
        int count = filteredRecords.size();

        for (Record record : filteredRecords) {
            totalTime += record.getWaitingTime();
        }

        if (count > 0) {
            int averageTime = totalTime / count;
            System.out.println(averageTime);
        } else {
            System.out.println("-");
        }
    }
}
