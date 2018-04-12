package com.velykyi.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    // Resource Bundle Installation's
    public static final String MESSAGES_BUNDLE_NAME = "numbers";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));  // Ukrainian
                    new Locale("en"));// English

    public void printMessage(String message){
        System.out.print(message + " ");
    }

    public void printNumber(String s){
        printMessage(bundle.getString(s));
    }

}
