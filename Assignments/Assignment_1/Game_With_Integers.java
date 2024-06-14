import java.util.*;
public class Game_With_Integers {
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t=sc.nextInt();
            while(t-->0){
                int n=sc.nextInt();
                if((n+1)%3==0 || (n-1)%3==0){
                    System.out.println("First");
                }
                else{
                    System.out.println("Second");
                }
            }
        }
    }
}
