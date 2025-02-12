import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        System.out.println(A+B-C);
        System.out.println(Integer.parseInt(Integer.toString(A)+Integer.toString(B))-C);
	}
}