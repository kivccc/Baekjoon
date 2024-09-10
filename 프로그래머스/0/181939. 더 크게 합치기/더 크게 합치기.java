class Solution {
    public int solution(int a, int b) {
       Integer i=Integer.valueOf(String.valueOf(a)+String.valueOf(b));
       Integer k=Integer.valueOf(String.valueOf(b)+String.valueOf(a));
       return i>=k? i:k;
    }
}