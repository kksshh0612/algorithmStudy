import java.util.*;
import java.io.*;

// 작으면 right + 1, 같거나 크면 left + 1
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = arr[0];
        int cnt = 1, min = Integer.MAX_VALUE;
        while(left <= right && right < size){
            if(sum < target){
                right++;
                if(right >= size) continue;
                sum += arr[right];
                cnt++;
            }
            else{
                min = Math.min(min, cnt);

                sum -= arr[left++];
                cnt--;
            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}