
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static int size;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(bufferedReader.readLine());
		arr = new int[size];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		// 연속하는 LIS 구하기
		int[] dp = new int[size + 1];	// 각 요소는 인덱스에 해당하는 숫자의 LIS 저장
		int max = 0;
		for(int i = 0; i < size; i++) {
			int curr = arr[i];
			dp[curr] = dp[curr - 1] + 1;
			max = Math.max(max,  dp[curr]);
		}
		
		System.out.println(size - max);
	}
}
