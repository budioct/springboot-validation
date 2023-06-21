package com.tutorial.helper;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

// kita menaruh Annotation @Validated di class ini. kita taruh di interface nya. bean validation mendeteksi bahwa terjadi perubahan di method overriding nya
// @Validated // otomatis di baca karna ke springboot sebab dependency Spring Configuration Processor. tidak perlu membuat provide nya untuk validasi method
@Component
public class SayHello implements ISayHello {

    public String sayHello(@NotBlank String name){
        return "Hello " + name;
    }

}
