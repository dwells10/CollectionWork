package com.wellztech;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
     //   String[] fields;
        Object maxKey=null;
        Integer maxValue = Integer.MIN_VALUE;
        int count = 0;

        while ((line = indata.fileReadLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_"," ").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s:words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                }

            }

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }

            if (entry.getValue() == 1) {
                count++;
               // System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        System.out.println(maxKey+" "+ maxValue);
        System.out.println(count);

    }
    
}