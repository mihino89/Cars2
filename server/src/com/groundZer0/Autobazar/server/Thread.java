package com.groundZer0.Autobazar.server;

import com.groundZer0.Autobazar.server.User.User;
import com.groundZer0.Autobazar.server.security.UserSession;

import java.io.*;
import java.net.Socket;
import java.security.PublicKey;
import java.util.List;
import java.util.ListIterator;

public class Thread extends java.lang.Thread {
    private Socket socket;
    private PrintWriter output;

    public Thread(Socket accept) {
        this.socket = accept;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();

            ObjectInputStream from_client = new ObjectInputStream(inputStream);
            ObjectOutputStream to_client = new ObjectOutputStream(socket.getOutputStream());

            User user = (User) from_client.readObject();
            System.out.println("now");
            System.out.println(user.getEmail());
//            UserSession userSession = UserSession.getInstance();
//
//            PublicKey publicKey = userSession.getPublicKey();
//            token = userSession.encrypt(password, publicKey);
//
//            System.out.println(token);
//            output.println(token);

        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Oops: " + e.getMessage());
        }
    }
}
