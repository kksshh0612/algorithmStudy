import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int time = scanner.nextInt();

        hour += time / 60;
        minute += time % 60;

        if(minute >= 60){
            hour++;
            minute -= 60;
        }

        if(hour >= 24){
            hour -= 24;
        }

        System.out.println(hour + " " + minute);
    }
}