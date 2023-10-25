package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("10.22.9.3", 6789);

            Scanner scanner = new Scanner(System.in);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.print("Connessione effettuata\n");
            System.out.print("Inserisci un numero: ");
            int num = scanner.nextInt();
            scanner.nextLine();

            out.writeBytes(String.valueOf(num) + "\n");

            String risposta = in.readLine();
            while (true) {
                
                if (risposta.equals("1")) {
                    System.out.print("Numero piccolo\n");
                } else if (risposta.equals("2")) {
                    System.out.print("numero grande\n");
                } else {
                    break;
                }

                System.out.print("Inserisci un numero: ");
                num = scanner.nextInt();
                scanner.nextLine();
                out.writeBytes(String.valueOf(num) + "\n");

                risposta = in.readLine();
            }

            System.out.print("Numero indovinato\n");
            scanner.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}