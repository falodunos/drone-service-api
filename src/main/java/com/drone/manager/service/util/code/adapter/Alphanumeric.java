package com.drone.manager.service.util.code.adapter;

import java.util.concurrent.ThreadLocalRandom;

public class Alphanumeric extends AdapterAbstract {

    @Override
    public String generate() {
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
        String numbers = "1234567890";
        String code  = "";

        while(code.length() < this.codeLength)
        {
            String characters = ((ThreadLocalRandom.current().nextInt(0, 10)) % 2 == 0) ? alphabets : numbers;
            System.out.println("characters :: " + characters);
            int charPos = ThreadLocalRandom.current().nextInt(0, characters.length());
            code += Character.toString(characters.toCharArray()[charPos]);
        }

        return this.toCase(code);
    }
}
