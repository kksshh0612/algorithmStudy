import java.util.*;
// 최대한 앞에서부터 세야 함
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();

        int cnt = 0;
        int idx = 0;
        while(idx + target.length() <= str.length()){
            String subString = str.substring(idx, idx + target.length());

            if(subString.equals(target)){
                cnt++;
                idx = idx + target.length();

                continue;
            }
            idx++;
        }

        System.out.println(cnt);
    }
}