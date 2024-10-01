import java.util.*;
// 재생 수 많은 장르 순으로 수록
// 장르 내에서 재생 많은 노래 순으로 수록
// 고유번호 오름차순 수록
// 두 개 씩
class Solution {
    
    public static class Music{
        int idx, cnt;
        public Music(int i, int c){
            this.idx = i;
            this.cnt = c;
        }
    }
    
    public static class Genre{
        int sum;
        List<Music> list;
        public Genre(int sum){
            this.sum = sum;
            list = new ArrayList<>();
        }
        
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Genre> map = new HashMap<>();
        
        // 장르별 묶어 저장
        for(int i = 0; i < genres.length; i++){
            String currGenre = genres[i];
            int currMusicCnt = plays[i];
            
            if(!map.containsKey(currGenre)){
                map.put(currGenre, new Genre(0));
            }
            map.get(currGenre).sum += currMusicCnt;
            map.get(currGenre).list.add(new Music(i, currMusicCnt));
        }
        
        // 장르별 총 재생 수로 내림차순 정렬
        List<Genre> genreList = new ArrayList<>();
        for(String key : map.keySet()){
            genreList.add(map.get(key));
        }
        Collections.sort(genreList, new Comparator<Genre>(){
            @Override
            public int compare(Genre o1, Genre o2){
                return o2.sum - o1.sum;
            }
        });
        
        // 장르별 곡들 내림차순 정렬 후 2개씩 선택
        for(Genre gen : genreList){
            List<Music> musicList = gen.list;
            
            // 곡 내림차순 정렬
            Collections.sort(musicList, new Comparator<Music>(){
                @Override
                public int compare(Music o1, Music o2){
                    if(o1.cnt == o2.cnt){
                        return o1.idx - o2.idx;
                    }
                    return o2.cnt - o1.cnt;
                }
            });
            
            int currCnt = 0;
            for(int i = 0; i < musicList.size(); i++){
                if(currCnt == 2) break;
                answer.add(musicList.get(i).idx);
                currCnt++;
            }
        }
        
        
        
        return answer;
    }
}