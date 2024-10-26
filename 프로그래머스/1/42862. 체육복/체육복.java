import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        ArrayList<Integer> reservelist=new ArrayList<>();
        ArrayList<Integer> lostlist=new ArrayList<>();
        for(int i:reserve)
            reservelist.add(i);
        Collections.sort(reservelist);
        
        for(int i:lost)
            lostlist.add(i);
        Collections.sort(lostlist);
        
        int answer = n-lost.length;
        Iterator<Integer> iterator = lostlist.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (reservelist.contains(i)) {
                reservelist.remove(Integer.valueOf(i));
                iterator.remove();
                answer++;
            }
        }
        
        for(int i:lostlist){
            if(reservelist.contains(i-1)){
                reservelist.remove(Integer.valueOf(i-1));
                answer++;
            }
            else if(reservelist.contains(i+1)){
                reservelist.remove(Integer.valueOf(i+1));
                answer++;
            }
        }
        
        return answer;
    }
}