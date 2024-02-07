import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 수열 구하기 -> DFS
public class Main {

    public static void DFS(List<Integer> list, int n, int m, boolean[] check, StringBuilder stringBuilder){

        if(list.size() >= m){
            for(Integer num : list){
                stringBuilder.append(num).append(" ");
            }
            stringBuilder.append("\n");
        }
        else{
            for(int i = 1; i <= n; i++){
                if(!check[i]){
                    check[i] = true;
                    list.add(i);
                    DFS(list, n, m, check, stringBuilder);
                    check[i] = false;
                    list.remove(Integer.valueOf(i));
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] check = new boolean[n + 1];

        StringBuilder stringBuilder = new StringBuilder();
        DFS(new ArrayList<>(), n, m, check, stringBuilder);

        System.out.println(stringBuilder.toString());
    }
}