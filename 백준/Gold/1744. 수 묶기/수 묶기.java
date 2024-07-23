import java.util.*;

// 수열을 두 수씩 묶어 최댓값
// 음수는 절댓값이 큰 것부터 음수끼리 묶음. 음수가 홀수이면 그것은 양수의 가장 작은수랑 묶음
// 양수는 큰것부터 큰것끼리 묶음
public class Main {

    public static int sum(PriorityQueue<Integer> queue){
        int sumNum = 0;

        while(!queue.isEmpty()){
            int num1 = queue.poll();

            if(queue.isEmpty()) sumNum += num1;
            else{
                int num2 = queue.poll();

                if(num1 * num2 > num1 + num2){
                    sumNum += num1 * num2;
                }
                else{
                    sumNum += num1 + num2;
                }
            }
        }
        return sumNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < size; i++){
            int n = sc.nextInt();

            if(n <= 0) minus.add(n);
            else plus.add(n);
        }

        int ans = sum(minus) + sum(plus);

        System.out.println(ans);
    }
}