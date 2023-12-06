import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    public static class Word implements Comparable<Word>{
        String name;
        int cnt;

        public Word(String name) {
            this.name = name;
            cnt = 1;
        }

        @Override
        public int compareTo(final Word o) {
            if (this.cnt != o.cnt) {
                return o.cnt - this.cnt;
            }

            if (this.name.length() != o.name.length()) {
                return o.name.length() - this.name.length();
            }

            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int wordSize = Integer.parseInt(stringTokenizer.nextToken());
        Map<String, Word> map = new HashMap<>();

        List<Word> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String str = bufferedReader.readLine();

            if(str.length() < wordSize) continue;

            if(map.containsKey(str)){
                map.get(str).cnt++;
            }
            else{
                Word word = new Word(str);
                map.put(str, word);
                list.add(word);
            }
        }

        Collections.sort(list);


        StringBuilder stringBuilder = new StringBuilder("");
        for(Word word : list){
            stringBuilder.append(word.name);
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
