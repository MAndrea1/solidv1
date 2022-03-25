package com.example;

import com.example.controller.Controller;
import org.apache.log4j.Logger;

public class Principal {
    private static Logger logger = Logger.getLogger(Principal.class);

    public static void main(String[] args) {
        logger.debug("Starting program");
        Controller controller = new Controller();
        controller.start();
    }
}
