import java.util.*;

// 큰 숫자를 왼쪽에 배치
// V, L, D는 한번씩만 나머지는 연속 세번까지
// IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900 한번씩만
// XL, XC 같이 못씀.  CD, CM 같이 못씀
// 가장 적은 수의 로마 숫자로 표현하기
public class Main {

    public static Map<String, Integer> map = new HashMap<>();

    // 가장 적은 로마숫자로 표시한 것.
    public static int converToNumber(String str){
        int ans = 0;
        for(int i = 0; i < str.length(); i++){
            String token = str.substring(i, i + 1);

            if((token.equals("I") || token.equals("X") || token.equals("C"))
                    && i + 1 < str.length()){

                String combinedToken = str.substring(i, i + 2);
                if(map.containsKey(combinedToken)){
                    ans += map.get(combinedToken);
                    i++;
                    continue;
                }
            }
            ans += map.get(token);
        }
        return ans;
    }

    public static String convertToString(int number){
        List<String> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder ans = new StringBuilder();
        while(number > 0){

            for(String key : keys){
                if(map.get(key) <= number){
                    number -= map.get(key);
                    ans.append(key);
                    break;
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        // 로마 - 숫자 쌍 입력 - 나머지 연속 세번
        map.put("I", 1);
        map.put("V", 5);        // 한번
        map.put("X", 10);
        map.put("L", 50);       // 한번
        map.put("C", 100);
        map.put("D", 500);      // 한번
        map.put("M", 1000);

        // 한번만 - XL, XC 같이 못씀.  CD, CM 같이 못씀
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = converToNumber(str1) + converToNumber(str2);
        String sumString = convertToString(sum);

        System.out.println(sum + "\n" + sumString);
    }
}