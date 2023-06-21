package com.tutorial.method;

import com.tutorial.helper.SayHello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@SpringBootTest
public class MethodValidationTest {

    /**
     * Method Validation
     * ● Di kelas Java Validation, kita sudah banyak membahas tentang validasi di level Method
     * ● Namun sayangnya, menggunakan Bean Validation untuk melakukan validation di level method sangat ribet
     * ● Untungnya hal ini dibantu dengan fitur Bean Post Processor nya Spring
     * ● Spring menggunakan class MethodValidationPostProcessor akan secara otomatis mencari bean
     *   yang memiliki annotation @Validated di class nya, dan secara otomatis akan melakukan validasi di
     *   setiap method yang terdapat di bean tersebut jika terdapat annotation Bean Validation
     * ● Kita tidak perlu meregistrasikan MethodValidationPostProcessor secara manual, itu sudah otomatis dibuat oleh class ValidationAutoConfiguration
     * ● Jika terjadi validasi error, secara otomatis akan throw ConstraintViolationException
     */

    @Autowired
    SayHello sH;

    @Test
    void testMethodSuccess(){

        String budhi = sH.sayHello("budhi");
        Assertions.assertEquals("Hello budhi", budhi);

    }

    @Test
    void testError(){

        // kalaupun Error harus ConstraintViolationException.class

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            sH.sayHello("");
        });

    }


}
