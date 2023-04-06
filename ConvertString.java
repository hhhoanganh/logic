public class ConvertString{
    public static String convert(byte[] str){
        for(int i=0;i<str.length/2;i++){
            byte temp= str[i];
            str[i]=str[str.length-i-1];
            str[str.length-i-1] = temp;
        }
        return new String(str);
    }
    public static void main(String[] args) {
        String str= "jhabsjdanslkj";
        byte[] str1= str.getBytes();
        System.out.println(convert(str1));
    }
}