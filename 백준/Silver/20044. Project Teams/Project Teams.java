import java.util.*;
import java.io.*;

// 코딩 역량 합 일정하게 하여 가장 작은 코딩역량 팀
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int teamSize = Integer.parseInt(bf.readLine());
        int[] arr = new int[teamSize * 2];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < teamSize; i++){
            int sum = arr[i] + arr[arr.length - i - 1];

            min = Math.min(sum, min);
        }

        System.out.println(min);
    }
}