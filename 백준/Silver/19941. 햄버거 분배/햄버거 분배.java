
import java.util.Scanner;

// 최대한 왼쪽에 있는거 먼저 먹기
//public class Boj19941 {
public class Main {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int distance = scanner.nextInt();
        String str = scanner.next();
        boolean[] check = new boolean[size];

        int ans = 0;

        for(int i = 0; i < size; i++){

            char curr = str.charAt(i);

            if(curr == 'H') continue;

            for(int j = i - distance; j <= i + distance; j++){
                if(j < 0 || j > size - 1) continue;

                if(str.charAt(j) == 'H' && !check[j]){
                    ans++;
                    check[j] = true;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
