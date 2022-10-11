package com.ims;

import java.security.*;


public class Encryption {
    
    public static String toHash(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b: digest) {
            sb.append(String.format("%02x", b & 0xff));
        };
        
        String hashed = sb.toString();
        
        return hashed;
    }
}
