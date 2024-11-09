import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //  bandage 기술의 시전 시간, 1초당 회복량, 추가 회복량
        //  attacks[i]는 [공격 시간, 피해량]
        int time=0;
        int health_now=health;
        for (int i = 0; i < attacks.length; i++){
            int heal_time = attacks[i][0] - time - 1;
            
            health_now += heal_time * bandage[1];
            health_now += heal_time / bandage[0] * bandage[2];
            if(health_now>=health)
                health_now=health;
            
            health_now -= attacks[i][1];
        
            time = attacks[i][0];


            if (health_now <= 0) {
                return -1;
            }

        }
        return health_now;
    }
}