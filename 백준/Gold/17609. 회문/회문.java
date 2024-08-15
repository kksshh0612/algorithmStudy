import java.util.*;
// 회문 : 0    유사회문 : 1    그 외 : 2
public class Main {

    public static StringBuilder ans;

    public static void check(String str){
        int left = 0, right = str.length() - 1;

        StringBuilder string = new StringBuilder(str);

        if(str.equals(string.reverse().toString())) {
            ans.append("0").append("\n");
            return;
        }

        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
                continue;
            }

            StringBuilder deleteLeft = new StringBuilder(str).deleteCharAt(left);
            StringBuilder deleteRight = new StringBuilder(str).deleteCharAt(right);

            if(deleteLeft.toString().equals(deleteLeft.reverse().toString()) || deleteRight.toString().equals(deleteRight.reverse().toString())){
                ans.append("1").append("\n");
                return;
            }
            else{
                break;
            }
        }
        ans.append("2").append("\n");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ans = new StringBuilder();

        for(int i = 0; i < size; i++){
            String str = sc.next();
            check(str);
        }

        System.out.println(ans.toString());
    }
}