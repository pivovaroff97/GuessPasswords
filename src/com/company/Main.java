package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        static ArrayList<String> list = new ArrayList<String>();
        static ArrayList<String> result = new ArrayList<String>();
        static {
            list.add("08");
            list.add("124");
            list.add("1235");
            list.add("236");
            list.add("1457");
            list.add("24568");
            list.add("3569");
            list.add("478");
            list.add("05789");
            list.add("689");
        }
        static String combination = "";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = reader.readLine();
        reader.close();
        long startTime = System.currentTimeMillis();
        toFindResults(code, 0);
        printResult();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println();
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
    }
    public static void toFindResults(String code, int position) {
          if (position < code.length()) {
              char[] chars1 = list.get(Integer.parseInt(String.valueOf(code.charAt(position)))).toCharArray();
              for (int i = 0; i < chars1.length; i++) {
                      combination = combination.concat(String.valueOf(chars1[i]));
                      toFindResults(code, position + 1);
                      if (combination.length() == code.length())
                          result.add(combination + ",");
                      combination = combination.substring(0, combination.length() - 1);
              }
          }
    }
    public static void printResult() {
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i));
        }
        System.out.print(result.get(result.size() - 1).substring(0, result.get(result.size() - 1).length() - 1));
    }
}
