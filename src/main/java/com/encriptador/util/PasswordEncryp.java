package com.encriptador.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryp {

    public static String encryptMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña en MD5", e);
        }
    }
}
