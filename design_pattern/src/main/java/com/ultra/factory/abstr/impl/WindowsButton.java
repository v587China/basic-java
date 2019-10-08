package com.ultra.factory.abstr.impl;

import com.ultra.factory.abstr.Button;

public class WindowsButton implements Button {

    @Override
    public void process() {
        System.out.println("WindowsButton process ...");
    }

}
