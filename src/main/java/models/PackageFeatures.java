package models;


import lombok.*;




@Builder
@Data
public class PackageFeatures {
    private int limit;
    private double price;
    private int count;
}
