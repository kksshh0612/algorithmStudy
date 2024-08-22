import java.util.*;
import java.io.*;
// 상근이가 갖고 있는 것들 정렬.
// 구분할 배열 반복하면서 상근이 배열 이분탐색.

public class Main {

    public static boolean binarySearch(int[] arr, int target){

        int left = 0, right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] > target){
                right = mid - 1;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{       // 같으면
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sangunSize = Integer.parseInt(bf.readLine());
        int[] arr = new int[sangunSize];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < sangunSize; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int problemSize = Integer.parseInt(bf.readLine());
        int[] input = new int[problemSize];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < problemSize; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder ansBuilder = new StringBuilder();

        for(int i = 0; i < problemSize; i++){
            if(binarySearch(arr, input[i])){
                ansBuilder.append("1 ");
            }
            else{
                ansBuilder.append("0 ");
            }
        }

        System.out.println(ansBuilder.toString());
    }
}