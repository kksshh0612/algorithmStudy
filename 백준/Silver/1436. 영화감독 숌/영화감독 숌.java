import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class Boj1436 {
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int ans = 666, cnt = 1;

        // 666에서 1씩 더하면 667, 668, ... , 1666... 이런식. 1씩 더하면 무조건 언젠간 답이 나옴
        while(cnt < n){
            ans++;

            if(String.valueOf(ans).contains("666")){
                cnt++;
            }
        }

        System.out.println(ans);
    }
}