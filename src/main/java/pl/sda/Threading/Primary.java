package pl.sda.Threading;

/**
 * Created by RENT on 2017-01-14.
 */
public class Primary {
    public static void main(String[] args) {
        Primary.checkPrime(15485853);
    }
    public static void checkPrime (int x){
        for (int i = 2  ; i <x/2 ; i++) {
            if (x%i==0){
                System.out.println("Pierwsza");
            }
        }
    }
}
