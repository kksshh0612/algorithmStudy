import java.util.*;

// n극 -> 0 / s극 -> 1     시계 -> 1 반시계 -> -1
// 회전시킬 때, 인접한 톱니바퀴 숫자 다르면 반대로 회전함.
// 양쪽으로 회전할 수 있기 때문에 데크를 사용하기
public class Main {

    public static class Gear{
        int start, end;             //12방향 : start, 끝 : end
        int[] arr;

        public Gear(int start, int end, int[] arr){
            this.start = start;
            this.end = end;
            this.arr = arr;
        }
    }

    public static void turn(Gear gear, int dir){
        if(dir == 1){
            gear.start = (gear.start - 1 + 8) % 8;
            gear.end = (gear.end -1 + 8) % 8;
        }
        else{
            gear.start = (gear.start + 1) % 8;
            gear.end = (gear.end + 1) % 8;
        }
    }

    public static class CurrGear{
        Gear gear;
        int num, dir;

        public CurrGear(Gear gear, int num, int dir){
            this.gear = gear;
            this.num = num;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gear[] gears = new Gear[4];

        for(int i = 0; i < 4; i++){
            String str = scanner.next();
            int[] arr = new int[8];
            for(int j = 0; j < 8; j++){
                arr[j] = str.charAt(j) - '0';
            }
            gears[i] = new Gear(0, 7, arr);
        }

        int size = scanner.nextInt();
        while(size-- > 0){
            int num = scanner.nextInt() - 1;        //몇번째 톱니인지
            int dir = scanner.nextInt();        //시계 -> 1 반시계 -> -1

            Gear curr = gears[num];

            boolean[] alreadyTurn = new boolean[4];
            Queue<CurrGear> queue = new LinkedList<>();
            queue.add(new CurrGear(curr, num, dir));
            alreadyTurn[num] = true;

            while(!queue.isEmpty()){

                Gear currGear = queue.peek().gear;
                int currNum = queue.peek().num;
                int currDir = queue.poll().dir;


                int currLeft = gears[currNum].arr[(currGear.start + 6) % 8];
                int currRight = gears[currNum].arr[(currGear.start + 2) % 8];

                turn(currGear, currDir);

                if((currNum - 1 >= 0 && !alreadyTurn[currNum - 1]) && currLeft != gears[currNum - 1].arr[(gears[currNum - 1].start + 2) % 8]){
                    alreadyTurn[currNum - 1] = true;
                    queue.add(new CurrGear(gears[currNum - 1], currNum - 1, -currDir));
                }
                if((currNum + 1 < 4 && !alreadyTurn[currNum + 1]) && currRight != gears[currNum + 1].arr[(gears[currNum + 1].start + 6) % 8]){
                    alreadyTurn[currNum + 1] = true;
                    queue.add(new CurrGear(gears[currNum + 1], currNum + 1, -currDir));
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < 4; i++){
            if(gears[i].arr[gears[i].start] == 1) ans += Math.pow(2, i);
        }

        System.out.println(ans);
    }
}