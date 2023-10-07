import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 연산자 우선순위 없고, 중첩된 괄호 안됨. 괄호 안에 연산자 하나. 정수는 한자릿수 아예 안묶어도 됨
// ArrayLisy에 피연산자, 연산자 넣기
//public class Boj16637 {
public class Main {
    public static int max;

    public static int calc(Character operator, int num1, int num2){
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
        }
        return result;
    }

    public static void DFS(List<Character> operator, List<Integer> operand, int currIdx, int operatorSize, int sum){
        if(currIdx >= operatorSize){
            max = Math.max(max, sum);
        }
        else{
            int result1 = calc(operator.get(currIdx), sum, operand.get(currIdx + 1));
            DFS(operator, operand, currIdx + 1, operatorSize, result1);

            if(currIdx + 1 <= operatorSize - 1){
                int bracketResult = calc(operator.get(currIdx + 1), operand.get(currIdx + 1), operand.get(currIdx + 2));
                int result2 = calc(operator.get(currIdx), sum, bracketResult);
                DFS(operator, operand, currIdx + 2, operatorSize, result2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Character> operator = new ArrayList<>();
        List<Integer> operand = new ArrayList<>();
        String str = bufferedReader.readLine();

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                operand.add(Integer.parseInt(Character.toString(str.charAt(i))));
            }
            else{
                operator.add(str.charAt(i));
            }
        }
        max = Integer.MIN_VALUE;

        DFS(operator, operand, 0, operator.size(), operand.get(0));

        System.out.println(max);
    }

}