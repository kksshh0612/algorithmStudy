import java.util.Scanner;

//10824 네 수
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = new String[4];
        StringBuilder stringBuilder = new StringBuilder();

        int idx = 0;
        for(int i = 0; i < input.length(); i++){
            char token = input.charAt(i);
            if(token != ' '){
                stringBuilder.append(token);
            }
            else {          //공백 나오면 한 숫자 나온 것.
                arr[idx++] = stringBuilder.toString();
                stringBuilder.setLength(0);     //초기화
            }
        }
        arr[idx] = stringBuilder.toString();        //마지막 수

        System.out.println(Long.parseLong(arr[0] + arr[1]) + Long.parseLong(arr[2] + arr[3]));
    }
}