import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String pattern = scanner.next();
        int idx = pattern.indexOf('*');
        String pattern1 = pattern.substring(0, idx);
        String pattern2 = pattern.substring(idx + 1);

        for(int i = 0; i < n; i++){
            String str = scanner.next();

            if(pattern1.length() + pattern2.length() > str.length()){
                System.out.println("NE");
                continue;
            }

            String token1 = str.substring(0, pattern1.length());
            String token2 = str.substring(str.length() - pattern2.length(), str.length());

//            System.out.println(token1);
//            System.out.println(token2);

            if(token1.equals(pattern1) && token2.equals(pattern2)){
                System.out.println("DA");
            }
            else{
                System.out.println("NE");
            }

        }
    }
}