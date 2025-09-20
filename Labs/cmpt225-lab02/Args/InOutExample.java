public class InOutExample {
    /*
     * @param n such that 0<=n<=20
     * @return factorial n
     */
    static long factorial(int n){
        if( n == 0 )return 1L;
        return n * factorial(n-1);
    }

    public static void main(String[] args){
        try{
            int n = Integer.valueOf(args[0]);
            if (n < 0 ){
                System.out.println("Invalid Argument for factorial");
            } else if ( n > 20 ) {
                System.out.println(" Number too Large");
            } else {
                System.out.println(factorial(n));
            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

    }
}
