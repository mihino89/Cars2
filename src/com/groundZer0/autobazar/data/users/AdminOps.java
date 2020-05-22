package com.groundZer0.autobazar.data.users;

import com.groundZer0.autobazar.controller.networking.Connection;
import com.groundZer0.autobazar.controller.networking.ConnectionProtectionProxy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AdminOps {
    /* Singleton */
    private static AdminOps usersOps = new AdminOps();
    private ObservableList<User> list_of_admin_users = FXCollections.observableArrayList();

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

    public void remove_user_in_admin(User user_to_delete){
        user_to_delete.setOperation_note("delete_user");
        Connection connection = new ConnectionProtectionProxy();

        /* request to server to delete user */
        if (connection.try_connect_with_server(user_to_delete)){
            /* if server succes - user removing on the client/admin side */
            list_of_admin_users.remove(user_to_delete);
        }
    }

    public void remove_all_users_in_admin(){
        list_of_admin_users.removeAll(list_of_admin_users);
    }
}
