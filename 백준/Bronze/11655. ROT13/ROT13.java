import java.util.Scanner;

//11655 ROT13
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            char token = input.charAt(i);
            
            if(token >= 'A' && token <= 'Z'){
                if(token + 13 > 'Z'){
                    token = (char)((token + 13 - 'Z') - 1 + 'A');
                }
                else{
                    token = (char)(token + 13);
                }
                stringBuilder.append(token);
            }
            else if(token >= 'a' && token <= 'z'){
                if(token + 13 > 'z'){
                    token = (char)((token + 13 - 'z') - 1 + 'a');
                }
                else{
                    token = (char)(token + 13);
                }
                stringBuilder.append(token);
            }
            else{
                stringBuilder.append(token);
            }
        }

        System.out.println(stringBuilder.toString());
    }

}