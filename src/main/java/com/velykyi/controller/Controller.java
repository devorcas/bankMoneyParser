package com.velykyi.controller;

import com.velykyi.GlobalConstants;
import com.velykyi.LANGUAGES;
import com.velykyi.model.Model;
import com.velykyi.view.View;

import java.util.Deque;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

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

        String s = inputMoneyValue(sc).trim();


        Deque<String> deque = model.parseMoney(s);
        for (String s1 :
                deque) {
            view.printNumber(s1);
        }

    }

    private String inputMoneyValue(Scanner sc) {
        String money;
        String pattern = view.getPattern();
        while (true) {
            view.printMoneyMessage();
            money = sc.next();
            if (Pattern.matches(pattern, money)) break;
            view.printWrongMessage();
        }
        return money;
    }

    private void setLanguage(Scanner sc) {
        LANGUAGES language;
        while (true) {
            view.printLanguageMenu();
            String lang = sc.next().toUpperCase();
            try {
                language = LANGUAGES.valueOf(lang);
                break;
            } catch (Exception e) {
                view.printWrongMenu();
            }
        }
        view.setLanguage(language);
    }


}
