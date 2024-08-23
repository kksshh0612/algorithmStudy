import java.util.*;
import java.io.*;

public class Main {

    public static boolean binarySearch(int[] arr1, int target){
        int left = 0, right = arr1.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr1[mid] < target){
                left = mid + 1;
            }
            else if(arr1[mid] > target){
                right = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while(tCase-- > 0){
            int size1 = Integer.parseInt(br.readLine());
            int[] arr1 = new int[size1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < size1; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            int size2 = Integer.parseInt(br.readLine());
            int[] arr2 = new int[size2];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < size2; i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            // arr1 정렬
            Arrays.sort(arr1);

            // 이분탐색
            for(int i = 0; i < size2; i++){
                if(binarySearch(arr1, arr2[i])){
                    ans.append("1\n");
                }
                else{
                    ans.append("0\n");
                }
            }
        }
        System.out.println(ans.toString());
    }
}