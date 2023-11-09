package com.exampleHomeworklibraries1.service;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(StringUtils.capitalize("Artem"));
        String p = "adcew";
//        System.out.println(StringUtils.substring(upperCase1(s), 0, 1).toUpperCase() + s.substring(1));
        System.out.println("IsAlpha: " + StringUtils.isAlpha(p));
////        System.out.println(StringUtils.capitalize(s));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String name = br.readLine();
//        String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1);
//        System.out.println(capitalized);
    }

    public static void simple() {
        String s = "awdqe";
//        if(s.contains(s.toLowerCase())){
        StringUtils.capitalize(s);
//        }
    }
//    public String upperCaseWord() {
//        String b = "ecweewc";{
//        }
//        return StringUtils.capitalize(b);
//    }

}
