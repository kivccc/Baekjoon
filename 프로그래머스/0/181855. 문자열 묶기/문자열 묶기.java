import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int[] arr=new int[30];
        for(String s:strArr){
            arr[s.length()-1]++;
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}