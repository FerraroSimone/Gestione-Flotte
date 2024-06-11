package com.flotte.gestioneFlotte.Util;


import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {
// non cambiare key, perdi tutti i dati sono criptati su questa chiave
    private static final String AES_SECRET_KEY = "unaChiaveDi16Byt";

    // criptare 
    public static String encrypt(String plainText) throws Exception {
        SecretKey secretKey = new SecretKeySpec(AES_SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
 //decriptare
    public static String decrypt(String encryptedText) throws Exception {
        SecretKey secretKey = new SecretKeySpec(AES_SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
    
    // Metodo per crittografare il vehicleId
    public static String encryptVehicleId(String vehicleId) {
        try {
            return encrypt(vehicleId);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la crittografia del vehicleId", e);
        }
    }
    
    // Metodo per decrittografare il vehicleId
    public static String decryptVehicleId(String encryptedVehicleId) {
        try {
            return decrypt(encryptedVehicleId);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la decrittografia del vehicleId", e);
        }
    }
}
