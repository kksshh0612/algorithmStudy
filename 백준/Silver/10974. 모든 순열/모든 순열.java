import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void DFS(int n, List<Integer> list, boolean[] check, int cnt){
        if(cnt >= n){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
        else{
            for(int i = 1; i <= n; i++){
                if(!check[i]){
                    check[i] = true;
                    list.add(i);
                    DFS(n, list, check, cnt + 1);
                    check[i] = false;
                    list.remove(Integer.valueOf(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[n + 1];
        DFS(n, list, check, 0);
    }
}