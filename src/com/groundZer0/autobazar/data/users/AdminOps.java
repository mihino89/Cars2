package com.groundZer0.autobazar.data.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminOps {
    /* Singleton */
    private static AdminOps usersOps = new AdminOps();
    private ObservableList<User> list_of_admin_users = FXCollections.observableArrayList();

    /* Singleton - private constructor */
//    private AdminOps() {}

    /* Singleton - return only one instance of class*/
    public static AdminOps getAdminOps() {
        return usersOps;
    }

    public ObservableList<User> getList_of_admin_users() {
        return list_of_admin_users;
    }

    public void setList_of_admin_users(ObservableList<User> list_of_admin_users) {
        this.list_of_admin_users = list_of_admin_users;
    }

    public void add_user_in_admin(User new_user){
        list_of_admin_users.add(new_user);
    }

    public void remove_user_in_admin(User new_user){
        list_of_admin_users.remove(new_user);
    }

    public void remove_all_users_in_admin(){
        list_of_admin_users.removeAll(list_of_admin_users);
    }
}
