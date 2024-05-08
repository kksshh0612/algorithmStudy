import java.util.*;

// 데이터에서 ext가 val_ext보다 작은 것들만 뽑아 sort_by 기준으로 정렬
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        Map<String, Integer> sortMap = new HashMap<>();
        sortMap.put("code", 0);
        sortMap.put("date", 1);
        sortMap.put("maximum", 2);
        sortMap.put("remain", 3);
        
        List<Integer[]> list = new ArrayList<Integer[]>();
        
        for(int i = 0; i < data.length; i++){
            
            if(data[i][sortMap.get(ext)] < val_ext){
                list.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
            }
        }
        
        Collections.sort(list, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] a, Integer[] b){
                return a[sortMap.get(sort_by)] - b[sortMap.get(sort_by)];
            }
        });
        
        answer = new int[list.size()][4];
        
        int idx = 0;
        for(Integer[] arr : list){
            answer[idx] = Arrays.stream(list.get(idx))
                .mapToInt(Integer::intValue)
                .toArray();
            
            idx++;
        }
        
        return answer;
    }
}