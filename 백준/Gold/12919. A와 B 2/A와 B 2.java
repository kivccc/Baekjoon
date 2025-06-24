import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S=br.readLine();
        String T=br.readLine();
        boolean flag=back(S, T);
        System.out.println(flag?1:0);
    }
    
    public static boolean back(String target, String current) {
        if (current.equals(target)) {
            return true;
        }
        if (current.length() <= target.length()) {
            return false;
        }
        if (current.charAt(current.length() - 1) == 'A') {
            String next = current.substring(0, current.length() - 1);
            if (back(target, next)) {
                return true;
            }
        }
        if (current.charAt(0) == 'B') {
            String reversed = new StringBuilder(current).reverse().toString();
            String next = reversed.substring(0, reversed.length() - 1);
            if (back(target, next)) {
                return true;
            }
        }
        return false;
    }
}