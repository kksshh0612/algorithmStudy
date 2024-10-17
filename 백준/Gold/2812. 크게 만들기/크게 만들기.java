import java.util.*;
import java.io.*;

public class Main {

    public static class Number{
        int idx, num;
        public Number(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }

    public static String makeBig(int size, int[] arr, int currMaxIdx){
        PriorityQueue<Number> numPq = new PriorityQueue<>(new Comparator<Number>(){
            @Override
            public int compare(Number o1, Number o2){
                if(o2.num == o1.num){
                    return o1.idx - o2.idx;
                }
                return o2.num - o1.num;
            }
        });
        PriorityQueue<Number> idxPq = new PriorityQueue<>(new Comparator<Number>(){
            @Override
            public int compare(Number o1, Number o2){
                return o1.idx - o2.idx;
            }
        });

        StringBuilder ans = new StringBuilder();

        // 반복문 돌면서 numPq에 세팅
        for(int i = 0; i < arr.length; i++){
            numPq.add(new Number(i, arr[i]));
        }

        int prevIdx = -1;

        // 하나씩 꺼내면서 currMaxIdx보다 인덱스 크면 idxPq에 넣음
        while(currMaxIdx < size){

            // idxPq에서 뺄 수 있으면 빼서 넣기
            while(!idxPq.isEmpty() && currMaxIdx < size){
                if(idxPq.peek().idx <= currMaxIdx && idxPq.peek().idx > prevIdx){
                    Number currNumber = idxPq.poll();
                    ans.append(currNumber.num);
                    currMaxIdx++;
                    prevIdx = currNumber.idx;
                }
                else{
                    break;
                }
            }

            if(numPq.isEmpty()) continue;

            Number curr = numPq.poll();

            if(curr.idx < prevIdx){
                continue;
            }

            if(curr.idx > currMaxIdx){
                idxPq.add(curr);
            }
            else{
                ans.append(curr.num);
                currMaxIdx++;
                prevIdx = curr.idx;
            }
        }


        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int removeCnt = sc.nextInt();
        String input = sc.next();
        int[] arr = new int[size];
        for(int i = 0; i < input.length(); i++){
            arr[i] = input.charAt(i) - '0';
        }

        System.out.println(makeBig(size, arr, removeCnt));


    }
}