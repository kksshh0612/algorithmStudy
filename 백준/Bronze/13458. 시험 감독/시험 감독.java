import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int room = scanner.nextInt();
        int[] people = new int[room];
        for(int i = 0; i < room; i++){
            people[i] = scanner.nextInt();
        }
        int total = scanner.nextInt();
        int partial = scanner.nextInt();

        long ans = 0;

        for(int i = 0; i < room; i++){
            int curr = people[i];

            curr -= total;
            ans++;

            if(curr <= 0) continue;

            ans += curr / partial;

            if(curr % partial > 0) ans++;
        }

        System.out.println(ans);

    }
}