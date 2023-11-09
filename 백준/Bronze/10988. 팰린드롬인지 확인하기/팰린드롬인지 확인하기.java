import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int left = 0, right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                System.out.println(0);
                return;
            }
            left++;
            right--;
        }
        System.out.println(1);
    }

}