package com.groundZer0.Autobazar.server;

import com.groundZer0.Autobazar.server.User.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    try(ServerSocket serverSocket = new ServerSocket(8080)){
            System.out.println("ServerSocket awaiting connections...");
	        Socket socket = serverSocket.accept();
            System.out.println("Connection from " + socket + "!");


            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            ObjectOutputStream to_client = new ObjectOutputStream(socket.getOutputStream());

            List<User> users = (List<User>) objectInputStream.readObject();
            System.out.println("length of received users" + users.size());

            System.out.println("Closing sockets.");
            serverSocket.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//	        while (true){
//                new Thread(serverSocket.accept()).start();
//            }
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
    }
}