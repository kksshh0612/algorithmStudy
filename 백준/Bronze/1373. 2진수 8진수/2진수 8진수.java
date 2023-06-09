import java.util.Scanner;

//1373 2진수 8진수
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        int first = 0, second = 0, third = 0;

        if(input.length() % 3 == 2) {
            input = "0" + input;
        }
        else if(input.length() % 3 == 1){
            input = "00" + input;
        }

        for(int i = input.length() - 1; i >= 0; i--){
            int num = input.charAt(i) - '0';

            if(i % 3 == 2){
                first = num * 1;
            }
            else if(i % 3 == 1){
                second = num * 2;
            }
            else if(i % 3 == 0){
                third = num * 4;
                stringBuilder.append(first + second + third);
            }
        }
        System.out.println(stringBuilder.reverse().toString());
    }
}