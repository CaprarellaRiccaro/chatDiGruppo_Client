package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) {
        try{
            //inizializzazione delle variabili
            String nomeServer = null;
            Socket mioSocket = new Socket(nomeServer, 6789);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
            DataOutputStream outVersoServer = new DataOutputStream(mioSocket.getOutputStream());

            String lista[];
            String st;

            //Scelta dello username
            System.out.println("Digita username");
            st = in.readLine();
            outVersoServer.writeBytes(st);
            nomeServer = st;
            
            System.out.println(nomeServer);

            do{

                System.out.println("Digita un messaggio oppure EXIT per uscire");
                st = in.readLine();    
                outVersoServer.writeBytes(nomeServer + " : " + st + '\n');

            } while (!st.equals("EXIT"));
            
            mioSocket.close();
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione!");
            System.exit(1);
        }
    }
}
