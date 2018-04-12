package com.velykyi.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Model {
    public  Deque<String> deque = new ArrayDeque<>();


    public  Deque<String> getDeque() {
        return deque;
    }

    public void parseNumber(int mainNumber) {
        for (int i = 1_000_000_000 ; i > 0 ; i /= 1000) {
            int remainder = mainNumber / i;
            if (remainder == 0) continue;
            parserHundreds(remainder);
            String last = deque.pollLast();
            if (last == "many") {
                deque.add("many" + i);
            } else deque.add(Integer.valueOf(last) * i + "");
            mainNumber = mainNumber % i;
        }
    }

    private void parserHundreds(int mainNumber) {
        if (mainNumber >= 100 && mainNumber <= 999) {
            int remainder = mainNumber % 100;
            int hundreds = mainNumber - remainder;
            deque.add(Integer.toString(hundreds));
            parserHundreds(remainder);
            return;
        } else if (mainNumber >= 20 && mainNumber <= 99) {
            int remainder = mainNumber % 10;
            int tens = mainNumber - remainder;
            deque.add(Integer.toString(tens));
            parserHundreds(remainder);
            return;
        } else if (mainNumber >= 10 && mainNumber < 20) {
            deque.add(Integer.toString(mainNumber));
            deque.add("many");
            return;
        } else if (mainNumber >= 1 && mainNumber < 10){
            deque.add(Integer.toString(mainNumber));
            return;
        } else return;
    }
}
