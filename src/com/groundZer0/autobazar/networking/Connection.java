package com.groundZer0.autobazar.networking;

import com.groundZer0.autobazar.datamodel.users.User;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Connection implements Serializable{
    private final String HOST = "localhost";
    private final int PORT = 8080;
    private String response="ahoj";

    private static Connection connection = new Connection();

    public static Connection getConnection(){
        return  connection;
    }

    public void try_connect_with_server(User user){
        try (Socket client_socket = new Socket(HOST, PORT)) {
//            InputStream inputStream = client_socket.getInputStream();
            OutputStream outputStream = client_socket.getOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(client_socket.getInputStream());

            System.out.println("test");
            objectOutputStream.writeObject(user);

            User new_user= (User) objectInputStream.readObject();
            System.out.println("User password " + new_user.getPassword());

            client_socket.close();

//            response = to_server.readLine();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client Error: " + e.getMessage());
        }

//        return response;
    }
}
