import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 산성 : 양수 염기성 : 음수    용액 두개 선택해서 특성값 0으로 만들기
//public class Boj2467 {
public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int value = Integer.MAX_VALUE;
        int left = 0, right = size - 1;     //양 끝에서 시작
        int ansLeftNum = 0, ansRightNum = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < value){       //특성값 절댓값이 더 작으면 넣음.
                ansLeftNum = arr[left];
                ansRightNum = arr[right];
                value = Math.abs(sum);
            }
            if(sum > 0){        // 양수면 현재 오른쪽 수보다 더 작은 수 오면 0에 가까울 확률 올라감
                right--;
            }
            else if(sum < 0){               // 음수면 현재 왼쪽 수보다 더 큰 수 오면 0에 가까울 확률 올라감
                left++;
            }
            else{
                break;      // 0이면 그냥 끝내도 됨
            }
        }

        System.out.println(ansLeftNum + " " + ansRightNum);
    }
}
