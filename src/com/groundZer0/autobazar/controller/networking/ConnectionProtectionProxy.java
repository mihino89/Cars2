package com.groundZer0.autobazar.controller.networking;

import com.groundZer0.autobazar.data.users.User;

public class ConnectionProtectionProxy extends Connection{

    /**
     * Protection proxy which is validation to prevent null object to try connect fn in Connection object
     * @param object
     * @return
     */
    @Override
    public boolean try_connect_with_server(User object) {
        if(object != null){
            return super.try_connect_with_server(object);
        }

        return false;
    }
}
