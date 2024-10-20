package org.example;

import java.util.Date;


public class Query {
    private final String serviceIdPattern;
    private final String questionTypeIdPattern;
    private final char responseType;
    private final Date dateFrom;
    private final Date dateTo;

    public Query(String serviceIdPattern, String questionTypeIdPattern, char responseType, Date dateFrom, Date dateTo) {
        this.serviceIdPattern = serviceIdPattern;
        this.questionTypeIdPattern = questionTypeIdPattern;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getServiceIdPattern() {
        return serviceIdPattern;
    }

    public String getQuestionTypeIdPattern() {
        return questionTypeIdPattern;
    }

    public char getResponseType() {
        return responseType;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }
}
