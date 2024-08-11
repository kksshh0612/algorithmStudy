import java.util.*;

// 레벵 0 -> P
// 레벨 1 -> B(레벨0)P(레벨0)B
// 레벨 2 -> B(레벨1)P(레벨1)B
public class Main {

    public static long find(int level, long eat, long[] burgerSize, long[] pattySize){
        if(level == 0){
            if(eat == 0) return 0;
            else if(eat == 1) return 1;
        }
        if(eat == 1) return 0;      // B
        else if(eat <= 1 + burgerSize[level - 1]){      // B(레벨 - 1)
            return find(level - 1, eat - 1, burgerSize, pattySize);
        }
        else if(eat == 1 + burgerSize[level - 1] + 1){      // B(레벨 - 1)P
            return pattySize[level - 1] + 1;
        }
        else if(eat <= 1 + burgerSize[level - 1] + 1 + burgerSize[level - 1]){  // B(레벨 - 1)P(레벨 - 1)
            return pattySize[level - 1] + 1 +
                    find(level - 1, eat - (1 + burgerSize[level - 1] + 1), burgerSize, pattySize);
        }
        else{       // B(레벨 - 1)P(레벨 - 1)B
            return pattySize[level - 1] + 1 + pattySize[level - 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        long eat = sc.nextLong();
        long[] burgerSize = new long[level + 1];
        long[] pattySize = new long[level + 1];
        burgerSize[0] = 1;
        pattySize[0] = 1;

        for(int i = 1; i <= level; i++){
            burgerSize[i] = 1 + burgerSize[i - 1] + 1 + burgerSize[i - 1] + 1;
            pattySize[i] = 1 + pattySize[i - 1] + pattySize[i - 1];
        }

        System.out.println(find(level, eat, burgerSize, pattySize));
    }
}