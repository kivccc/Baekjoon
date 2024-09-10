class Solution {
    public int solution(int[] num_list) {
        StringBuffer a=new StringBuffer();
        StringBuffer b=new StringBuffer();
        for (int i : num_list) {
            if(i%2==1)
                a.append(i);
            else
                b.append(i);  
        }
        return Integer.parseInt(a.toString())+Integer.parseInt(b.toString());
    }
}