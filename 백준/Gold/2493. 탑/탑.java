import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 배열 첫번째부터 1,2,3,4... 본인보다 왼쪽에 있는 수 중 가장 가까운 수의 자리
// 스택에 자기보다 작은거 있으면 빼다가 자기보다 큰거 나오면 그 타워의 번호 정답에 저장하고 본인 push
public class Main {

    public static class Tower{
        int num;
        int height;

        public Tower(int num, int height){
            this.num = num;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[size + 1];
        int[] ans = new int[size + 1];
        for(int i = 1; i <= size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Stack<Tower> stack = new Stack<>();
        stack.push(new Tower(1, arr[1]));
        ans[1] = 0;

        for(int i = 2; i <= size; i++){

            while(!stack.isEmpty() && stack.peek().height < arr[i]){        //현재 스택 탑이 현재 탑보다 작으면
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = stack.peek().num;
            }
            else{
                ans[i] = 0;
            }
            stack.push(new Tower(i, arr[i]));
        }

        for(int i = 1; i <= size; i++){
            System.out.print(ans[i] + " ");
        }

    }

}


