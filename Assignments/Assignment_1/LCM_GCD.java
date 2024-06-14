public class LCM_GCD {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        Long x=A;
        Long y=B;
        Long r=x%y;
        Long gcd=(long)0;
        while(r!=0){
            x=y;
            y=r;
            r=x%y;
        }
        gcd=y;
        Long lcm=(A*B)/gcd;
        Long res[]={lcm,gcd};
        return res;
    }
}
