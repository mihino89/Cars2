package com.groundZer0.autobazar.data.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserSession {

    /* Singleton */
    private static UserSession userSession = new UserSession();
    private ObservableList<User> list_of_users = FXCollections.observableArrayList();

    /* Singleton - return only one instance of class*/
    public static UserSession getUserSession() {
        return userSession;
    }

    /* return list of users */
    public ObservableList<User> getUsers() {
        return list_of_users;
    }

    public void setUsers(ObservableList<User> users) {
        this.list_of_users = users;
    }

    /**
     * add user function
     * @param new_user
     */
    public void add_user(User new_user){
        list_of_users.add(new_user);
    }

    /**
     * remove function for the list
     * @param new_user
     */
    public void remove_user(User new_user){
        list_of_users.remove(new_user);
    }

    /**
     * remove all user in list
     */
    public void remove_all_users(){
        list_of_users.removeAll(list_of_users);
    }
}
