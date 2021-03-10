package com.mph;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.SocketHandler;

public class Client {
    public static void main(String[] args) {

        try {
            Socket server = new Socket("localhost", 49684);
            OutputStream output = server.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(output));
            pw.write("Hello sent from client");
            pw.close();
            server.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


//        try{
//            Socket server = new Socket("localhost",49684);
//            InputStream is = server.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            System.out.println(br.readLine());
//            br.close();
//            server.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }


//        try {
//            new Socket("DESKTOP-997TM2J",49684);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
