import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뒤에 A를 추가   /    뒤에 B 추가하고 뒤집기
public class Main {

    public static boolean isPossible;

    public static void check(StringBuilder curr, String str1){
        if(curr.length() == str1.length()){
            if(curr.toString().equals(str1)){
                isPossible = true;
                return;
            }
        }
        else if(curr.length() > str1.length()) {
//            System.out.println(curr.toString());
            if (curr.charAt(0) != 'B' && curr.charAt(curr.length() - 1) == 'A') {
                curr.delete(curr.length() - 1, curr.length());
                check(curr, str1);
            } else if (curr.charAt(0) == 'B' && curr.charAt(curr.length() - 1) == 'B') {
                curr.reverse();
                curr.delete(curr.length() - 1, curr.length());
                check(curr, str1);
            } else if (curr.charAt(0) == 'B' && curr.charAt(curr.length() - 1) == 'A') {
                StringBuilder sample1 = new StringBuilder(curr.substring(0, curr.length() - 1));
                StringBuilder sample2 = curr.reverse().delete(curr.length() - 1, curr.length());
//                System.out.println("sample1 : " + sample1 + " " + "sample2 : " + sample2);
                check(sample1, str1);
                check(sample2, str1);
            }
        }
        else {
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();
        StringBuilder curr = new StringBuilder(str2);
        isPossible = false;
        // 현재 맨 뒤가 A면, 이전 문자열에서 그냥 A를 더한 문자열임. -> A 빼기
        // 현재 맨 앞이 B이고 맨 뒤가 B면 이전 문자열에서 B 더하고 뒤집은 문자열임 -> 뒤집고 B 빼기
        // 현재 맨 앞이 B이고 맨 뒤가 A면 두 경우 모두 가능 -> 큐에 담아서 분기

        check(curr, str1);

        if(isPossible){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}