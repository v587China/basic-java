package com.ultra.factory.device;

public interface AbstractFactory {

    NVR createNVR();

    PLC createPLC();

    BAS createBAS();
}
