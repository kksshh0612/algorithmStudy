import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size1 = Integer.parseInt(bufferedReader.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size1; i++){
            set.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int size2 = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size2; i++){
            int num = Integer.parseInt(stringTokenizer.nextToken());

            if(set.contains(num)){
                stringBuilder.append(1).append("\n");
            }
            else{
                stringBuilder.append(0).append("\n");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}