import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1343 폴리오미노
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String input = bufferedReader.readLine();       //입력

        int curr = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '.'){
                if(curr == 2){
                    stringBuilder.append("BB");
                    curr = 0;
                }
                else if(curr % 2 == 1){
                    stringBuilder.setLength(0);
                    stringBuilder.append("-1");
                    break;
                }
                stringBuilder.append(".");
            }
            else{
                curr++;
                if(curr == 4){
                    stringBuilder.append("AAAA");
                    curr = 0;
                }
            }
        }

        if(curr == 2){
            stringBuilder.append("BB");
        }
        else if(curr != 0){
            stringBuilder.setLength(0);
            stringBuilder.append("-1");
        }

        System.out.println(stringBuilder.toString());

//        String[] tokens = input.split("\\.");       // split에서 .은 정규식으로 모든 것으로 표현되어 \\ 넣어줘야 함.
//
//        for(String token : tokens){
//            System.out.println(token);
//            if(token.length() % 2 == 1){        //홀수이면
//                stringBuilder.setLength(0);     //초기화
//                stringBuilder.append("-1");
//                stringBuilder.append(".");
//                break;
//            }
//            else{
//                int tokenLen = token.length();
//                while(tokenLen > 0){
//
//                    if(tokenLen >= 4){      //4보다 크면 일단 AAAA 넣음 그러다보면 아예 AAAA만 넣다가 끝나거나, XX 두개만 남는 경우가 생김
//                        stringBuilder.append("AAAA");
//                        tokenLen -= 4;
//                    }
//                    else{
//                        stringBuilder.append("BB");
//                        tokenLen -= 2;
//                    }
//                }
//            }
//            stringBuilder.append(".");
//        }
//
//        // XX.... 와 같이 뒤에 .이 붙는 경우 처리
//        String ans = stringBuilder.substring(0, stringBuilder.length() - 1);
//        if(!ans.equals("-1") && ans.length() < input.length()){
//            stringBuilder.setLength(0);     //초기화
//            stringBuilder.append(ans);
//
//            for(int i = 0; i < input.length() - ans.length(); i++){
//                stringBuilder.append(".");
//            }
//            ans = stringBuilder.toString();
//        }
//
//        System.out.print(ans);
    }
}