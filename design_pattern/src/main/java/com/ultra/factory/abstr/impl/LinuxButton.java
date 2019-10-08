package com.ultra.factory.abstr.impl;

import com.ultra.factory.abstr.Button;

public class LinuxButton implements Button {

    @Override
    public void process() {
        System.out.println("LinuxButton process ...");
    }

}
