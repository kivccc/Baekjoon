import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i:people){
            deque.addLast(i);
        }
        int answer=0;
        while(deque.size()>0){
            int min=deque.peekFirst();
            int max=deque.peekLast();
            if(min+max<=limit){
                deque.pollLast();
                deque.pollFirst();
                answer++;
            }
            else{
                deque.pollLast();
                answer++;
            }
        }
        return answer;
    }
}