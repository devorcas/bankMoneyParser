package com.velykyi.view;

import com.velykyi.LANGUAGES;

import java.io.BufferedReader;
import java.util.*;

import static com.velykyi.GlobalConstants.*;

public class View {
    private static final String PATTERN_MAIN_CURRENCY ="^(0|[1-9][0-9]*)\\" ;
    private static final String PATTERN_COINS = "[0-9]{2}$";
    // Resource Bundle Installation's
    public static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("en"));// English
    public static final String MENU_SING = " - ";
    public static final String MENU_EXIT_SING = "ex";



    public void printMessage(String message){
        System.out.println(message );
    }


    public void printNumber(String s){
        printMessage(bundle.getString(s));
    }

    public String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public static void setLanguage(LANGUAGES language){
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, language.getLocale());
    }

    public void printLanguageMenu() {
        printMessage(bundle.getString(CHOOSE_LANGUAGE));
        Arrays.stream(LANGUAGES.values())
                .forEach(i -> printMessage(i.toString()
                        + MENU_SING
                        + i.getLanguage() ));
//        printMessage(MENU_EXIT_SING + MENU_SING + bundle.getString(MENU_EXIT));


    }

    public void printWrongMenu() {
        printMessage(bundle.getString(WRONG_MENU_DATA));
    }

    public void printMoneyMessage() {
        String s = concatenationString(bundle.getString(INPUT_AMOUNT_OF_MONEY_USING_SIGN),
                                        "\"",
                                        bundle.getString(CURRENCY_SING),
                                        "\" ",
                                        bundle.getString(FOR),
                                        bundle.getString(CURRENCY));
        printMessage(s);
    }

    public String getPattern() {
        return concatenationString(PATTERN_MAIN_CURRENCY,
                                    bundle.getString(CURRENCY_SING),
                                    PATTERN_COINS);
    }

    public void printWrongMessage() {
        printMessage(bundle.getString(WRONG_INPUT_INT_DATA));
    }
}
