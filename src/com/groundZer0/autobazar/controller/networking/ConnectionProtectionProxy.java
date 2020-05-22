package com.groundZer0.autobazar.controller.networking;

import com.groundZer0.autobazar.data.users.User;

public class ConnectionProtectionProxy extends Connection{

    @Override
    public boolean try_connect_with_server(User user) {
        if(user != null){
            return super.try_connect_with_server(user);
        }

        return false;
    }
}
