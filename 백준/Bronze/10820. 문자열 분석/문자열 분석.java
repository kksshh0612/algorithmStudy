import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10820 문자열 분석
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[4];     //소문자 대문자 숫자 공백
        String input = "";

        while((input = bufferedReader.readLine()) != null){
            for(int i = 0; i < input.length(); i++){
                char token = input.charAt(i);

                if(token >= 'a' && token <= 'z'){
                    arr[0]++;
                }
                else if(token >= 'A' && token <= 'Z'){
                    arr[1]++;
                }
                else if(token >= '0' && token <= '9'){
                    arr[2]++;
                }
                else{
                    arr[3]++;
                }
            }
            System.out.printf("%d %d %d %d\n", arr[0], arr[1], arr[2], arr[3]);
            for(int i = 0; i < 4; i++){
                arr[i] = 0;
            }
        }


    }

}