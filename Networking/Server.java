package com.mph;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        ServerSocket server;
        try{
            server = new ServerSocket(49684);
            while(true){
                Socket client = server.accept();
                System.out.println("client connected");

                InputStream is = client.getInputStream();
                BufferedReader br =new BufferedReader(new InputStreamReader(is));
                System.out.println(br.readLine());
                br.close();

                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        ServerSocket server;
//        try{
//            server = new ServerSocket(49684);
//            while(true){
//                Socket client = server.accept();
//                System.out.println("client connected");
//
//                OutputStream output = client.getOutputStream();
//                PrintWriter pw = new PrintWriter(new OutputStreamWriter(output));
//                pw.write("Hello sent from server");
//                pw.close();
//               client.close();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//	ServerSocket server;
//        try{
//            server = new ServerSocket(49684);
//
//            Socket client = server.accept();
//
//            System.out.println("Client connected");
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
