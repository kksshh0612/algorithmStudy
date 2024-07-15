import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder original = new StringBuilder(br.readLine());
        StringBuilder target = new StringBuilder(br.readLine());

        while (original.length() < target.length()) {
            if (target.charAt(target.length() - 1) == 'A') {
                target.deleteCharAt(target.length() - 1);
            }else if (target.charAt(target.length() - 1) == 'B') {
                target.deleteCharAt(target.length() - 1);
                target.reverse();
            }
        }

        System.out.println(target.toString().equals(original.toString()) ? 1 : 0);
    }
}