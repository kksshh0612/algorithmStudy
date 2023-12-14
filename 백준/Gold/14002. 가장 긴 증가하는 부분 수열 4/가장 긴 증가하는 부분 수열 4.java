import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static class Element{
        int len;
        int prevIdx;

        public Element(int len, int prevIdx){
            this.len = len;
            this.prevIdx = prevIdx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Element[] dp = new Element[size];

        dp[0] = new Element(1, -1);

        // 이전에 있는 것들 중 나보다 작고 길이가 가장 긴 것을 선택.
        int maxLen = 0, maxIdx = 0;
        for(int i = 1; i < size; i++){
            int currLen = 0;
            int currIdx = -1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j].len > currLen){
                    currLen = dp[j].len;
                    currIdx = j;
                }
            }

            dp[i] = new Element(currLen + 1, currIdx);

            if(dp[i].len > maxLen) {
                maxLen = dp[i].len;        //최대 길이
                maxIdx = i;             //길이가 최대인 요소의 인덱스
            }
        }

        if(size == 1) maxLen = 1;

        Stack<Integer> stack = new Stack<>();

        int prevIdx = maxIdx;
        while(prevIdx != -1){
            stack.push(arr[prevIdx]);

            prevIdx = dp[prevIdx].prevIdx;
        }

        System.out.println(maxLen);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}

