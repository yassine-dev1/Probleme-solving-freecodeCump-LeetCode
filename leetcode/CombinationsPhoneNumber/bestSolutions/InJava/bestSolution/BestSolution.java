package bestSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestSolution {
    
   private void solve(HashMap<Character,String> hm,List<String> ans,StringBuilder str,int idx,int n,String digits)
    {
        if(idx==n)
        {
            ans.add(str.toString());
            return;
        }
        String st=hm.get(digits.charAt(idx));
        for(int i=0;i<st.length();i++)
        {
            str.append(st.charAt(i));
            solve(hm,ans,str,idx+1,n,digits);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
       HashMap<Character,String> hm=new HashMap<>();
       hm.put('2',"abc");
       hm.put('3',"def");
       hm.put('4',"ghi");
       hm.put('5',"jkl");
       hm.put('6',"mno");
       hm.put('7',"pqrs");
       hm.put('8',"tuv");
       hm.put('9',"wxyz");
       List<String> ans=new ArrayList<>();
       StringBuilder str=new StringBuilder();
       int n=digits.length();
       solve(hm,ans,str,0,n,digits);
       return ans;
    }
}
