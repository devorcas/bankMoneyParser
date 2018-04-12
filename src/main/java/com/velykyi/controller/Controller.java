package com.velykyi.controller;

import com.velykyi.model.Model;
import com.velykyi.view.View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Controller {
    Model model;
    View view;


    public Controller() {
        this.model = new Model();
        this.view = new View();
    }
    public void processUser() {
        model.parseNumber(12_413_456);
        Deque<String> arrayDeque =  model.getDeque();
        for (String s :
                arrayDeque) {
            view.printNumber(s);
        }

    }
}
