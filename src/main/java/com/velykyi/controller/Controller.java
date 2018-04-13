package com.velykyi.controller;

import com.velykyi.GlobalConstants;
import com.velykyi.LANGUAGES;
import com.velykyi.model.Model;
import com.velykyi.view.View;

import java.util.*;

import static com.velykyi.LANGUAGES.valueOf;

public class Controller {
    Model model;
    View view;
    Map<GlobalConstants, Locale> localeHashMap;
    LANGUAGES[] languages = LANGUAGES.values();



    public Controller() {
        this.model = new Model();
        this.view = new View();
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);

        this.setLanguage(sc);

        Deque<String > deque = model.parseMoney("217879,23");
        for (String s:
             deque) {
            view.printNumber(s);
        }

    }

    public void setLanguage(Scanner sc) {
        while (true){
            view.printLanguageMenu();
            String lang = sc.next().toUpperCase();
            try {
                LANGUAGES languages = LANGUAGES.valueOf(lang);

            } catch (Exception e){
                view.printWrongMenu();
            }
        }


    }


}
