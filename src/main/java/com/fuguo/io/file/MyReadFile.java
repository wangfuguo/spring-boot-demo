package com.fuguo.io.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-03-30 15:32
 * @since V1.0.0
 */
public class MyReadFile {

    public static final int READ_BUF_SIZE = 4096;

    public static void main(String[] args) throws IOException {

        readFile4("E:\\maven-demo\\spring-boot-demo\\src\\main\\java\\com\\fuguo\\io\\filedir\\a.txt");
        System.out.println();

    }

    public static void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[READ_BUF_SIZE];
        while (fileInputStream.read(buf) != -1) {
            System.out.print(new String(buf));
        }
    }

    public static void readFile2(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[READ_BUF_SIZE];
        while (bufferedInputStream.read(bytes) != -1) {
            System.out.print(new String(bytes));
        }
    }

    public static void readFile3(String fileName) throws IOException {
        File file = new File(fileName);
        FilterInputStream filterInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[READ_BUF_SIZE];
        while (filterInputStream.read(bytes) != -1) {
            System.out.print(new String(bytes));
        }
    }

    public static void readFile4(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(READ_BUF_SIZE);
        while (channel.read(byteBuffer) != -1) {
            System.out.println(new String(byteBuffer.array()));
        }
    }
}
