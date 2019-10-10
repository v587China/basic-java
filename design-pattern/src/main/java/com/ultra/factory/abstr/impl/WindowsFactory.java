package com.ultra.factory.abstr.impl;

import com.ultra.factory.abstr.AbstractFactory;
import com.ultra.factory.abstr.Button;
import com.ultra.factory.abstr.Text;

public class WindowsFactory implements AbstractFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Text createText() {
        return new WindowsText();
    }

}
