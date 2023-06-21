package com.tutorial.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @NotBlank // @NotBlank field tidak boleh kosong
    private String id;


    @NotBlank
    private String name;

}
