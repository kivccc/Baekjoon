class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            answer[i]=String.format("%"+n+"s",Integer.toBinaryString(arr1[i] | arr2[i])).replace(" ","0");
        }
        int idx=0;
        for(String s:answer){
            answer[idx++]=s.replaceAll("1","#").replaceAll("0"," ");
        }
        return answer;
    }
}