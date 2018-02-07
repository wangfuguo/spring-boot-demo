package com.fuguo.net.oneclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-02-05 13:36
 * @since V1.0.0
 */
public class SocketServer {

    public static void main(String[] args){

        try {
            ServerSocket serverSocket = new ServerSocket(2018);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String readLine = bufferedReader.readLine();
                System.out.println("Client say :" + readLine);

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.print("Hello Client, I am server!");
                printWriter.flush();

                bufferedReader.close();
                printWriter.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
