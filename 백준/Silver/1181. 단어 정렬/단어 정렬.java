import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < size; i++){
            String str = scanner.next();
            if(!list.contains(str)) list.add(str);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else{
                    if(o1.length() < o2.length()) return -1;
                    else return 1;
                }
            }
        });

        for(String str : list){
            System.out.println(str);
        }
    }
}