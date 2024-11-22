import java.util.*;
class Solution {
    public int solution(String word) {
        ArrayList<String> list = new ArrayList<>();
        dfs("",list);
        return list.indexOf(word);
    }
    
    public static void dfs(String s,ArrayList<String> list) {
        if (s.length() > 5) {
            return;
        }
        list.add(s);
        for (int i = 0; i < 5; i++) {
            dfs(s + "AEIOU".charAt(i),list);
        }
    }
}
