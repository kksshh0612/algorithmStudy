import java.util.*;
import java.io.*;

// 같은문자 / 같은 숫자 나오지 않게 조합 수 구하기
public class Main {

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        long ans = 1;

        char prev = '0';
        int prevNum = 0;
        for(int i = 0; i < string.length(); i++){
            char curr = string.charAt(i);

            if(prev == curr){           // 이전과 같으면 하나 빼고 그 수 곱함
                ans *= prevNum - 1;
            }
            else{                       // 이전과 다르면
                if(curr == 'c'){        //문자이면
                    ans *= 26;
                    prevNum = 26;
                    prev = 'c';
                }
                else{                   // 숫자이면
                    ans *= 10;
                    prevNum = 10;
                    prev = 'd';
                }
            }
        }

        System.out.println(ans);
    }
}