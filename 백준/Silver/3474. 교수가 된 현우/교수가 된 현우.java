import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2와 5의 짝이 총 몇개인지 구하면 됨.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < tCase; i++){
            int num = Integer.parseInt(bufferedReader.readLine());

            int two = 0, five = 0;

            for(int j = 2; j <= num; j *= 2){
                two += num / j;
            }
            for(int j = 5; j <= num; j *= 5){
                five += num / j;
            }

            System.out.println(Math.min(two, five));
        }
    }

}
