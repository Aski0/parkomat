package com.example.parkomat.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final QrCodeService qrCodeService;

    public EmailService(JavaMailSender mailSender, QrCodeService qrCodeService) {
        this.mailSender = mailSender;
        this.qrCodeService = qrCodeService;
    }

    public void sendReservationEmail(String toEmail, String parkingCode,
                                     String parkingName, String parkingAddress,
                                     Date reservationDate) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String qrCode = qrCodeService.generateBase64QrCode(parkingCode);

            // Format the date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(reservationDate);

            String emailContent = "<h1>Twoja rezerwacja miejsca parkingowego</h1>"
                    + "<p><strong>Nazwa parkingu:</strong> " + parkingName + "</p>"
                    + "<p><strong>Adres:</strong> " + parkingAddress + "</p>"
                    + "<p><strong>Data rezerwacji:</strong> " + formattedDate + "</p>"
                    + "<p><strong>Kod parkingowy:</strong> " + parkingCode + "</p>"
                    + "<img src='" + qrCode + "' alt='QR Code' style='width:200px;height:200px;'>"
                    + "<p>Przedstaw kod QR po dotarciu na parking</p>"
                    + "<p>Dziękujemy za skorzystanie z usługi PARK-O-MAT i życzymy udanych przygów!</p>";

            helper.setTo(toEmail);
            helper.setSubject("Potwierdzenie rezerwacji mejsca parkingowego - " + parkingName);
            helper.setText(emailContent, true);
            helper.setFrom("noreply@parkomat.com");

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle error appropriately
        }
    }
}