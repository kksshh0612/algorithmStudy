import java.util.*;
import java.io.*;

public class Main {

    public static StringBuilder ansBuilder = new StringBuilder();

    public static void dfs(int num, int size, int[] arr, int currIdx, int currNum){
        if(size == 0){
            for(int i = 0; i < arr.length; i++){
                ansBuilder.append(arr[i]).append(" ");
            }
            ansBuilder.append("\n");
        }
        else{
            for(int i = currNum; i <= num; i++){
                arr[currIdx] = i;
                dfs(num, size - 1, arr, currIdx + 1, i);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int size = sc.nextInt();

        dfs(num, size, new int[size], 0, 1);

        System.out.println(ansBuilder.toString());
    }
}