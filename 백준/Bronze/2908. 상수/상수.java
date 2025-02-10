import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String[] arr=sc.nextLine().split(" ");
        arr[0]=""+arr[0].charAt(2)+arr[0].charAt(1)+arr[0].charAt(0);
        arr[1]=""+arr[1].charAt(2)+arr[1].charAt(1)+arr[1].charAt(0);
        int a=Integer.parseInt(arr[0]);
        int b=Integer.parseInt(arr[1]);
        if(a>b)
            System.out.println(a);
        else
            System.out.println(b);
    
	}
}