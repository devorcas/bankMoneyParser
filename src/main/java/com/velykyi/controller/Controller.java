package com.velykyi.controller;

import com.velykyi.Constants;
import com.velykyi.Language;
import com.velykyi.model.Service;
import com.velykyi.view.View;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    Service service;
    View view;


    public Controller() {
        this.service = new Service();
        this.view = new View();
    }

    public void processUser() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (flag) {

            setLanguage(sc);

            String[] splittedSum = inputMoneyValue(sc).trim().split(",|\\.");

            if (Long.valueOf(splittedSum[0]) > Constants.MAX_BARRIER ){
                view.printWrongBarrier(Constants.MAX_BARRIER);
                continue;
            }

            Integer integerPart = Integer.valueOf(splittedSum[0]);
            Integer fractionalPart = Integer.valueOf(splittedSum[1]);


            Deque<String> deque = service.parseMoney(integerPart, fractionalPart);
            deque.stream().forEach(view::printNumber);
            flag = changeLanguageOrExit(sc);
        }

    }

    private boolean changeLanguageOrExit(Scanner sc) {
        String s;
        while (true) {
            view.printMainMenu();
            s = sc.next();
            switch (s){
                case View.MENU_EXIT_SING: return false;
                case View.MENU_CONTINUE_SIGN: return true;
                default: {
                    view.printWrongMenu();
                    continue;
                }
            }
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
        Language language;
        while (true) {
            view.printLanguageMenu();
            String lang = sc.next().toUpperCase();
            try {
                language = Language.valueOf(lang);
                break;
            } catch (Exception e) {
                view.printWrongMenu();
            }
        }
        view.setLanguage(language);
    }


}
