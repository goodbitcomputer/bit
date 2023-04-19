package com.bit.careChart.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryDTO {
    int employeeId;
    int patientId;
    int deptId;
    int bpSystolic;
    int bpDiastolic;
    int height;
    int weight;
    int temperature;
    String symptom_detail;
    LocalDateTime entryDate;
    String visit;
}
