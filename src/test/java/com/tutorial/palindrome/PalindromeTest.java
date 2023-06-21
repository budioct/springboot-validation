package com.tutorial.palindrome;

import com.tutorial.bean.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootTest
public class PalindromeTest {

    /**
     * Custom Constraint
     * ● Salah satu keuntungan ketika menggunakan Validator yang dibuat secara otomatis oleh Spring,
     * yaitu kita bisa membuat Custom Constraint, yang secara otomatis akan dijadikan bean oleh Spring
     * ● Dengan begitu, kita juga bisa menambahkan dependency injection terhadap bean Custom Constraint tersebut
     * ● Ini memudahkan ketika misal kita ingin membuat validasi, yang memerlukan bean Object yang lain
     */

    @Autowired
    private Validator validator;

    @Test
    void testPalindromeValid() {

        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("kodok"));

        Assertions.assertTrue(constraintViolations.isEmpty());
        // Assertions.assertEquals(0, constraintViolations.size());

    }

    @Test
    void testPalindromeInvalid() {

        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(new Foo("budhi"));

        // tidak palindrome
        Assertions.assertFalse(constraintViolations.isEmpty());
        Assertions.assertEquals(1, constraintViolations.size());

    }

    @Test
    void testPalindromeInvalidMessage(){

        var foo = new Foo("budhi");
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(foo);
        Assertions.assertFalse(constraintViolations.isEmpty());

        String message = constraintViolations.stream().findFirst().get().getMessage(); // mendapat message palindrome di file messages.properties
        Assertions.assertEquals("Data bukan palindrome", message);

    }

}
