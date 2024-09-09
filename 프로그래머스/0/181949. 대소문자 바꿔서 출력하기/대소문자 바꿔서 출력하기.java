import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b="";
        for(char x: a.toCharArray()){
            if(Character.isUpperCase(x))
                b+=Character.toLowerCase(x);
            else
                b+=Character.toUpperCase(x);
        }
        System.out.println(b);
    }
}