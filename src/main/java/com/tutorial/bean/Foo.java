package com.tutorial.bean;

import com.tutorial.validationcostume.Palindrome;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo {

    // bean foo di set palindrome

    @Palindrome
    private String bar;

}
