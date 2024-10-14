class Solution {
    public int solution(int[] sides) {
        if(sides[1]>sides[0])
            return 2*sides[0]-1;
        else
            return 2*sides[1]-1;
            
    }
}