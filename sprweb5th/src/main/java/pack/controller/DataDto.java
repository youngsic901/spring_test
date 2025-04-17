package pack.controller;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DataDto {
    private String id, name;
    private int price;
    private LocalDate regDate;
}
