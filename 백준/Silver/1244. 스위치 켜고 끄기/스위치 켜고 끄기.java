import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 남자 ( 1 ) : 자기 번호 배수 스위치 바꿈
// 여자 ( 2 ) : 자기 번호 좌우 대칭이면 대칭인데까지 바꿈 . 대칭 아니면 자기 번호만 바꿈
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int switchSize = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[switchSize + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= switchSize; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int peopleSize = Integer.parseInt(bufferedReader.readLine());
        int[][] people = new int[peopleSize][2];

        for(int i = 0; i < peopleSize; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            people[i][0] = Integer.parseInt(stringTokenizer.nextToken());       // 성별
            people[i][1] = Integer.parseInt(stringTokenizer.nextToken());       // 본인 숫자

            if(people[i][0] == 1){                  // 남자이면
                int curr = people[i][1];            // 남자의 본인 숫자

                while(curr <= switchSize){
                    if(arr[curr] == 1) arr[curr] = 0;
                    else arr[curr] = 1;
                    curr += people[i][1];
                }
            }
            else{                                   // 여자이면
                int curr = people[i][1];            // 여자의 본인 숫자
                int prev = curr;
                int after = curr;

                while(prev > 1 && after < switchSize){
                    if(arr[prev - 1] == arr[after + 1]){
                        if(arr[prev - 1] == 1){
                            arr[prev - 1] = 0;
                            arr[after + 1] = 0;
                        }
                        else{
                            arr[prev - 1] = 1;
                            arr[after + 1] = 1;
                        }
                        prev--;
                        after++;
                    }
                    else break;
                }
                if(arr[people[i][1]] == 1) arr[people[i][1]] = 0;
                else arr[people[i][1]] = 1;
            }
        }

        for(int i = 1; i <= switchSize; i++){
            if(i % 20 == 1 && i != 1){
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    }
}