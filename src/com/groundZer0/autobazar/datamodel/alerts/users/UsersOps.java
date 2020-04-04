package com.groundZer0.autobazar.datamodel.alerts.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class UsersOps {

    /* Singleton */
    private static UsersOps usersOps = new UsersOps();
    /* DB of users */
    private final String file_name = "src/com/groundZer0/autobazar/datamodel/alerts/db/users.txt";

    private ObservableList<User> list_of_users;
    private DateTimeFormatter dateTimeFormatter;

    /* Singleton - private constructor */
    private UsersOps() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public void users_loading() throws IOException {
        String line_file_reader;
        boolean is_user_admin = false;

        list_of_users = FXCollections.observableArrayList();
        Path path = Paths.get(file_name);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while ((line_file_reader = bufferedReader.readLine()) != null) {
                String[] user_information = line_file_reader.split(" ");

                String user_birth = user_information[3];
                LocalDate localDate = LocalDate.parse(user_birth, dateTimeFormatter);
                if (Objects.equals("true", user_information[6])){
                    is_user_admin = true;
                }
                User user = new User(user_information[0], user_information[1], user_information[2], localDate, user_information[4], user_information[5], is_user_admin);
                list_of_users.add(user);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Singleton - return only one instance of class*/
    public static UsersOps getUsersOps() {
        return usersOps;
    }

    /* return list of users */
    public ObservableList<User> getUsers() {
        return list_of_users;
    }

    public void setUsers(ObservableList<User> users) {
        this.list_of_users = users;
    }

    public void add_user(User new_user){
        list_of_users.add(new_user);
    }
}
