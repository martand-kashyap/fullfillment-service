package org.example.fullfillment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}
