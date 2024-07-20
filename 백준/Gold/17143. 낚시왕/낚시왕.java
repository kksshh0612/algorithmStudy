import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class shark {
        int s,d,z;

        public shark(int s, int d, int z) {
            super();
            this.s = s;
            this.d = d;
            this.z = z;
        }

    }

    static int R,C,M, answer=0;
    static shark [][] map, copy;
    static int [] dx = {0,-1,1,0,0};
    static int [] dy = {0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //상어 수

        map = new shark[R][C];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken()); //속력
            int d = Integer.parseInt(st.nextToken()); //이동 방향
            int z = Integer.parseInt(st.nextToken()); //크기

            map[r][c] = new shark(s,d,z);
        }

        for(int i=0;i<C;i++) {
            //1.한칸 이동해서 땅과 가장 가까운 상어 잡아먹기
            movePerson(i);

            //2.상어 이동하기
            moveShark();
        }

        System.out.println(answer);
    }

    public static void movePerson(int y) {
        for(int i=0;i<R;i++) {
            if(map[i][y]!=null) {
                answer+=map[i][y].z;
                map[i][y]=null;
                return;
            }
        }
    }

    public static void moveShark() {
        copy = new shark[R][C];

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(map[i][j]!=null) { //상어 움직이자!
                    shark temp = map[i][j];
                    map[i][j] = null;

                    int nx=i,ny=j;
                    for(int k=0;k<temp.s;k++) {
                        if(temp.d==1 && nx==0) temp.d=2;
                        else if(temp.d==2 && nx==R-1) temp.d=1;
                        else if(temp.d==3 && ny==C-1) temp.d=4;
                        else if(temp.d==4 && ny==0) temp.d=3;

                        nx+=dx[temp.d];
                        ny+=dy[temp.d];
                    }

                    if(copy[nx][ny]==null || copy[nx][ny].z<temp.z ) {
                        copy[nx][ny] = temp;
                    }
                }
            }
        }
        map = copy;
    }
}
