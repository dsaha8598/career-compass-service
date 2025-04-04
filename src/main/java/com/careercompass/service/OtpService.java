package com.careercompass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {

    @Autowired
    private EmailService emailService;

    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();
    private final Map<String, LocalDateTime> otpExpiry = new ConcurrentHashMap<>();
    private final SecureRandom random = new SecureRandom();


    // Generate a random 6-digit OTP
    public String generateOtp() {
        return String.format("%06d", random.nextInt(1000000));
    }

    public String sendOtp(String email) {
        String otp = generateOtp();
        otpStorage.put(email, otp);
        otpExpiry.put(email, LocalDateTime.now().plusMinutes(10));
        return emailService.sendOtpEmail(email,otp);
    }

    public String validateOtp(String email, String otp) {
        if (!otpStorage.containsKey(email) || LocalDateTime.now().isAfter(otpExpiry.get(email))) {
            return "OTP expired";
        }
        if (!otpStorage.get(email).equals(otp)) {
            return "Invalid OTP";
        }
        otpStorage.remove(email); // Remove OTP after successful validation
        otpExpiry.remove(email);
        return "Authentication Successfull";
    }
}

