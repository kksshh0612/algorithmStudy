import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 투 포인터
        int left = 0, right = size - 1, leftNum = 0, rightNum = 0;
        int min = Integer.MAX_VALUE;

        while(left < right){
            int curr = arr[left] + arr[right];
            if(Math.abs(curr) <= min){
                leftNum = arr[left];
                rightNum = arr[right];
                min = Math.abs(curr);
            }

            if(curr < 0){
                left++;
            }
            else{
                right--;
            }
        }

        System.out.println(leftNum + " " + rightNum);
    }
}