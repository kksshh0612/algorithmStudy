import java.util.*;
// 가장 인접한 공유기 거리 -> 최대
// 거리를 결정하여 해당 거리만큼 놨을 때, 주어진 개수만큼 놔지는지 확인.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int cnt = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int left = 1, right = arr[size - 1] - arr[0];
        while(left <= right){
            int mid = (left + right) / 2;

            int currCnt = 0, idx = 0, prevPos = -1;
            while(idx < size){
                if(prevPos == -1){      //처음이면 일단 가로등 세움
                    currCnt++;
                    prevPos = arr[idx];
                }

                if(arr[idx] - prevPos >= mid){      // 현재 탐색중인 최소 거리보다 같거나 크면 세움
                    currCnt++;
                    prevPos = arr[idx];
                }

                idx++;
            }

            if(currCnt >= cnt){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}