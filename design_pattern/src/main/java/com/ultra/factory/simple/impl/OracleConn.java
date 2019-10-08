package com.ultra.factory.simple.impl;

import com.ultra.factory.simple.Conn;

public class OracleConn implements Conn {

    @Override
    public void db() {
        System.out.println("oracle conn...");
    }

}
