import java.util.*;

// 선택을 안하는 것도 방법임.
// 현재 데드라인에서 할 수 있는 것들 중, 가장 큰 것 넣기.
// 근데, 만약, 현재 날과 데드라인 일치하면 리스트에서 보상 가장 적은거 빼기
public class Main{

    public static class Problem{
        int deadLine, reward;

        public Problem(int deadLine, int reward){
            this.deadLine = deadLine;
            this.reward = reward;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Problem> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int deadLine = scanner.nextInt();
            int reward = scanner.nextInt();
            list.add(new Problem(deadLine, reward));
        }
        Collections.sort(list, new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2){
                if(o1.deadLine == o2.deadLine){
                    return o2.reward - o1.reward;
                }
                return o1.deadLine - o2.deadLine;
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(Problem problem : list){

            if(!priorityQueue.isEmpty() && problem.deadLine < priorityQueue.size()) continue;       // 이미 데드라인 지난 경우 pass
            
//            System.out.println(problem.deadLine + " " + problem.reward);

            if(!priorityQueue.isEmpty() && problem.reward > priorityQueue.peek()){
                if(problem.deadLine == priorityQueue.size()){
                    priorityQueue.poll();
                }
            }
            if(priorityQueue.size() < problem.deadLine){
                priorityQueue.add(problem.reward);
            }

        }

        int ans = 0;
        while (!priorityQueue.isEmpty()){
            ans += priorityQueue.poll();
        }

        System.out.println(ans);
    }
}