package com.bit.careChart.model;

import lombok.Data;

@Data
public class HistoryDiagnoseDTO {
    int historyId;
    String diagnoseCode;
    String diagnoseName;
    int diagnoseDose;
    int diagnoseTime;
    int diagnoseDays;
}
