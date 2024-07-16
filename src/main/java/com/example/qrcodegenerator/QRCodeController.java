package com.example.qrcodegenerator;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class QRCodeController {

    @Autowired
    private QRCodeGeneratorService qrCodeGeneratorService;

    @GetMapping("/generateQRCode")
    public byte[] generateQRCode(@RequestParam String text, @RequestParam int width, @RequestParam int height) {
        try {
            BufferedImage qrCodeImage = qrCodeGeneratorService.generateQRCodeImage(text, width, height);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrCodeImage, "png", baos);
            return baos.toByteArray();
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
