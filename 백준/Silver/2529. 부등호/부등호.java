import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완전탐색으로 모두 탐색 후, 부등호를 넣어 모든 부등호가 성립하는지 확인하기
//public class Boj2529 {
public class Main {
    public static String min;
    public static String max;

    public static void DFS(boolean[] check, StringBuilder currBuilder, String[] sign){
        if(currBuilder.length() == sign.length + 1){
            String currNum = currBuilder.toString();
//            System.out.println(currNum);
            int idx = 0;
            boolean isRight = true;
            for(String signToken : sign){       //모든 부등호 조건에 맞는지 판단
                int num1 = currNum.charAt(idx) - '0';
                int num2 = currNum.charAt(idx + 1) - '0';

                if(signToken.equals(">")){
                    if(!(num1 > num2)){         //조건에 맞지 않으면
                        isRight = false;
                        break;
                    }
                }
                else{
                    if(!(num1 < num2)){         //조건에 맞지 않으면
                        isRight = false;
                        break;
                    }
                }
                idx++;
            }
            if(isRight){        //모든 부등호 조건에 맞다면 최대 최소 확인
                if(Long.parseLong(currNum) < Long.parseLong(min)){
                    min = currNum;
                }
                if(Long.parseLong(currNum) > Long.parseLong(max)){
                    max = currNum;
                }
            }
        }
        else{
            for(int i = 0; i < 10; i++){
                if(!check[i]){
                    check[i] = true;
                    currBuilder.append(i);
                    DFS(check, currBuilder, sign);
                    check[i] = false;
                    currBuilder.delete(currBuilder.length() - 1, currBuilder.length());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int signNum = Integer.parseInt(bufferedReader.readLine());      // 부등호 갯수
        String[] sign = new String[signNum];                            // 부등호
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < signNum; i++){
            sign[i] = stringTokenizer.nextToken();
        }
        boolean[] check = new boolean[10];      // 0 ~ 9
        StringBuilder stringBuilder = new StringBuilder();

        min = Long.toString(Long.MAX_VALUE);
        max = Long.toString(Long.MIN_VALUE);

        DFS(check, stringBuilder, sign);

        System.out.println(max);
        System.out.println(min);
    }
}