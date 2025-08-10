package com.wipro.threaddemo;

import java.util.List;

public class ConsonantThread implements Runnable{

		    List<String> list;

		    public ConsonantThread(List<String> list) {
		        this.list = list;
		    }

		    @Override
		    public void run() {
		        for (int i = 0; i < list.size(); i++) {
		            String name = list.get(i);
		            if (!startsWithVowel(name)) {
		                list.set(i, name.toLowerCase());
		            }
		        }
		    }

		    private boolean startsWithVowel(String name) {
		        if (name == null || name.isEmpty()) return false;
		        char firstChar = Character.toLowerCase(name.charAt(0));
		        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u';

		    }
		  

}
