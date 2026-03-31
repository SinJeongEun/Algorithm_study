package slidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/submissions/1964925331/
public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        if(s.length() < t.length()) return "";

        // t에 필요한 문자
        Map<Character, Integer> map = new HashMap<>();
        // substring 에서 t 문자를 가지는 현황
        Map<Character, Integer> subStrmap = new HashMap<>();
        int point = 0; // char의 카운팅이 일치하는 횟수

        String result = "";
        int left = 0;
        int right = 0;

        for(char c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        while(right < s.length() && left <= right) {
            char c = s.charAt(right);
            if(!map.containsKey(c)) {
                right++;
                continue;
            }

            // 포함되는 경우
            subStrmap.merge(c, 1, Integer::sum);
            if(subStrmap.get(c).equals(map.get(c))) {
                point++;
            }

            // 문자별 카운팅이 일치하면 최소문자열 구한다: left 를 당긴다
            while (point == map.size() && left <= right) {
                // 최소문자열 갱신
                if(result.isEmpty() || result.length() > s.substring(left, right + 1).length()) {
                    result = s.substring(left, right + 1);
                }

                char targetChar = s.charAt(left);
                if(map.containsKey(targetChar)) {
                    subStrmap.merge(targetChar, -1, Integer::sum);
                    if(subStrmap.get(targetChar) < map.get(targetChar)) {
                        point--;
                    }
                }
                left++;
            }

            right++;
        }

        return result;
    }


}
