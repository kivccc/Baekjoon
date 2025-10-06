import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String,HashMap<String,Integer>> giveTake = new HashMap<>();
        HashMap<String,Integer> presentVal = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            giveTake.put(friends[i],new HashMap<>());
            presentVal.put(friends[i],0);
        }
        for(int i=0;i<gifts.length;i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            HashMap<String,Integer> check = giveTake.get(from);
            check.put(to,check.getOrDefault(to,0)+1);
            presentVal.put(from,presentVal.get(from)+1);
            presentVal.put(to,presentVal.get(to)-1);
        }
        

        //System.out.println(giveTake);
        //System.out.println(presentVal);
        
        int[] nextGift = new int[friends.length];
        for(int i=0;i<friends.length;i++){
            String from = friends[i];
            for(int j=0;j<friends.length;j++){
                if(i==j) continue;
                String target = friends[j];
                int aTob = giveTake.get(from).getOrDefault(target,0);
                int bToa = giveTake.get(target).getOrDefault(from,0);
                //System.out.println(from+"과 "+target);
                //System.out.println(aTob+" : "+bToa);
                
                if(aTob > bToa){
                    nextGift[i]++;                    
                }
                else if(aTob == bToa){
                    int a = presentVal.getOrDefault(from,0);
                    int b = presentVal.getOrDefault(target,0);
                    //System.out.println("지수 체크 "+a+" "+b);
                    
                    if(a >b)
                        nextGift[i]++;                    
                }
            }
        }
        
        //System.out.println(Arrays.toString(nextGift));
        
        
        int answer = 0;        
        for(int i:nextGift)
            answer = Math.max(answer,i);
        return answer;
    }
}