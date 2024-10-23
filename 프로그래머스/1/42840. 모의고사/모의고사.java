import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] arr1=new int[]{1, 2, 3, 4, 5};
        int[] arr2=new int[]{2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] arr3=new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1,0);
        treeMap.put(2,0);
        treeMap.put(3,0);
        int count1=0,count2=0,count3=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i]==arr1[i%5])
                treeMap.put(1,treeMap.get(1)+1);
            if(answers[i]==arr2[i%8])
                treeMap.put(2,treeMap.get(2)+1);
            if(answers[i]==arr3[i%10])
                treeMap.put(3,treeMap.get(3)+1);
        }
        int max=0;
        for(int v:treeMap.values()){
            if(v>max)
                max=v;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}