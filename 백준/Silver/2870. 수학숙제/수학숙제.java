import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<BigInteger> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String str = bufferedReader.readLine();

            StringBuilder curr = new StringBuilder();
            boolean isPrevNumber = false;

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
                    curr.append(str.charAt(j));
                    isPrevNumber = true;
                }
                else{
                    if(isPrevNumber){
                        list.add(new BigInteger(curr.toString()));
                        curr = new StringBuilder();
                    }
                    isPrevNumber = false;
                }
            }
            if(isPrevNumber){
                list.add(new BigInteger(curr.toString()));
            }
        }
        Collections.sort(list);

        for(BigInteger num : list){
            System.out.println(num);
        }
    }
}
