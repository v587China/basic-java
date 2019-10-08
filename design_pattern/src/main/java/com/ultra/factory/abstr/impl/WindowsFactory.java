package com.ultra.factory.abstr.impl;

import com.ultra.factory.abstr.AbstactFactory;
import com.ultra.factory.abstr.Button;
import com.ultra.factory.abstr.Text;

public class WindowsFactory implements AbstactFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Text createText() {
        return new WindowsText();
    }

}
