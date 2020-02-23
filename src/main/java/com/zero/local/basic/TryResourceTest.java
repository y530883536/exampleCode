package com.zero.local.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryResourceTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream1 = null;
        try {
            fileInputStream1 = new FileInputStream("C:/ycf/test.conf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try(FileInputStream fileInputStream2 = new FileInputStream("C:/ycf/test.conf")){
            System.out.println(fileInputStream2.read());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
