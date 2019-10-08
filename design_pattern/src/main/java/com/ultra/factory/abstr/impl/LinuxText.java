package com.ultra.factory.abstr.impl;

import com.ultra.factory.abstr.Text;

public class LinuxText implements Text {

    @Override
    public void getAll() {
        System.out.println("LinuxButton getAll ...");
    }

}
