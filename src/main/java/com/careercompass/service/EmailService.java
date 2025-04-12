package com.careercompass.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private final Random random = new Random();

    // Send email with OTP
    public String sendOtpEmail(String toEmail, String otp) {
       try {
           MimeMessage message = mailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
           String fromEmail = "career.compass48@gmail.com"; // Replace with your actual email
           String fromName = "CareerCompass"; // This will be shown as the sender's name

           helper.setFrom(new InternetAddress(fromEmail, fromName)); // Set custom sender name
           helper.setTo(toEmail);
           helper.setSubject("Your OTP Code - CareerCompass");

           // HTML email content with your logo and app name
           String htmlContent = "<!DOCTYPE html>"
                   + "<html lang='en'>"
                   + "<head>"
                   + "<meta charset='UTF-8'>"
                   + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                   + "<title>OTP Verification</title>"
                   + "<style>"
                   + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }"
                   + ".container { width: 100%; padding: 20px; background-color: #ffffff; max-width: 600px; margin: auto; "
                   + "border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); text-align: center; }"
                   + ".header { padding: 10px; background-color: #ff6600; color: white; "
                   + "border-radius: 8px 8px 0 0; }"
                   + ".logo { width: 80px; margin-bottom: 10px; }"
                   + ".app-name { font-size: 20px; font-weight: bold; color: white; }"
                   + ".content { padding: 20px; }"
                   + ".otp-code { font-size: 24px; font-weight: bold; color: #ff6600; background: #fff2e6; "
                   + "padding: 10px; border-radius: 5px; display: inline-block; }"
                   + ".footer { text-align: center; padding: 10px; font-size: 12px; color: #666; }"
                   + "</style>"
                   + "</head>"
                   + "<body>"
                   + "<div class='container'>"
                   + "<div class='header'>"
                   + "<img src='https://storage.googleapis.com/a1aa/image/RLb3e9uXSrTC3cYDHFWmqQTIr39KE6mGyV3KjWVY-u4.jpg' alt='CareerCompass Logo' class='logo'/>"
                   + "<div class='app-name'>CareerCompass</div>"
                   + "</div>"
                   + "<div class='content'>"
                   + "<p>Dear User,</p>"
                   + "<p>Your OTP code is:</p>"
                   + "<div class='otp-code'>" + otp + "</div>"
                   + "<p>Please use this code to complete your verification.</p>"
                   + "<p>Thank you for using <b>CareerCompass</b>!</p>"
                   + "</div>"
                   + "<div class='footer'>"
                   + "<p>&copy; 2025 CareerCompass. All rights reserved.</p>"
                   + "</div>"
                   + "</div>"
                   + "</body>"
                   + "</html>";

           helper.setText(htmlContent, true); // Enable HTML
           mailSender.send(message);
           return "OTP sent successfully";
       }catch(Exception e){
           return "Failed to send OTP, please try again";
       }
    }





}
