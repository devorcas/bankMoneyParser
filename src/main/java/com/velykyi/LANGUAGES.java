package com.velykyi;

import jdk.nashorn.internal.ir.BlockLexicalContext;

import java.util.Locale;

public enum LANGUAGES {
    EN("English", new Locale("en")),
    UK("Українська", new Locale("uk"));

    private String language;
    private Locale locale;

    LANGUAGES(String s, Locale locale) {
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
