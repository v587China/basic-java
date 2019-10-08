package com.ultra.factory.abstr.impl;

import com.ultra.factory.abstr.AbstactFactory;
import com.ultra.factory.abstr.Button;
import com.ultra.factory.abstr.Text;

public class LinuxFactory implements AbstactFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Text createText() {
        return new LinuxText();
    }

}
