class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1)
            return new int[]{-1};
        int min=arr[1];
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        int[] answer=new int[arr.length-1];
        int idx=0;
        for(int i:arr){
            if(i!=min){
                answer[idx]=i;
                idx++;
            }
        }
        return answer;
    }
}