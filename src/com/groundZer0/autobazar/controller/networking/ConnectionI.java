package com.groundZer0.autobazar.controller.networking;

import com.groundZer0.autobazar.data.users.User;

public interface ConnectionI {
    boolean try_connect_with_server(User user);
}
