import java.util.*;

// A의 순열을 구하고 거기서 B보다 작으면서 가장 큰 값
public class Main {

    public static int ans;

    public static void dfs(List<Integer> list, boolean[] check,
                           int num, int idx, int size, int b){
        if(idx == size){
            if(num < b){
                ans = num;
            }
            else{
                return;
            }
        }
        else{
            for(int i = 0; i < list.size(); i++){
                if(check[i]) continue;
                if(num == 0 && list.get(i) == 0) continue;

                num *= 10;
                num += list.get(i);
                check[i] = true;
                dfs(list, check, num, idx + 1, size, b);
                num /= 10;
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        while(a > 0){
            list.add(a % 10);
            a /= 10;
        }

        Collections.sort(list);

        ans = -1;

        dfs(list, new boolean[list.size()], 0, 0, list.size(), b);

        System.out.println(ans);
    }
}