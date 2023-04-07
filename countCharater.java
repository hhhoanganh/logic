import java.util.HashMap;
public class countCharater {
    static void characterCount(String inputString) {
        HashMap<Character, Integer> cha = new HashMap<Character, Integer>();
        char[] charArray = inputString.toCharArray();
        for (char c : charArray) {
            if(cha.containsKey(c)) {
                cha.put(c, cha.get(c)+1);
            } else {
                cha.put(c, 1);
            }
        }
        System.out.println(cha);
    }
    public static void main(String[] args) {
        characterCount("snfjknajnqdankjasmaslaosdk");
    }
}