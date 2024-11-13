import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer=0;
        int[] arr_front=new int[topping.length-1];
        int[] arr_back=new int[topping.length-1];
        HashSet<Integer> front=new HashSet<>();
        HashSet<Integer> back=new HashSet<>();
        for(int i=0;i<topping.length-1;i++){
            front.add(topping[i]);
            back.add(topping[topping.length-i-1]);

            arr_front[i]=front.size();
            arr_back[topping.length-i-2]=back.size();
        }
        
        for(int i=0;i<topping.length-1;i++){

            if(arr_front[i]==arr_back[i])
                answer++;
        }

        return answer;
    }
}