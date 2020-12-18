package com.dicamo.sobar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private int idx_product;
    private String product_code;
    private String product_name;
}
