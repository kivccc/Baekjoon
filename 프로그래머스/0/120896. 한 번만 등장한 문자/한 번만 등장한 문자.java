import java.util.*;

class Solution {
    public String solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        for (char a : s.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        List<Character> charList = new ArrayList<>();
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                charList.add(key);
            }
        }
        
        
        Collections.sort(charList);
        

        StringBuilder answer = new StringBuilder();
        for (Character c : charList) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}