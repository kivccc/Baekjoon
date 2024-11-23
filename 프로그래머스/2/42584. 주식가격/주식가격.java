import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        // 5, 6, 7, 8, 5, 10
        int[] answer=new int[prices.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<prices.length;i++){
      
            int val=prices[i];
            while(!stack.isEmpty() && prices[stack.peek()]>val){
                answer[stack.peek()]=i-stack.peek();
                stack.pop();
            }    
            stack.push(i);
        }
        int len=prices.length;
        while(!stack.isEmpty()){
            answer[stack.peek()]=len-stack.peek()-1;
            stack.pop();
        }
        return answer;
    }
}