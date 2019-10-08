package com.ultra.factory.simple;

import com.ultra.factory.simple.impl.MysqlConn;
import com.ultra.factory.simple.impl.OracleConn;

public class SimpleFactory {

    public static final int TYPE_MYSQL = 1;
    public static final int TYPE_ORACLE = 2;

    public static Conn create(int type) {
        switch (type) {
        case TYPE_MYSQL:
            return new MysqlConn();
        case TYPE_ORACLE:
            return new OracleConn();
        default:
            return null;
        }
    }
}
