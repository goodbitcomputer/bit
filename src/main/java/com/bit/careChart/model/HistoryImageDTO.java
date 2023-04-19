package com.bit.careChart.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryImageDTO {
    int historyId;
    String imagePath;
    LocalDateTime entryDate;
    String categoryId;
}
