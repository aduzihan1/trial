package com.dzh.trial.trial.tryIO.executor;

import com.dzh.trial.trial.tryIO.entity.User;

import java.io.*;

public class WriteAndReadObject implements Serializable{
    public static void main(String[] args) {
        /*User user = new User();
        user.setAge(12);
        user.setUname("name");
        user.setId("123");
        try(OutputStream ops = new FileOutputStream("/Users/dzh/Desktop/User.txt");ObjectOutputStream os = new ObjectOutputStream(ops)){
            os.writeObject(user);

        }catch (Exception e){

        }finally {

        }
        try(
            InputStream inputStream = new FileInputStream("/Users/dzh/Desktop/User.txt");
            ObjectInputStream ois = new ObjectInputStream(inputStream)){
            User userRead = (User)ois.readObject();
            System.out.println(userRead.toString());
        }catch (Exception e){

        }*/
        String a = "abc";
        String b = a;
        String c = "bcd";
        b = c;
        System.out.println("a:" + a + ";b:" + b + ";c:" +c);
    }
}
