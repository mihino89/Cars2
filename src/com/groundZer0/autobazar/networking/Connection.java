package com.groundZer0.autobazar.networking;

import com.groundZer0.autobazar.datamodel.users.User;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection implements Serializable{
    private final String HOST = "localhost";
    private final int PORT = 8080;
    private String response="ahoj";

    private static Connection connection = new Connection();

    public static Connection getConnection(){
        return  connection;
    }

    public void try_connect_with_server(User user){
        System.out.println(user.getEmail());
        try (Socket client_socket = new Socket(HOST, PORT)) {
//            InputStream inputStream = client_socket.getInputStream();
            OutputStream outputStream = client_socket.getOutputStream();

//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // posli user-a
//            List<User> users = new ArrayList<>();
//            users.add(user);

            List<User> users = new ArrayList<>();
            users.add(new User("dsa", "dsa", "dsa", "30-03-2020", "dsa", "dsa", "user"));

            objectOutputStream.writeObject(users);

            client_socket.close();

//            response = to_server.readLine();
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }

//        return response;
    }
}
