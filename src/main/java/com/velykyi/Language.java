package com.velykyi;

import java.util.Locale;

public enum Language {
    /*
     * To add language - add enum with your language
     * set in Locale your language abbreviation
     * create new property file with name_abbreviation
     *
     */
    EN("English", new Locale("en")),
    UK("Українська", new Locale("uk"));

    private String language;
    private Locale locale;

    Language(String s, Locale locale) {
        this.language = s;
        this.locale = locale;
    }

    public String getLanguage() {
        return language;
    }

    public Locale getLocale() {
        return locale;
    }
}
