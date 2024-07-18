import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 양분은 처음에 5.
// 봄 -> 자기 나이만큼 양분 먹고 나이 + 1  /  여러개 있으면 나이 어린 나무부터. 양분 부족하면 바로 죽음
// 여름 -> 봄에 죽은 나무가 양분 됨. 나이 / 2
// 가을 -> 나이가 5배수인 나무들 번식. 인접한 8칸에 나이 1인 나무 생김.
// 겨울 -> 양분 추가.
// K년 후, 살아있는 나무 수
public class Main {

    public static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};     //북부터 시계방향
    public static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static class Tree{
        int x, y, age;

        public Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    // 봄 -> 자기 나이만큼 양분 먹고 나이 + 1  /  여러개 있으면 나이 어린 나무부터. 양분 부족하면 바로 죽음
    public static List<Tree> spring(List<Tree>[][] trees, int[][] currFood){
        int size = trees.length;

        List<Tree> deadTree = new ArrayList<>();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                List<Tree> currTreeList = trees[i][j];
                // 나이 기준 정렬
                Collections.sort(currTreeList, new Comparator<Tree>() {
                    @Override
                    public int compare(Tree o1, Tree o2) {
                        return o1.age - o2.age;
                    }
                });

                for(Tree tree : currTreeList){
                    if(currFood[i][j] >= tree.age){ // 양분 충분하면
                        currFood[i][j] -= tree.age;
                        tree.age++;
                    }
                    else{               // 양분 부족하면
                        deadTree.add(tree);
                    }
                }
            }
        }
        return deadTree;
    }

    // 여름 -> 봄에 죽은 나무가 양분 됨. 나이 / 2
    public static void summer(List<Tree>[][] trees, List<Tree> deadTrees, int[][] currFood){
        for(Tree tree : deadTrees){
            int currX = tree.x;
            int currY = tree.y;

            currFood[currY][currX] += tree.age / 2;

            trees[currY][currX].remove(tree);           // 죽음
        }
    }

    // 가을 -> 나이가 5배수인 나무들 번식. 인접한 8칸에 나이 1인 나무 생김.
    public static void fall(List<Tree>[][] trees){
        int size = trees.length;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(Tree tree : trees[i][j]){
                    if(tree.age % 5 == 0){          // 나이가 5배수이면 번식
                        spread(trees, j, i);
                    }
                }
            }
        }
    }

    // 겨울 -> 양분 추가.
    public static void winter(int[][] currFood, int[][] addFood){
        int size = currFood.length;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                currFood[i][j] += addFood[i][j];
            }
        }
    }

    public static void spread(List<Tree>[][] trees, int x, int y){
        int size = trees.length;

        for(int i = 0; i < 8; i++){
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if((nextX < 0 || nextX >= size) || (nextY < 0 || nextY >= size)) continue;

            trees[nextY][nextX].add(new Tree(nextX, nextY, 1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int treeCnt = Integer.parseInt(stringTokenizer.nextToken());
        int year = Integer.parseInt(stringTokenizer.nextToken());

        int[][] currFood = new int[size][size];
        for(int i = 0; i < size; i++){
            Arrays.fill(currFood[i], 5);            // 초기 양분 5로 세팅
        }

        int[][] addFood = new int[size][size];          // 매년 겨울에 더해지는 양분
        for(int i = 0; i < size; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                addFood[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        List<Tree>[][] trees = new ArrayList[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                trees[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < treeCnt; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int age = Integer.parseInt(stringTokenizer.nextToken());
            trees[y][x].add(new Tree(x, y, age));
        }

        while(year-- > 0){
            List<Tree> deadTrees = spring(trees, currFood);
            summer(trees, deadTrees, currFood);
            fall(trees);
            winter(currFood, addFood);
        }

        int ans = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                ans += trees[i][j].size();
            }
        }

        System.out.println(ans);
    }
}