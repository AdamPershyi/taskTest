package org.example;

import java.util.Date;

public class Record {
    private final String serviceId;
    private final String questionTypeId;
    private final char responseType;
    private final Date date;
    private final int waitingTime;

    public Record(String serviceId, String questionTypeId, char responseType, Date date, int waitingTime) {
        this.serviceId = serviceId;
        this.questionTypeId = questionTypeId;
        this.responseType = responseType;
        this.date = date;
        this.waitingTime = waitingTime;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public char getResponseType() {
        return responseType;
    }

    public Date getDate() {
        return date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }
}
