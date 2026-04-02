package twoPointers;

import java.util.regex.Pattern;

// https://leetcode.com/problems/valid-palindrome/
class ValidPalindrome {
    private static final Pattern NON_ALPHA = Pattern.compile("[^a-zA-Z0-9]");

    public boolean isPalindrome(String s) {
        s = NON_ALPHA.matcher(s).replaceAll("").toLowerCase();

        int startPoint = 0;
        int endPoint = s.length() - 1;
        
        while(startPoint < endPoint) {
            if(s.charAt(startPoint) != s.charAt(endPoint)) {
                return false;
            }
            startPoint++;
            endPoint--;
        }

        return true;
    }
}
