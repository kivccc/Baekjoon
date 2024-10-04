import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Integer[]> arr=new ArrayList<>();
        for(int i=0;i<rank.length;i++)
            if(attendance[i])
                arr.add(new Integer[]{rank[i],i});
        arr.sort(Comparator.comparingInt(a -> a[0]));
        return 10000*arr.get(0)[1]+100*arr.get(1)[1]+arr.get(2)[1];
    }
}