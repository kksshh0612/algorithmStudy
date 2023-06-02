import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

//1918 후위표기식 -> 스택 탑이 현재 연산자보다 우선순위 높거나 같으면 pop
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('(', 0);

        for(int i = 0; i < input.length(); i++){
            char token = input.charAt(i);

            switch (token){
                case '*':
                case '/':
                case '+':
                case '-':
                    while(!stack.empty() && priority.get(stack.peek()) >= priority.get(token)){       //스택 탑에 있는 연산자 우선순위가 높거나 같으면
                        stringBuilder.append(stack.pop());
                    }
                    stack.push(token);
                    break;
                case '(':       //왼쪽괄호 나오면 일단 넣음
                    stack.push(token);
                    break;
                case ')':
                    while(!stack.empty() && stack.peek() != '('){
                        stringBuilder.append(stack.pop());      //왼쪽괄호 나올 때까지 pop
                    }
                    stack.pop();        //왼쪽괄호 빼줌
                    break;
                default:
                    stringBuilder.append(token);
            }
        }
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        System.out.println(stringBuilder.toString());
    }

}