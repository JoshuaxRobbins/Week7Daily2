package com.example.josh.week7daily1;

import java.util.regex.Pattern;

public class PatternMatcher {


    public static boolean testPassword(String password){
        Pattern pattern = Pattern.compile("((?=.*[\\p{Punct}])(?=.*[\\p{Lower}])(?=.*[\\p{Upper}])(?=.*[\\p{Digit}]).{6,20})");
        return pattern.matcher(password).matches();


    }
}
