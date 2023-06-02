import java.util.Scanner;

//10808 알파벳 개수
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[26];

        String input = scanner.nextLine();

        for(int i = 0; i < input.length(); i++){
            char token = input.charAt(i);
            int idx = (int)token - (int)'a';
            arr[idx]++;
        }

        for(int i = 0; i < 26; i++){
            System.out.print(arr[i] + " ");
        }
    }

}