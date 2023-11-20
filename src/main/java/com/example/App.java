package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) {
        try{
            Socket mioSocket = new Socket("localhost", 6789);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
            DataOutputStream outVersoServer = new DataOutputStream(mioSocket.getOutputStream());

            String stringaServer;
            String st;
            
            do{
                System.out.println("Digita un messaggio oppure EXIT per uscire");
                st = in.readLine();    
                outVersoServer.writeBytes(st + '\n');
                stringaServer = inDalServer.readLine();
                System.out.println( stringaServer );
                if(st.equals("EXIT")){
                    mioSocket.close();
                }
            } while (true);
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione!");
            System.exit(1);
        }
    }
}
