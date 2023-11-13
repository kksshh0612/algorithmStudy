import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 적어도 m미터 가져가는데 필요한 절단기 최대 높이
//public class Boj2805 {
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int treeNum = Integer.parseInt(stringTokenizer.nextToken());
        int goalLength = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] tree = new int[treeNum];
        for(int i = 0 ; i < treeNum; i++){
            tree[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(tree);

        int maxHeight = tree[tree.length - 1];
        long currLength = 0;

        int start = 0, end = maxHeight, mid = 0;
        while(start <= end){

            mid = (start + end) / 2;
            currLength = 0;

            for(int i = 0; i < tree.length; i++){
                if(tree[i] > mid) currLength += tree[i] - mid;
            }

            if(currLength < goalLength){
                end = mid - 1;
            }
            else if(currLength >= goalLength){
                start = mid + 1;

            }
        }

        System.out.println(end);
    }
}
