import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class powerset
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> ll=new ArrayList<>();
        print(s,ll,"");
        Collections.sort(ll);
        // System.out.println(ll);
        return ll;
    }
    public static void print(String s,List<String> ll,String curr){
        if(s.length()==0 && curr.length()>0){
            ll.add(curr);
            return;
        }
        if(s.length()>0){
        print(s.substring(1),ll,curr);
        print(s.substring(1),ll,curr+s.charAt(0));
        }
    }
}