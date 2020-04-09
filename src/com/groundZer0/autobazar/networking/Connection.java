package com.groundZer0.autobazar.networking;

import com.groundZer0.autobazar.data.users.User;
import com.groundZer0.autobazar.view.components.Alerts;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Connection implements Serializable{
    private final String HOST = "localhost";
    private final int PORT = 8000;

    private static Connection connection = new Connection();

    public static Connection getConnection(){
        return  connection;
    }

    public void try_connect_with_server(User user){
        try (Socket client_socket = new Socket(HOST, PORT)) {
            OutputStream outputStream = client_socket.getOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(client_socket.getInputStream());

            /* object to server */
            objectOutputStream.writeObject(user);
            /* server response */
            User new_user= (User) objectInputStream.readObject();

            /* if registration is success answer is empty object only with operation argument with string success registered */
            if(Objects.equals(new_user.getOperation_note(), "success")){
                System.out.println("Registration was " + new_user.getOperation_note());
            }
            else if(Objects.equals(user.getOperation_note(), "fail registered")){
                Alerts alerts = new Alerts("Error");
                alerts.show_alert("Registration fail", "Registracia nebola uspesna");
            }

            client_socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client Error: " + e.getMessage());
        }


    }
}
