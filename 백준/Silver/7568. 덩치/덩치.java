import java.util.Scanner;

//
public class Main {

    public static class Person{
        int weight, height;

        public Person(int weight, int height){
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Person[] arr = new Person[n];
        for(int i = 0; i < n; i++){
            int weight = scanner.nextInt();
            int height = scanner.nextInt();

            arr[i] = new Person(weight, height);
        }

        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n; j++){
                if(arr[j].weight > arr[i].weight && arr[j].height > arr[i].height){
                    cnt++;
                }
            }
            System.out.print(cnt + " ");
        }
    }
}