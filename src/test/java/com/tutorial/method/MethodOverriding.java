package com.tutorial.method;

import com.tutorial.helper.SayHello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@SpringBootTest
public class MethodOverriding {

    /**
     * Method Overriding
     * ● Salah satu praktek yang banyak dilakukan oleh programmer Spring adalah membuat kontrak
     *   berupa interface, dan membuat bean berupa class implementasi dari interface tersebut
     * ● Namun hati-hati jika menggunakan Interface sebagai kontrak, karena misal ketika kita override
     *   method nya di class, lalu di dalam method tersebut kita tambahkan annotation untuk bean validation, maka secara otomatis akan terjadi error
     * ● Hal ini dikarenakan, bean validation mendeteksi bahwa terjadi perubahan di method overriding nya
     *
     * Akan Error:
     * org.opentest4j.AssertionFailedError: Unexpected exception type thrown ==> expected: <javax.validation.ConstraintViolationException> but was: <javax.validation.ConstraintDeclarationException>
     *     Caused by: javax.validation.ConstraintDeclarationException: HV000151: A method overriding another method must not redefine the parameter constraint configuration, but method SayHello#sayHello(String) redefines the configuration of ISayHello#sayHello(String).
     *
     * Solusinya?
     * ● Solusinya yang paling baik adalah, memindahkan semua annotation ke Interface nya
     * ● Dengan demikian bean validation tidak akan mendeteksi adanya perubahan pada Method overriding nya
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
