import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dt = new int[n + 1];
        if(n == 1){
            System.out.println(1);
        }
        else{
            dt[1] = 1;
            dt[2] = 2;

            for(int i = 3; i <= n; i++){
                dt[i] = (dt[i - 1] + dt[i - 2]) % 10007;
            }
            System.out.print(dt[n] % 10007);
        }
    }
}
