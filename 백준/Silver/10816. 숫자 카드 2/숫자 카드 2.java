import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        // 입력 & map에 저장
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sangunSize = Integer.parseInt(bf.readLine());

//        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < sangunSize; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{
//                list.add(num);
                map.put(num, 1);
            }
        }

        // 정렬
//        Collections.sort(list);

        // 테스트 입력 + 이분탐색
        int tCase = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();

        while(tCase-- > 0){
            int findNum = Integer.parseInt(st.nextToken());

            if(map.containsKey(findNum)){
                sb.append(map.get(findNum)).append(" ");
            }
            else{
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());



    }
}