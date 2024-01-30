import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num0 = Integer.parseInt(stringTokenizer.nextToken());
            int num1 = Integer.parseInt(stringTokenizer.nextToken());
            int num2 = Integer.parseInt(stringTokenizer.nextToken());

            if(i == 0){
                maxDp[0] = minDp[0] = num0;
                maxDp[1] = minDp[1] = num1;
                maxDp[2] = minDp[2] = num2;
            }
            else{
                int prevMaxDp0 = maxDp[0], prevMaxDp1 = maxDp[1], prevMaxDp2 = maxDp[2];
                maxDp[0] = Math.max(prevMaxDp0, prevMaxDp1) + num0;
                maxDp[1] = Math.max(prevMaxDp0, Math.max(prevMaxDp1, prevMaxDp2)) + num1;
                maxDp[2] = Math.max(prevMaxDp1, prevMaxDp2) + num2;

                int prevMinDp0 = minDp[0], prevMinDp1 = minDp[1], prevMinDp2 = minDp[2];
                minDp[0] = Math.min(prevMinDp0, prevMinDp1) + num0;
                minDp[1] = Math.min(prevMinDp0, Math.min(prevMinDp1, prevMinDp2)) + num1;
                minDp[2] = Math.min(prevMinDp1, prevMinDp2) + num2;
            }
        }

        Arrays.sort(maxDp);
        Arrays.sort(minDp);

        System.out.println(maxDp[2] + " " + minDp[0]);
    }
}