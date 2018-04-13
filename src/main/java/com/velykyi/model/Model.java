package com.velykyi.model;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class Model {

    public Deque<String> parseMoney(String numbers){
        Deque<String> deque1 = new ArrayDeque<>();
        Deque<String> deque2 = new ArrayDeque<>();
//        String numbers = money.toPlainString();
        String[] s = numbers.split(",");
        deque1 = splitNumberAndFillDeque(Integer.valueOf(s[0]));
        deque2 = splitThreeDigitNumber(Integer.valueOf(s[1]), "_cent");
        deque1.add("and");
        deque1.addAll(deque2);

        return deque1;

    }

    public Deque<String> splitNumberAndFillDeque(int number) {
        Deque<String> deque = new ArrayDeque<>();
        String ending = null;
        for (int spliter = 1_000_000_000; spliter > 0; spliter /= 1000) {
            int threeDigitsNumber = number / spliter;
            if (threeDigitsNumber == 0) continue;
            if (spliter == 1_000_000_000) ending = "_bilions";
            if (spliter == 1_000_000) ending = "_milions";
            if (spliter == 1_000) ending = "_thousand";
            if (spliter == 1) ending = "_dollars";
            deque.addAll(splitThreeDigitNumber(threeDigitsNumber, ending));
            number = number % spliter;
        }
        return deque;
    }


    public Deque<String> splitThreeDigitNumber(int digitsNumber, String ending) {
        Deque<String> deque = new ArrayDeque<>();
        while (digitsNumber > 0) {
            if (digitsNumber < 10 ) {
                deque.add(Integer.toString(digitsNumber) + ending);
                return deque;
            }
            int length = String.valueOf(digitsNumber).length();
            int local_splitter = (int) Math.pow(10, length - 1);
            int mod = digitsNumber % local_splitter;
            if (digitsNumber <= 19 | mod == 0) {
                deque.add(Integer.toString(digitsNumber));
                deque.add(ending);
                return deque;
            }
            int number = digitsNumber - mod;
            deque.add(Integer.toString(number));
            digitsNumber %= local_splitter;
        }
        return deque;
    }


//

}
