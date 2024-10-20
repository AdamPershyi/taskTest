package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecordFilter {

    public List<Record> filter(List<Record> records, Query query) {
        List<Record> result = new ArrayList<>();

        for (Record record : records) {
            if (matches(record, query)) {
                result.add(record);
            }
        }

        return result;
    }

    private boolean matches(Record record, Query query) {
        return matchesPattern(query.getServiceIdPattern(), record.getServiceId())
                && matchesPattern(query.getQuestionTypeIdPattern(), record.getQuestionTypeId())
                && record.getResponseType() == query.getResponseType()
                && !record.getDate().before(query.getDateFrom())
                && !record.getDate().after(query.getDateTo());
    }

    private boolean matchesPattern(String pattern, String value) {
        if (pattern.equals("*")) {
            return true;
        }

        return value.equals(pattern) || value.startsWith(pattern + ".");
    }
}