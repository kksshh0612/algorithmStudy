import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Y 2    F 3    O 4
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String game = scanner.next();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(scanner.next());
        }

        if(game.equals("Y")) System.out.println(set.size());
        else if(game.equals("F")) System.out.println(set.size() / 2);
        else System.out.println(set.size() / 3);
    }
}