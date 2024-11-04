import java.util.*;
class Solution {
    public int[] solution(String s) {
        s=s.substring(1,s.length()-1);
        Set<ArrayList<Integer>> set = new TreeSet<>(Comparator.comparingInt(ArrayList<Integer>::size));
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                ArrayList<Integer> list=new ArrayList<>();
                for(int j=i+1;j<s.length();j++){
                    if(s.charAt(j)=='}'){
                        String[] vals=s.substring(i+1,j).split(",");
                        for(String a:vals)
                            list.add(Integer.parseInt(a));
                        set.add(list);
                        i=j+1;
                        break;
                    }
                }
            }
        }
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        for(ArrayList<Integer> a:set){
            for(Integer i:a)
                lhs.add(i);
        }
        return lhs.stream().mapToInt(Integer::intValue).toArray();
    }
}