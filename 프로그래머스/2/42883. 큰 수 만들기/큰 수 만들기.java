import java.util.*;
class Solution {
    public String solution(String number, int k) {
        // 4177252841 길이 10 k=4 , 4개 빼야댐
        // 775841 길이 6
        StringBuilder sb=new StringBuilder();
        int[] arr=new int[number.length()];
        int idx=0;
        for(char c:number.toCharArray())
            arr[idx++]=c-'0';
        int startidx=0;
        for(int i=0;i<number.length()-k;i++){
            int maxidx=getMaxidx(arr,startidx,k+i-startidx+1);
            char c=(char)(arr[maxidx]+'0');
            sb.append(c);
            startidx=maxidx+1;
        }
        return sb.toString();
    }
    
    public int getMaxidx(int[] arr,int startidx,int len){
        int max=0;
        int idx=0;
        for(int i=startidx+len-1;i>=startidx;i--){
            if(max<=arr[i]){
                max=arr[i];
                idx=i;
            }
        }
        return idx;
    }
}