package com.velykyi.model;

import com.velykyi.Constants;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class Service {
    private BigDecimal maxBarrier;


    public void setMaxBarrier(BigDecimal maxBarrier) {
        this.maxBarrier = maxBarrier;
    }

    public Deque<String> parseMoney(Integer integerPart, Integer fractionalPart) {


        Deque<String> integerDeque = splitNumberAndFillDeque(integerPart ,Constants.CURRENCY );
        Deque<String> fractionalDeque = splitNumberAndFillDeque(fractionalPart, Constants.COINS);

        integerDeque.add(Constants.AND);

        integerDeque.addAll(fractionalDeque);

        return integerDeque;


    }

    private Deque<String> splitNumberAndFillDeque(int number, String ending) {
        Deque<String> deque = new ArrayDeque<>();
        String current_ending = null;
        for (int splitter = 1_000_000_000; splitter > 0; splitter /= 1000) {
            int threeDigitsNumber = number / splitter;
            if (threeDigitsNumber == 0) continue;
            if (splitter == 1_000_000_000) {
                current_ending = Constants.BILLIONS;
            }
            if (splitter == 1_000_000){
                current_ending = Constants.MILLIONS;
            }
            if (splitter == 1_000){
                current_ending = Constants.THOUSAND;
            }
            if (splitter == 1) current_ending = ending;
            deque.addAll(splitThreeDigitNumber(threeDigitsNumber, current_ending));
            number = number % splitter;
        }
        return deque;
    }


    private Deque<String> splitThreeDigitNumber(int digitsNumber, String ending) {
        Deque<String> deque = new ArrayDeque<>();
        while (digitsNumber > 0) {
            if (digitsNumber < 10) {
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

}
