package com.groundZer0.autobazar.data.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsersOps {

    /* Singleton */
    private static UsersOps usersOps = new UsersOps();
    private ObservableList<User> list_of_users = FXCollections.observableArrayList();

    /* Singleton - private constructor */
//    private UsersOps() {}

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

    public void remove_user(User new_user){
        list_of_users.remove(new_user);
    }

    public void remove_all_users(){
        list_of_users.removeAll(list_of_users);
    }
}
