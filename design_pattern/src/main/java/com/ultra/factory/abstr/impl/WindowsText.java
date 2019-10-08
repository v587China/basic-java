package com.ultra.factory.abstr.impl;

import com.ultra.factory.abstr.Text;

public class WindowsText implements Text {

    @Override
    public void getAll() {
        System.out.println("WindowsText getAll ...");
    }

}
