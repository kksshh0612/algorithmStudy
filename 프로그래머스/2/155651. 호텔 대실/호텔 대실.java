import java.util.*;

class Solution {
    
    public static class Book{
        int startM, endM;
        public Book(int startM, int endM){
            this.startM = startM;
            this.endM = endM;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Book> bookList = new ArrayList<>();
        
        // Job으로 세팅. 시간을 분으로 변환
        for(String[] book : book_time){
            String startTime = book[0];
            String endTime = book[1];
            
            int startM = Integer.parseInt(startTime.substring(0, 2)) * 60
                + Integer.parseInt(startTime.substring(3, 5));
            
            int endM = Integer.parseInt(endTime.substring(0, 2)) * 60
                + Integer.parseInt(endTime.substring(3, 5));
            
            bookList.add(new Book(startM, endM));
        }
        
        // 시작 시간 기준 오름차순 정렬
        Collections.sort(bookList, new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2){
                return o1.startM - o2.startM;
            }
        });
        
        // room의 끝나는 시간 우선순위 큐 생성 (끝나는 시간 기준 빠른 순)
        PriorityQueue<Integer> roomEndTimeQueue = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });
        
        // 우선순위 큐에서 하나 빼서 끝나는 시간 + 10 분 <= 현재 방 시작 시간 이면 그 방에 넣고 아니명 방 생성
        for(Book book : bookList){
            if(roomEndTimeQueue.isEmpty()){
                roomEndTimeQueue.add(book.endM);
            }
            else{
                int endTime = roomEndTimeQueue.peek();      // 현재 있는 방들 중 가장 빠른 시간
                if(endTime + 10 <= book.startM){
                    roomEndTimeQueue.poll();
                    roomEndTimeQueue.add(book.endM);     // 그 방에 넣을 수 있으면 넣음.
                }
                else{           // 어떤 방에도 넣을 수 없으면 
                    roomEndTimeQueue.add(book.endM);
                }
            }
        }
        
        answer = roomEndTimeQueue.size();
        
        return answer;
    }
}