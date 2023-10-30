import java.util.Scanner;

// 직선에서 수빈이는 양 옆 1칸씩 움직이거나, 2를 곱한 위치로 움직일 수 있음.
// 가장 빨리 동생 찾는 시간
// dp. 현 위치에서 양 옆으로 이동하면서 탐색하면서 +1 더하는 경우 or 2로 나누는 경우를 비교해서 작은거 dp배열에 넣음. 근데 이때, 홀수이면 2로 못나눔
// 각 지점에서 뒤와 앞으로 가는 모든 경우를 저장하기
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] dp = new int[Math.max(start, end) + 2];

        int ans = 0;
        if(end < start){
            ans = start - end;
        }
        else{
            int curr = start - 1;
            while(curr >= 0){                   //시작 위치의 왼쪽은 그냥 한칸씩 움직이는 방법밖에 없음.
                dp[curr] = dp[curr + 1] + 1;
                curr--;
            }
            curr = start + 1;
            while(curr <= end + 1){
                if(curr % 2 != 0){      //홀수이면
                    dp[curr] = dp[curr - 1] + 1;
                }
                else{
                    dp[curr] = Math.min(dp[curr - 1] + 1, dp[curr / 2] + 1);
                    dp[curr - 1] = Math.min(dp[curr] + 1, dp[curr - 1]);        //현재 탐색중인 것의 왼쪽도 확인
                }
                curr++;
            }
            ans = dp[end];
        }

//        for(int i = 0; i < dp.length; i++){
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();

        System.out.println(ans);
    }

}
