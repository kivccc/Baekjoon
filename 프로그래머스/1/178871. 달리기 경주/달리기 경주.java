import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            list.add(players[i]);
        }
        
        for(String s:callings){
            int idx=map.get(s);
            String front=list.get(idx-1);
            list.set(idx-1,s);
            list.set(idx,front);
            
            map.put(s,idx-1);
            map.put(front,idx);
            
        }

        return list.toArray(new String[0]);
    }
}