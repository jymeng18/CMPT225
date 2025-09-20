public class EqualsExample {
    public static void main(String[] args){
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        if(s1 == s2) {
            System.out.println("Reference variables s1 and s2 are equal");
        }else if(s1.equals(s2)){
            System.out.println("String Objects referred by s1 and s2 are equal with respect to equals() method");
        }else{
            System.out.println("Neither references s1 and s2 are equal nor the referred objects are equal with equals method");
        }
        String s3 = new String("Hi");
        String s4 = new String("Hello");
        s3 = s4;
        if(s3 == s4) {
            System.out.println("Reference variables s3 and s4 are equal");
        }else if(s3.equals(s4)){
            System.out.println("String Objects referred by s3 and s4 are equal with respect to equals() method");
        }else{
            System.out.println("Neither references s3 and s4 are equal nor the referred objects are equal with equals method");
        }
    }
}
