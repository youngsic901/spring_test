package pack.controller;

import lombok.Data;

@Data
public class TodoRequest { // FormBean 역할
    private String title;
    private Integer order;
    private Boolean completed;
}
