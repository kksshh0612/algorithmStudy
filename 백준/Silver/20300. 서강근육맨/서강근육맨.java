import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

// 하루에 두개 선택하는데 하루에 정해진 근손실 넘지 않도록 하고 피티 하루에 두개 받기. 최소 근손실 구하기.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        BigInteger[] arr = new BigInteger[size];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = new BigInteger(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        BigInteger max = new BigInteger("0");
        int start = 0, end = 0;
        if(size % 2 == 0){
            end = size - 1;
        }
        else{
            max = arr[size - 1];
            end = size - 2;
        }
        while(start < end){
            BigInteger sum = arr[start++].add(arr[end--]);

            if(max.compareTo(sum) == -1){
                max = sum;
            }
        }

        System.out.println(max.toString());
    }
}