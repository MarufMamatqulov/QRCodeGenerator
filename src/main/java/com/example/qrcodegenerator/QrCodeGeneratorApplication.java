package com.example.qrcodegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QrCodeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrCodeGeneratorApplication.class, args);
    }

    @Bean
    public QRCodeGeneratorService qrCodeGeneratorService() {
        return new QRCodeGeneratorService();
    }
}
