package com.example.view;

import com.example.controller.Mediator;

public abstract class ControlledUI {
    Mediator mediator;

    public ControlledUI(Mediator mediator) {
        this.mediator = mediator;
    }

}
