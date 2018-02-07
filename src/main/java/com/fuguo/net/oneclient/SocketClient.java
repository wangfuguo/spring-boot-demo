package com.fuguo.net.oneclient;

import java.io.*;
import java.net.Socket;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-02-05 13:37
 * @since V1.0.0
 */
public class SocketClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 2018);
            socket.setSoTimeout(60000);

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String result = "";
            while (result.indexOf("bye") == -1) {
                BufferedReader sysBuff = new BufferedReader(new InputStreamReader(System.in));
                printWriter.println(sysBuff.readLine());
                printWriter.flush();

                result = bufferedReader.readLine();
                System.out.println("Server say : " + result);
            }

            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
