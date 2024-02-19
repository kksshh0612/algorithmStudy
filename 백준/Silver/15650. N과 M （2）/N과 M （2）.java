import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void DFS(int n, int size, boolean[] check, List<Integer> curr){

        if(curr.size() == size){
            for(Integer num : curr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
        else{
            for(int i = 1; i <= n; i++){
                if(!check[i]){
                    if((curr.size() > 0 && i > curr.get(curr.size() - 1)) || curr.size() == 0){
                        check[i] = true;
                        curr.add(i);
                        DFS(n, size, check, curr);
                        check[i] = false;
                        curr.remove(Integer.valueOf(i));
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int size = scanner.nextInt();

        boolean[] check = new boolean[num + 1];

        DFS(num, size, check, new ArrayList<>());
    }
}