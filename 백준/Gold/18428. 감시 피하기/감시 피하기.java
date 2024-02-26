import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 장애물 세개 설치해서 감시로부터 피할 수 있게 하기
// DFS로 일단 세개 설치하기
// 선생 위치에서 상하좌우 탐색해서 한번이라도 학생 보이면 안됨
public class Main {

//    public static int[] dirX = {0, 1, 0, -1};
//    public static int[] dirY = {-1, 0, 1, 0};

    public static boolean possible;

    public static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void checkAns(String[][] arr, List<Pos> possiblePos){

        boolean check = true;

//        System.out.println("시작");
        for(Pos pos : possiblePos){

//            System.out.println(pos.x + " " + pos.y);

            arr[pos.y][pos.x] = "V";        // V이면 장벽
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j].equals("T")){              //선생님이면 상하좌우 탐색
                    int x = j;
                    int y = i;

                    while(--y >= 0){
                        if(arr[y][x].equals("V")) break;
                        if(arr[y][x].equals("S")) {
                            check = false;
                            break;
                        }
                    }
                    y = i;
                    while(++y < arr.length){
                        if(arr[y][x].equals("V")) break;
                        if(arr[y][x].equals("S")) {
                            check = false;
                            break;
                        }
                    }
                    y = i;
                    while(--x >= 0){
                        if(arr[y][x].equals("V")) break;
                        if(arr[y][x].equals("S")) {
                            check = false;
                            break;
                        }
                    }
                    x = j;
                    while(++x < arr.length){
                        if(arr[y][x].equals("V")) break;
                        if(arr[y][x].equals("S")) {
                            check = false;
                            break;
                        }
                    }
                    x = j;
                }
            }
        }

        for(Pos pos : possiblePos){
            arr[pos.y][pos.x] = "X";        // V이면 장벽
        }

        if(check) possible = true;
    }

    public static void DFS(String[][] arr, List<Pos> xPos, boolean[][] check, List<Pos> possiblePos){

        if(possiblePos.size() == 3){
            checkAns(arr, possiblePos);
        }
        else{
            for(Pos pos : xPos){
                if(check[pos.y][pos.x]) continue;

                possiblePos.add(pos);
                check[pos.y][pos.x] = true;
                DFS(arr, xPos, check, possiblePos);
                possiblePos.remove(pos);
                check[pos.y][pos.x] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());

        String[][] arr = new String[size][size];
        boolean[][] check = new boolean[size][size];
        List<Pos> xPos = new ArrayList<>();
        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                arr[i][j] = stringTokenizer.nextToken();

                if(arr[i][j].equals("X")) xPos.add(new Pos(j, i));
            }
        }


        possible = false;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(arr[i][j].equals("X") && !check[i][j]){

                    List<Pos> possiblePos = new ArrayList<>();
                    possiblePos.add(new Pos(j, i));
                    check[i][j] = true;
                    DFS(arr, xPos, check, possiblePos);
                }
            }
        }

        System.out.println(possible == true ? "YES" : "NO");

    }
}