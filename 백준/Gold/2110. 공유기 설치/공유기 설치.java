import java.util.Arrays;
import java.util.Scanner;

//public class Boj2110 {
public class Main {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int homeNum = scanner.nextInt();
        int wifiNum = scanner.nextInt();
        int[] home = new int[homeNum];
        for(int i = 0; i < homeNum; i++){
            home[i] = scanner.nextInt();
        }

        Arrays.sort(home);
        int minDistance = 1, maxDistance = home[home.length - 1], midDistance = 0;

        while(minDistance <= maxDistance){
            midDistance = (minDistance + maxDistance) / 2;
            int currWifi = 1, prevWifi = home[0];

            for(int i = 1; i < homeNum; i++){
                if(currWifi < wifiNum && prevWifi + midDistance <= home[i]){
                    currWifi++;
                    prevWifi = home[i];
                }
            }
            if(currWifi < wifiNum){
                maxDistance = midDistance - 1;
            }
            else{
                minDistance = midDistance + 1;
            }
        }

        System.out.println(maxDistance);

    }
}
