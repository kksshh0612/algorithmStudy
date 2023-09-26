import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 각 자리의 숫자를 모르고 연산자에 따라 연산 결과가 바뀌기 때문에 무식하게 모든 경우를 탐색해야 함.
// 연산자 순열을 구현다고 생각하면 편함.
//public class Boj14888 {
public class Main {
        
    public static int max;
    public static int min;

    public static void DFS(int[] operand, int currOpNum, int totalOpNum, int[] operator, List<Character> currOperator, int currIdx){
        if(currOpNum == totalOpNum){        //연산자를 모두 배치하면 (순열의 모든 경우를 탐색하면)
            int curr = operand[0];
            for(int i = 0; i < currOperator.size(); i++){
//                System.out.print(currOperator.get(i) + " ");
                switch (currOperator.get(i)){
                    case '+' :
                        curr += operand[i + 1];
                        break;
                    case '-' :
                        curr -= operand[i + 1];
                        break;
                    case '*' :
                        curr *= operand[i + 1];
                        break;
                    case '/' :
                        if(curr < 0){
                            curr = -1 * (-1 * curr / operand[i + 1]);
                        }
                        else{
                            curr /= operand[i + 1];
                        }
                        break;
                }
            }

            if(curr > max){
                max = curr;
            }
            if(curr < min){
                min = curr;
            }
//            System.out.println();
        }
        else{
            for(int i = 0; i < 4; i++){
                if(operator[i] > 0){
                    switch (i){
                        case 0 :
                            currOperator.add('+');
                            break;
                        case 1 :
                            currOperator.add('-');
                            break;
                        case 2 :
                            currOperator.add('*');
                            break;
                        case 3 :
                            currOperator.add('/');
                            break;
                    }
                    operator[i]--;
                    DFS(operand, currOpNum + 1, totalOpNum, operator, currOperator, currIdx + 1);
                    currOperator.remove(currIdx);
                    operator[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] operand = new int[n];
        int[] operator = new int[4];        // +, -, x, /
        int totalOperandNum = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++){
            operand[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(stringTokenizer.nextToken());
            totalOperandNum += operator[i];
        }

        List<Character> currOperator = new ArrayList<>();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        DFS(operand, 0, totalOperandNum, operator, currOperator, 0);

        System.out.println(max);
        System.out.println(min);
    }
}
