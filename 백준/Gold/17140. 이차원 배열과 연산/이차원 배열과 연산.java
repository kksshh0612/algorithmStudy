import java.io.*;
import java.util.*;

// 행의 개수가 열의 갯수보다 크거나 같을 때 행 정렬 (R)
// 행의 개수가 열의 갯수보다 적을 때 열 정렬 (C)
// 수의 빈도수 작은 순, 수가 작은 순 정렬. 다시 배열에 넣을 때는 수, 빈도수 넣기
// 빈 칸은 0 넣기    크기 100 넘어가면 자르기.
public class Main {

    public static int[][] moveRow(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < row; i++){
            list.add(new ArrayList<>());

            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 0) continue;

                if(map.containsKey(arr[i][j])){
                    map.put(arr[i][j], map.get(arr[i][j]) + 1);
                }
                else{
                    map.put(arr[i][j], 1);
                }
            }

            List<Integer> keySet = new ArrayList<>(map.keySet());
            Collections.sort(keySet, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    if(map.get(o2) == map.get(o1)){
                        return o1 - o2;
                    }
                    return map.get(o1) - map.get(o2);
                }
            });

            for(Integer key : keySet){

                list.get(i).add(key);
                list.get(i).add(map.get(key));
            }
        }

        int max = 0;
        for(int i = 0; i < row; i++){
            max = Math.max(max, list.get(i).size());
        }

        if(max > 100) max = 100;

        for(int i = 0; i < row; i++){       // 빈 부분 0으로 채우기
            if(list.get(i).size() < max){
                int size = list.get(i).size();
                for(int j = 0; j < max - size; j++){
                    list.get(i).add(0);
                }
            }
        }

        int[][] returnArr = new int[row][max];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < max; j++){
                returnArr[i][j] = list.get(i).get(j);
            }
        }

        return returnArr;
    }

    public static int[][] moveCol(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < col; i++){
            list.add(new ArrayList<>());

            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < row; j++){
                if(arr[j][i] == 0) continue;

                if(map.containsKey(arr[j][i])){
                    map.put(arr[j][i], map.get(arr[j][i]) + 1);
                }
                else{
                    map.put(arr[j][i], 1);
                }
            }

            List<Integer> keySet = new ArrayList<>(map.keySet());
            Collections.sort(keySet, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    if(map.get(o2) == map.get(o1)){
                        return o1 - o2;
                    }
                    return map.get(o1) - map.get(o2);
                }
            });

            for(Integer key : keySet){
                list.get(i).add(key);
                list.get(i).add(map.get(key));
            }
        }
        int max = 0;
        for(int i = 0; i < col; i++){
            max = Math.max(max, list.get(i).size());
        }

        if(max > 100) max = 100;

        for(int i = 0; i < col; i++){       // 빈 부분 0으로 채우기
            if(list.get(i).size() < max){
                int size = list.get(i).size();
                for(int j = 0; j < max - size; j++){
                    list.get(i).add(0);
                }
            }
        }

        int[][] returnArr = new int[max][col];

        for(int i = 0; i < max; i++){
            for(int j = 0; j < col; j++){
                returnArr[i][j] = list.get(j).get(i);
            }
        }

        return returnArr;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int targetRow = Integer.parseInt(st.nextToken()) - 1;
        int targetCol = Integer.parseInt(st.nextToken()) - 1;
        int targetNum = Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][3];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int[][] currArr = arr;
        while(true){
            if((targetRow < currArr.length) && (targetCol < currArr[0].length)){
                if(currArr[targetRow][targetCol] == targetNum) break;
            }

            time++;
            if(currArr.length >= currArr[0].length){
                currArr = moveRow(currArr);
            }
            else{
                currArr = moveCol(currArr);
            }

            if(time > 100) {
                time = -1;
                break;
            }
        }

        System.out.println(time);
    }
}