package com.ims;

import java.io.*;
import com.google.gson.*;


public class CredManage {
    private String[][] creds;
    static Gson wgson;
    
    public CredManage(){
        try {
            
            BufferedReader br = new BufferedReader(
                new FileReader(System.getProperty("user.dir") + "\\credentials.json")
            );
            Gson gson = new Gson();
            this.creds = gson.fromJson(br, String[][].class);
            br.close();
            
            }catch(Exception e){
                System.out.println("" + e);
                
                return;
        }
    }
    
    protected String[][] getCredentials(){
        return this.creds;
    }
    
    static void writeCredentials(String[][] cred) throws IOException {
        try (PrintWriter outs = new PrintWriter(System.getProperty("user.dir") + "\\credentials.json")) {
            outs.print(wgson.toJson(cred));
        }catch(IOException ex){};
    }
}
