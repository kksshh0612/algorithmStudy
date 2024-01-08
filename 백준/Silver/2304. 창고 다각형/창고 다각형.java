import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 높은거 기준 왼쪽, 오른쪽을 탐색하면서 stack top 보다 높으면 스택에 넣음.
// 가장 높은 탑에 도달하면 스택에서 빼면서 넓이를 더함. (왼쪽, 오른쪽 동일)
//public class Boj2304 {
public class Main {
    public static class Tower{
        int pos, height;

        public Tower(int pos, int height){
            this.pos = pos;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int towerNum = Integer.parseInt(bufferedReader.readLine());
        List<Tower> towerList = new ArrayList<>();

        int maxHeight = 0, maxPos = 0;
        for(int i = 0; i < towerNum; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int pos = Integer.parseInt(stringTokenizer.nextToken());
            int height = Integer.parseInt(stringTokenizer.nextToken());
            towerList.add(new Tower(pos, height));

            if(maxHeight < height){
                maxHeight = height;
                maxPos = pos;
            }
        }

        Collections.sort(towerList, new Comparator<Tower>() {
            @Override
            public int compare(Tower o1, Tower o2) {
                if(o1.pos < o2.pos) return -1;
                else if(o1.pos == o2.pos) return 0;
                else return 1;
            }
        });

        Stack<Tower> leftStack = new Stack<>();
        Stack<Tower> rightStack = new Stack<>();

        if(towerList.size() > 1){

            if(towerList.get(0).pos != maxPos) leftStack.push(towerList.get(0));
            if(towerList.get(towerList.size() - 1).pos != maxPos) rightStack.push(towerList.get(towerList.size() - 1));

            int currTowerIdx = 1;
            int currPos = towerList.get(currTowerIdx).pos;

            while(currPos < maxPos){
                if(leftStack.peek().height < towerList.get(currTowerIdx).height){
                    leftStack.push(towerList.get(currTowerIdx));
                }
                currPos = towerList.get(++currTowerIdx).pos;
            }

            currTowerIdx = towerList.size() - 2;
            currPos = towerList.get(currTowerIdx).pos;

            while(maxPos < currPos){
                if(rightStack.peek().height < towerList.get(currTowerIdx).height){
                    rightStack.push(towerList.get(currTowerIdx));
                }
                currPos = towerList.get(--currTowerIdx).pos;
            }

        }

        int area = maxHeight;
        int currPos = maxPos;
        while (!leftStack.isEmpty()){
            Tower currTower = leftStack.pop();
            area += (currPos - currTower.pos) * currTower.height;
            currPos = currTower.pos;
        }

        currPos = maxPos;
        while(!rightStack.isEmpty()){
            Tower currTower = rightStack.pop();
            area += (currTower.pos - currPos) * currTower.height;
            currPos = currTower.pos;
        }

        System.out.println(area);

    }
}