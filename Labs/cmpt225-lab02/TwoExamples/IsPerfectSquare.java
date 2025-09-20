public class IsPerfectSquare {
    /**
     * @param n
     * @return True if n is a perfect square
     */
    static boolean IsPerfectSquare(int n){
        if(n < 0){
            return false;
        }
        for(int i = 0; i <= n; i++){
            if(i * i == n){
                return true;
            }
        }

        // Not perfect square
        return false;
    }

    public static void main(String[] args){
        int input = Integer.valueOf(args[0]);
        System.out.println("Is "+input+ " a square :" + IsPerfectSquare(input));
    }
}
