import java.util.Scanner;

// 모두 짝수이거나, 홀수인 것의 수가 하나여야 함.
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] alphabetCnt = new int[26];

        for(int i = 0; i < input.length(); i++){
            alphabetCnt[input.charAt(i) - 'A']++;
        }

        int holNum = 0;
        for(int i = 0; i < 26; i++){
            if(alphabetCnt[i] % 2 == 1){
                holNum++;
            }
        }

        char[] ans = new char[input.length()];
        int start = 0, end = ans.length - 1;

        if(holNum  > 1){
            System.out.println("I'm Sorry Hansoo");
        }
        else{

           int midIdx = -1;

            for(int i = 0; i < 26; i++){

                if(alphabetCnt[i] == 1) midIdx = i;

                while(alphabetCnt[i] > 1){
                    char currCharacter = (char) (i + 'A');
                    ans[start++] = currCharacter;
                    ans[end--] = currCharacter;
                    alphabetCnt[i] -= 2;

                    if(alphabetCnt[i] == 1) midIdx = i;
                }
            }

            if(midIdx != -1) ans[start] = (char) (midIdx + 'A');

            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i]);
            }
        }
    }

}