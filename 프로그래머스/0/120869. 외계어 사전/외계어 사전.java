class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String s: dic){
            int flag=0;
            for(String c:spell){
                if(!s.contains(c))
                    flag=1;
            }
            if(flag==0)
                return 1;
        }
        return 2;
    }
}