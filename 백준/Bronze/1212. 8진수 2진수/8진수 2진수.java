import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1212 8진수 2진수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        String[] b = {"000","001","010","011","100","101","110","111"};

        for(int i = 0; i < input.length(); i++){
            int a =  input.charAt(i)-'0';

            stringBuilder.append(b[a]);
        }

        if(input.equals("0")) System.out.println(input);
        else{
            while(stringBuilder.charAt(0) == '0'){
                stringBuilder = new StringBuilder(stringBuilder.substring(1));        //앞에 나오는 0 자르기
            }
            System.out.println(stringBuilder);
        }
    }
}