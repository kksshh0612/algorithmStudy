import java.util.*;

// 폭발 문자열 제외하고 뭐 남는지 출력 / 없으면 FRULA
//public class Boj9935 {
public class Main {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String bombStr = scanner.next();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bombStr.length()){
                boolean check = true;

                for(int j = 0; j < bombStr.length(); j++){
                    if(stack.get(stack.size() - j - 1) != bombStr.charAt(bombStr.length() - j - 1)){
                        check = false;
                        break;
                    }
                }

                if(check){
                    for(int j = 0; j < bombStr.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
        }
        else{
            StringBuilder stringBuilder = new StringBuilder();
            while(!stack.isEmpty()){
                stringBuilder.append(stack.pop());
            }
            System.out.println(stringBuilder.reverse().toString());
        }
    }
}
