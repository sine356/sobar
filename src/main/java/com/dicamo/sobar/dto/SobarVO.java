package com.dicamo.sobar.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SobarVO {
    private String uuid;
    private List<String> productCode;
    private int labelId;
}
