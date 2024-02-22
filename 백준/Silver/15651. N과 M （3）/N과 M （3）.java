import java.util.Scanner;

public class Main {

    public static StringBuilder stringBuilder;

    public static void DFS(int n, int c, int[] arr, int currIdx){
        if(currIdx == c){
            for(int i = 0; i < arr.length; i++){
                stringBuilder.append(arr[i]).append(" ");
            }
            stringBuilder.append("\n");
        }
        else{
            for(int i = 0; i < n; i++){
                arr[currIdx] = i + 1;
                DFS(n, c, arr, currIdx + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();

        stringBuilder = new StringBuilder();

        DFS(n, c, new int[c], 0);

        System.out.print(stringBuilder.toString());
    }
}