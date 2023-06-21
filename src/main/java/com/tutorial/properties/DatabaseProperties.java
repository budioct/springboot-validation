package com.tutorial.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@ConfigurationProperties("database") // set properties
@Validated
public class DatabaseProperties {

    /**
     * Configuration Properties
     * ● Sebelumnya kita sudah belajar tentang Configuration Properties di Spring
     * ● Spring mendukung validasi bean Configuration Properties secara otomatis dengan Bean Validation
     * ● Hal ini bisa memastikan bahwa data di Configuration Properties sudah valid, jika tidak valid, maka
     *   secara otomatis pembuatan bean akan gagal, dan aplikasi akan berhenti
     *
     *   jika kita belum set database.username dan database.password application.properties. maka akan error seperti di bawah
     *
     *   Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
     * 2023-06-21 14:02:31.754 ERROR 13860 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   :
     *
     * ***************************
     * APPLICATION FAILED TO START
     * ***************************
     *
     * Description:
     *
     * Binding to target org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'database' to com.tutorial.properties.DatabaseProperties failed:
     *
     *     Property: database.username
     *     Value: "null"
     *     Reason: must not be blank
     *
     *     Property: database.password
     *     Value: "null"
     *     Reason: must not be blank
     *
     *
     * Action:
     *
     * Update your application's configuration
     *
     * supaya tidak error kita tambahkan key dan value di application.properties, seperti di bawah
     * database.username=budhi
     * database.password=budhi
     */

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
