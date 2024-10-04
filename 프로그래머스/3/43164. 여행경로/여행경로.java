import java.util.*;

class Solution {
    
    public static List<String> ansList = new ArrayList<>();
    public static boolean[] check;
    
    public static void dfs(String[][] tickets, int cnt, String curr, String ans){
        if(cnt == tickets.length){
            ansList.add(ans);
        }
        else{
            for(int i = 0; i < tickets.length; i++){
                if(!check[i] && tickets[i][0].equals(curr)){
                    check[i] = true;
                    dfs(tickets, cnt + 1, tickets[i][1], ans + " " + tickets[i][1]);
                    check[i] = false;
                }
            }
            
        }
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        check = new boolean[tickets.length];
        
        dfs(tickets, 0, "ICN", "ICN");
        
        Collections.sort(ansList);
        
        return ansList.get(0).split(" ");
    }
}