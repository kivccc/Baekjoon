class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < numLog.length-1; i++) {
            int s=numLog[i+1];
            int e=numLog[i];
            if(s-e == 1)
                sb.append('w');
            else if(s-e ==-1)
                sb.append('s');
            else if(s-e ==10)
                sb.append('d');
            else if(s-e ==-10)
                sb.append('a');
        }
        return sb.toString();
    }
}