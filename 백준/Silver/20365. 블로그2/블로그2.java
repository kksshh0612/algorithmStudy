import java.util.Scanner;

//public class Boj20365 {
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = scanner.next();
        int bCnt = 0, rCnt = 0;
        boolean isPrevB = false;        //이전이 B 였는지. 이 변수를 통해 묶음을 확인할 것임.

        //B, R 그룹의 첫번째에서 그룹의 수 count
        for(int i = 0; i < num; i++){
            char token = str.charAt(i);

            if(i == 0){
                if(token == 'B') {
                    isPrevB = true;
                    bCnt++;
                }
                else{
                    rCnt++;
                }
            }

            if(token == 'B'){
                if(!isPrevB){       //이전이 B가 아니었으면 B 그룹의 첫번째임.
                    isPrevB = true;
                    bCnt++;
                }
            }
            else{
                if(isPrevB){        //이전이 B였으면, R그룹의 첫번째임.
                    isPrevB = false;
                    rCnt++;
                }
            }
        }
//        System.out.println(bCnt + " " + rCnt);
        System.out.println(Math.min(bCnt, rCnt) + 1);
    }
}
