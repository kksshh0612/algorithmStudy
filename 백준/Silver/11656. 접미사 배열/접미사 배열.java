import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//11656 접미사 배열
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i = 0; i < input.length(); i++){
            arrayList.add(input.substring(i));
        }

        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }
}