import java.util.*;
import java.io.*;

// 그리디 - 시작 순 오름차순 정렬. 큐도 마찬가지
// 넣을 때, 큐의 peek와 값 비교해서 겹치면 길이 합쳐서 업데이트
public class Main {
    public static class Line{
        int start, end;
        public Line(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        List<Line> inputList = new ArrayList<>();

        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            inputList.add(new Line(start, end));
        }
        Collections.sort(inputList, new Comparator<Line>(){
            @Override
            public int compare(Line o1, Line o2){
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Line> pq = new PriorityQueue<>(new Comparator<Line>(){
            @Override
            public int compare(Line o1, Line o2){
                return o2.start - o1.start;
            }
        });

        // 넣을 때, 큐의 peek와 값 비교해서 겹치면 길이 합쳐서 업데이트
        for(Line currLine : inputList){
            if(pq.isEmpty()){
                pq.add(currLine);
                continue;
            }

            Line peekLine = pq.peek();

            // 겹치는 경우
            if(peekLine.start <= currLine.start && currLine.start <= peekLine.end){
                int sumStart = Math.min(currLine.start, peekLine.start);
                int sumEnd = Math.max(currLine.end, peekLine.end);
                pq.poll();
                pq.add(new Line(sumStart, sumEnd));
            }
            else{                       // 이전에 있던 라인과 겹치지 않는 경우 새로 넣음
                pq.add(currLine);
            }
        }

        int ans = 0;
        while(!pq.isEmpty()){
            Line line = pq.poll();
            ans += (line.end - line.start);
        }

        System.out.println(ans);
    }
}