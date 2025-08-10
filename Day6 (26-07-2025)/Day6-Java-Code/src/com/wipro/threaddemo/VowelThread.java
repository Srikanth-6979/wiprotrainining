package com.wipro.threaddemo;

import java.util.List;

public class VowelThread implements Runnable {

	List<String> list;

    public VowelThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (startsWithVowel(name)) {
                list.set(i, name.toUpperCase());
            }
        }
    }

    private boolean startsWithVowel(String name) {
        if (name == null || name.isEmpty()) return false;
        char firstChar = Character.toLowerCase(name.charAt(0));
        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u';

    }

	
}
