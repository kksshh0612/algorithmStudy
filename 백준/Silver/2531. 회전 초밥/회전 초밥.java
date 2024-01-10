import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 어떤 위치에서 k개 연속으로 벅으면 정액 가격
// 쿠폰 있으면 해당 초밥 무료. 컨베이어벨트에 없을 경우 만들어서 줌.
// 손님이 먹을 수 있는 최대 가짓수
// 투포인터 슬라이딩 윈도우로 풀기.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int plateNum = Integer.parseInt(stringTokenizer.nextToken());
        int sushiNumInMenu = Integer.parseInt(stringTokenizer.nextToken());       // 메뉴에 있는 초밥 가짓수
        int continuePlateNum = Integer.parseInt(stringTokenizer.nextToken());     // 연속해서 먹는 접시 수
        int coupon = Integer.parseInt(stringTokenizer.nextToken());               // 쿠폰 번호

        Map<Integer, Integer> map = new HashMap<>();        // 초밥 번호 : 갯수
        int ans = 0;            // 정답

        int[] sushiArr = new int[plateNum];
        for(int i = 0; i < plateNum; i++){
            sushiArr[i] = Integer.parseInt(bufferedReader.readLine());

            if(i >= continuePlateNum) continue;

            if(map.containsKey(sushiArr[i])){
                map.put(sushiArr[i], map.get(sushiArr[i]) + 1);
            }
            else{
                map.put(sushiArr[i], 1);
            }
        }

        int start = 0, end = continuePlateNum - 1;
        while (start < plateNum){

            int outSushi = sushiArr[start++];

            // 현재 탐색 그룹에서 나온 스시에 대한 처리
            map.put(outSushi, map.get(outSushi) - 1);

            if(map.get(outSushi) <= 0) map.remove(outSushi);

            int inSushi = sushiArr[++end % plateNum];

            // 현재 탐색 그룹에 들어온 스시에 대한 처리
            if(map.containsKey(inSushi)){
                map.put(inSushi, map.get(inSushi) + 1);
            }
            else{
                map.put(inSushi, 1);
            }

            // 최댓값 찾기
            if(map.containsKey(coupon)){
                ans = Math.max(ans, map.size());
            }
            else{
                ans = Math.max(ans, map.size() + 1);
            }
        }

        System.out.println(ans);
    }
}