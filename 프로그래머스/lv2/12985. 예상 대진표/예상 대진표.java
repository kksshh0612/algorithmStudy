class Solution
{       //1 2  3 4 5 6 7 8
        //  1  2   3   4  
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true){
            answer++;
            
            if((a % 2 == 1 && a + 1 == b) || (b % 2 == 1 && b + 1 == a)){
                break;
            }
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            
        }

        return answer;
    }
}