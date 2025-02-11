import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		int[] arr=new int[52];
		for(char c:word.toCharArray()){
			if('A'<= c && c<='Z')
				arr[c-'A']++;
			else
				arr[c-'a']++;
		}
		int max=0;
		int idx=0;
		boolean flag=false;
		for(int i=0;i<arr.length;i++){
			if(max==arr[i]){
				flag=true;
			}
			else if(max<arr[i]){
				flag=false;
				max=arr[i];
				idx=i;
			}
		}
		if(flag)
			System.out.println("?");
		else
			System.out.println((char)(idx%26+'A'));
	}
}