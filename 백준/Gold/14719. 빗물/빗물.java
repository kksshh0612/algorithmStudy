import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 떨어져 있는 것 중 가장 높은 것 두개의 사이에 빗물이 고임 -> 가장 낮은 것부터 양 끝을 살피며 나보다 높은거 있으면 +1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int height = Integer.parseInt(stringTokenizer.nextToken());
        int width = Integer.parseInt(stringTokenizer.nextToken());
        int[] blockHeight = new int[width];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < width; i++){
            blockHeight[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int ans = 0;

        int left = 0, right = 0, leftMax = 0, rightMax = 0;

        for(int i = 0; i < width; i++){
            left = i - 1;
            right = i + 1;
            leftMax = 0;
            rightMax = 0;

            while(left >= 0){
                leftMax = Math.max(leftMax, blockHeight[left]);     //현재 열의 왼쪽 중 가장 높은 값 찾음
                left--;
            }
            while(right < width){
                rightMax = Math.max(rightMax, blockHeight[right]);  //현재 열의 오른쪽 중 가장 높은 값 찾음
                right++;
            }

            if(blockHeight[i] < leftMax && blockHeight[i] < rightMax){
                ans += (Math.min(leftMax, rightMax) - blockHeight[i]);
            }
        }

        System.out.println(ans);
    }
}