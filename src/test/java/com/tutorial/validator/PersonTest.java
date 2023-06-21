package com.tutorial.validator;

import com.tutorial.bean.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootTest
public class PersonTest {

    /**
     * Validator
     * ● Seperti yang sudah kita tahu, bahwa untuk melakukan validasi, kita perlu membuat object Validator
     * ● Di Spring, Validator otomatis dibuatkan, sehingga kita tidak perlu membuatnya secara manual lagi
     * ● Spring akan secara otomatis membuat bean Validator
     *
     * Validator di Spring
     * ● Pertanyaannya, bagaimana cara Spring membuat bean Validator?
     * ● Spring sendiri membuat bean Validator menggunakan class ValidationAutoConfiguration, dimana
     *   terdapat method untuk membuat Validator menggunakan FactoryBean LocalValidatorFactoryBean
     * ● Jika kita mau, kita juga bisa membuat bean Validator sendiri, namun sangat disarankan menggunakan Validator yang dibuat oleh Spring
     *
     *  jika ingin melihat objectnya
     *  ValidationAutoConfiguration.java
     *
     */

    @Autowired
    Validator validator;

    @Test
    void testPersonNotValid(){

        var person = new Person("", "");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person); // <T> Set<ConstraintViolation<T>> validate(T var1, Class<?>... var2); // membaca detail class dengan reflection

        Assertions.assertFalse(constraintViolations.isEmpty()); // boolean isEmpty() // cek apakah sebenernya beberapa field ada yang tidak di isi
        Assertions.assertEquals(2, constraintViolations.size()); // int size() // ukuran field yang tidak di isi

    }

    @Test
    void testPersonValid(){

        var person = new Person("1", "budhi");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person); // <T> Set<ConstraintViolation<T>> validate(T var1, Class<?>... var2); // membaca detail class dengan reflection

        Assertions.assertTrue(constraintViolations.isEmpty()); // boolean isEmpty() // cek apakah sebenernya beberapa field ada yang tidak di isi

    }


}
