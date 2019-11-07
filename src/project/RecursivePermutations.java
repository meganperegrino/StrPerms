package project;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class RecursivePermutations {
    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
        if(inputString.length () <= 1) {
            return new HashSet<>(Arrays.asList(inputString));
        }
        
        String subStr = inputString.substring(0, inputString.length() - 1);
        char lastChar = inputString.charAt(inputString.length() - 1);
        
        Set<String> permutations = getPermutations(subStr);
        
        HashSet<String> result = new HashSet<>();
        
        for(String p: permutations) {
            for(int i = 0; i <= p.length(); i++) {
                String s = p.substring(0, i) + lastChar + p.substring(i);
                result.add(s);
            }
        }
        return result;
    }
}
