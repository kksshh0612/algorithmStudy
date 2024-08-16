import java.util.*;

// 여는괄호 <-> 닫는괄호 최소 연산 수
// 여는괄호 -> stack에 넣음.
// 닫는괄호 -> stack에서 뺌. stack 비어있으면 여는괄호로 바꾸고 cnt + 1 후 stack 에 넣음
// 끝나면 여는괄호 수 / 2를 cnt에 더함
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(true){
            String str = sc.nextLine();
            int openCnt = 0, changeCnt = 0;

            if(str.charAt(0) == '-') break;

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '{') openCnt++;
                else{       // 닫는 괄호
                    if(openCnt == 0){       // 앞에 여는 괄호 없었으면
                        openCnt++;
                        changeCnt++;
                    }
                    else{
                        openCnt--;
                    }
                }
            }
            changeCnt += openCnt / 2;

            sb.append(idx).append(". ").append(changeCnt).append("\n");
            idx++;
        }

        System.out.println(sb.toString());
    }
}