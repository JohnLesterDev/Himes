/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ims;

import com.ims.*;
import com.google.gson.*;


public class App {

    public static void main(String[] args) {
        
        CredManage creds = new CredManage();
        
        LoginPage loginPage = new LoginPage(creds.getCredentials());
    }
}
