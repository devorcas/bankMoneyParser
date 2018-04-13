package com.velykyi.view;

import com.velykyi.LANGUAGES;

import java.util.*;

import static com.velykyi.GlobalConstants.*;

public class View {
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
        printMessage(WRONG_MENU_DATA);
    }
}
