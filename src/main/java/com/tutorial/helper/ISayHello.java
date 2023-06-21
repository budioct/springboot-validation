package com.tutorial.helper;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface ISayHello {

    String sayHello(@NotBlank String name);

}
