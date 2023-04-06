import java.util.ArrayList;

public class countCharater {
    public static void main(String[] args) {
        String str="afdjkjwkmvooiwmnclsjujdkjdsksl";
        ArrayList<Character> str1=new ArrayList<>();
        ArrayList<Integer> str2 = new ArrayList<>();
        while(!str.isEmpty()){
            char val=str.charAt(0);
            int isNull = 0;
            for(int i=0;i<str1.size();i++){
                if(str1.get(i)==val){
                    isNull=1;
                    str2.set(i, str2.get(i)+1);
                }
            }
            if(isNull==0){
                str1.add(val);
                str2.add(1);
            }
            isNull=0;
            str=str.substring(1);
        }
        System.out.println(str1);
        System.out.println(str2);
    }
}
