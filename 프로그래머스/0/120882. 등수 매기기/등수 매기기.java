import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        ArrayList<Double> list=new ArrayList<>();
        ArrayList<Double> list2=new ArrayList<>();
        for(int i=0;i<score.length;i++){
            list.add((score[i][0]+score[i][1])*1./2);
            list2.add((score[i][0]+score[i][1])*1./2);
        }
        list.sort(Comparator.reverseOrder()); 
        int[] answer = new int[score.length];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.indexOf(list2.get(i)) + 1; 
        }
        return answer;
    }
}