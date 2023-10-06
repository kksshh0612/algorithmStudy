import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        input = input.toUpperCase();

        Map<Character, Integer> map = new HashMap<>();

        int cnt = 0, max = 0;
        char ans = 0;

        for(int i = 0; i < input.length(); i++){        //map에 넣기 
            Character token = input.charAt(i);

            if(map.containsKey(token)){
                map.put(token, map.get(token) + 1);
            }
            else{
                map.put(token, 1);
            }
        }

        for(Character key : map.keySet()){          //최댓값 찾기
            if(max < map.get(key)){
                max = map.get(key);
                ans = key;
            }
        }
        for(Character key : map.keySet()){      //두개 이상인지 확인
            if(max == map.get(key)){
                cnt++;
            }
        }
        if(cnt > 1){
            System.out.println("?");
        }
        else{
            System.out.println(ans);
        }
    }
}