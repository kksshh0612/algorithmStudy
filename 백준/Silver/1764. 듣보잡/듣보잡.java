import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hear = scanner.nextInt();
        int see = scanner.nextInt();
        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < hear; i++){
            String name = scanner.next();
            map.put(name, true);
        }

        int cnt = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < see; i++){
            String name = scanner.next();
            
            if(map.containsKey(name)){
                cnt++;
                list.add(name);
            }
        }
        Collections.sort(list);

        System.out.println(cnt);
        for(String name : list){
            System.out.println(name);
        }

    }
}