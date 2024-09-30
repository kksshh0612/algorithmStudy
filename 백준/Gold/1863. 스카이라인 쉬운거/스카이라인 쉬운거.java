import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr[i] = height;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);     // 첫번째 건문 높이 저장

        int answer = 0;

        // top보다 큰거 : 넣기   top보다 작은거 : 같은거 나올 때까지 빼기
        for(int i = 0; i < size; i++){
            if(arr[i] > stack.peek()){
                stack.push(arr[i]);
            }
            else{
                while(stack.peek() > arr[i]){
                    stack.pop();
                    answer++;
                }
                if(stack.peek() < arr[i]) stack.push(arr[i]);
            }
        }
        if(stack.peek() != 0) answer += stack.size() - 1;

        System.out.println(answer);
    }
}