package com.example.crud;

import lombok.Data;

import java.util.List;

@Data
public class User1 {
    private Integer sex;
    private List<Clothes1> clothesList;
}
