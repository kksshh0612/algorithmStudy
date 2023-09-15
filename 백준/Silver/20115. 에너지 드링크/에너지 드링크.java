import java.util.*;

// 그리디 알고리즘임. 왜? 각 선택에서 최선의 선택을 고르는 과정이기 때문.
// 그리디 알고리즘에서는 일단 정렬을 하는 방법을 먼저 생각해보고 시작. 내림차순 정렬한 후, 실행하면 됨.
//public class Boj20115 {
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> drinks = new ArrayList<>();
        double answer = 0;
        for(int i = 0; i < num; i++){
            drinks.add(scanner.nextInt());
        }

        Collections.sort(drinks, Collections.reverseOrder());       //내림차순 정렬
        answer = drinks.get(0);

        for(int i = 1; i < drinks.size(); i++){
            answer += (double)drinks.get(i) / 2;
        }

        System.out.println(answer);
    }
}
