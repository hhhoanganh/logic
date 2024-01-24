import java.util.HashMap;
public class CountWords {
    static void characterCount(String inputString) {
        HashMap<String, Integer> cha = new HashMap<String, Integer>();
        String[] strArray = inputString.split(" ");
        for (String c : strArray) {
            if(cha.containsKey(c)) {
                cha.put(c, cha.get(c)+1);
            } else {
                cha.put(c, 1);
            }
        }
        System.out.println(cha);
    }
    public static void main(String[] args) {
        characterCount("hom nay la ngay gi");
    }
}