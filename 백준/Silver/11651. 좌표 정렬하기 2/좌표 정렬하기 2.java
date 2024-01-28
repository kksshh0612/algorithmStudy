import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Num{
        int num1, num2;

        public Num(int a, int b){
            this.num1 = a;
            this.num2 = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Num> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            list.add(new Num(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        Collections.sort(list, new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                if(o1.num2 != o2.num2){
                    return o1.num2 - o2.num2;
                }
                else{
                    return o1.num1 - o2.num1;
                }
            }
        });

        for(Num num : list){
            System.out.println(num.num1 + " " + num.num2);
        }
    }
}