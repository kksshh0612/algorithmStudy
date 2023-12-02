class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        int idx = 0;
        for(String[] photoArr : photo){
            int sum = 0;
            for(String  person : photoArr){
                for(int i = 0; i < name.length; i++){
                    if(person.equals(name[i])){
                        sum += yearning[i];
                    }
                }
            }
            answer[idx++] = sum;
        }
        
        return answer;
    }
}