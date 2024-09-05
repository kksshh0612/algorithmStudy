import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "(100+1+|01)+";

        int size = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < size; i++){
            String str = sc.next();
            if(str.matches(regex)){
                ans.append("YES").append("\n");
            }
            else{
                ans.append("NO").append("\n");
            }
        }

        System.out.println(ans.toString());
    }
}