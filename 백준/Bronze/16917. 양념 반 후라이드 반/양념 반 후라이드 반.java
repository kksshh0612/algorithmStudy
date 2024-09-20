import java.util.*;

// 양념, 후라이드, 반반(양념/후라이드)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int saucePrice = sc.nextInt();
        int friedPrice = sc.nextInt();
        int halfPrice = sc.nextInt();
        int sauceCnt = sc.nextInt();
        int friedCnt = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int halfCnt = 0;
        int maxCnt = Math.max(sauceCnt, friedCnt);

        // 반반치킨을 2마리씩 추가하면서 min을 구하기
        while(halfCnt <= maxCnt * 2){

            int remainSauceCnt = sauceCnt;
            int remainFriedCnt = friedCnt;

            if(halfCnt != 0){
                remainSauceCnt = Math.max(0, sauceCnt - halfCnt / 2);
                remainFriedCnt = Math.max(0, friedCnt - halfCnt / 2);
            }

            min = Math.min(min, halfCnt * halfPrice + remainSauceCnt * saucePrice + remainFriedCnt * friedPrice);

            halfCnt += 2;
        }

        System.out.println(min);
    }
}