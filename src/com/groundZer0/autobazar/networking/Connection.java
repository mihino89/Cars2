package com.groundZer0.autobazar.networking;

import com.groundZer0.autobazar.controller.Controller;
import com.groundZer0.autobazar.data.users.User;
import com.groundZer0.autobazar.data.users.UsersOps;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;

public class Connection extends Controller implements Serializable{
    private final String HOST = "localhost";
    private final int PORT = 8000;

    private static Connection connection = new Connection();

    public static Connection getConnection(){
        return  connection;
    }

    public boolean try_connect_with_server(User user){
        try (Socket client_socket = new Socket(HOST, PORT)) {
            OutputStream outputStream = client_socket.getOutputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(client_socket.getInputStream());

            /* object to server */
            objectOutputStream.writeObject(user);

            /* Process of ending client app */
            if(user == null){
                client_socket.close();
                return true;
            }
            /* Process of registration */
            else if (Objects.equals(user.getOperation_note(), "registration")){
                /* server response */
                User new_user= (User) objectInputStream.readObject();

                /* if registration is success answer is empty object only with operation argument with string success registered */
                if(Objects.equals(new_user.getOperation_note(), "success")){
                    System.out.println("Registration was !" + new_user.getOperation_note());
                    return true;
                } else {
                    return false;
                }
            }
            /* Process of login */
            else if(Objects.equals(user.getOperation_note(), "login_credentials")){
                System.out.println("try to login from client");
                User login_user = (User) objectInputStream.readObject();

                if(login_user != null && Objects.equals(login_user.getOperation_note(), "success")){
                    System.out.println("User was succesfull authorized");
                    if(Objects.equals(login_user.getPrivilages(), "user")){
//                        System.out.println(login_user.getFirst_name() + login_user.getLast_name() + login_user.getPhone_number() + login_user.getEmail() + login_user.getPrivilages() + Arrays.toString(login_user.getPublic_key()) + login_user.getToken());
                        UsersOps.getUsersOps().add_user(new User(login_user.getFirst_name(), login_user.getLast_name(), login_user.getPhone_number(), login_user.getBirth(), login_user.getEmail(), login_user.getPrivilages(), login_user.getPublic_key(), login_user.getToken()));
//                        System.out.println("aj tu to este funguje");
                        return true;
                    } else {
                        System.out.println("asi som admin :D");
                    }
                } else {
                    System.out.println("Problem with user authorization");
                }

                return false;
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client Error: " + e.getMessage());
        }

        return false;
    }
}
