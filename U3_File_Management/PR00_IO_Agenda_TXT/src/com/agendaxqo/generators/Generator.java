package com.agendaxqo.generators;

import com.agendaxqo.model.Contact;

public class Generator {

    public static Contact generateContact() {
        boolean mbl = true;
        if (numbRandom(0,1) < 1) mbl = false;
        return new Contact(stringRandom(numbRandom(10, 14)),String.valueOf(numbRandom(600000000,699999999)),stringRandom(numbRandom(10, 14)),mbl);
    }

    private static int numbRandom(int minimo, int maximo) {

        return  (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));

    }

    private static String stringRandom(int digit){

        String placeHolder = "";

        for (int j = 0; j < digit; j++) {
             placeHolder += String.valueOf(charRandom());
        }

        return placeHolder;
    }

    private static char charRandom() {

        final int FIRST_CHAR_ASCII_NUM = 97;
        final int NUM_OF_CHARS = 25;

        return (char) (FIRST_CHAR_ASCII_NUM + Double.valueOf(Math.random() * NUM_OF_CHARS).intValue());

    }
}
