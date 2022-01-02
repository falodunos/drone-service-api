package com.drone.manager.service.util.code.adapter;

import java.util.concurrent.ThreadLocalRandom;

public class Alphabetic extends AdapterAbstract {
    @Override
    public String generate() {
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code  = "";
        while(code.length() < this.codeLength)
        {
            int charPos = ThreadLocalRandom.current().nextInt(0, alphabets.length());
            code += Character.toString(alphabets.toCharArray()[charPos]);
        }

        return this.toCase(code);
    }
}
