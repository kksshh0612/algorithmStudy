import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String num = "";
        StringBuilder stringBuilder = new StringBuilder();

        Set<String> set = new HashSet<>();

        while(n-- > 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            if(command.equals("add")){
                num = stringTokenizer.nextToken();
                set.add(num);
            }
            else if(command.equals("remove")){
                num = stringTokenizer.nextToken();
                set.remove(num);
            }
            else if(command.equals("check")){
                num = stringTokenizer.nextToken();
                if(set.contains(num)){
                    stringBuilder.append( "1\n");
                }
                else{
                    stringBuilder.append( "0\n");
                }
            }
            else if(command.equals("toggle")){
                num = stringTokenizer.nextToken();
                if(set.contains(num)){
                    set.remove(num);
                }
                else{
                    set.add(num);
                }
            }
            else if(command.equals("all")){
                set.clear();
                for(int i = 0; i < 20; i++){
                    set.add(Integer.toString(i + 1));
                }
            }
            else if(command.equals("empty")){
                set.clear();
            }
        }

        System.out.println(stringBuilder.toString());
    }
}