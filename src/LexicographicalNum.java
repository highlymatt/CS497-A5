import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalNum {

    //O(nlog(n))
    public String[] lexicographicalNum(int n){
        String[] res = new String[n];
        for(int s = 0; s < n; s++){
            res[s] = Integer.toString(s+1);
        }
        Arrays.sort(res);
        return res;
    }

    public List<Integer> lexicographicalNumV2(int n){
        List<Integer> list = new ArrayList<>();
        dfs(1,n,list);
        return list;
    }

    public static void dfs(int temp, int n, List<Integer> list) {
        if (temp > n)
            return;
        list.add(temp);
        dfs(temp * 10, n, list);
        if (temp % 10 != 9)
            dfs(temp + 1, n, list);
    }

    public void print(String[] nums){
        for(String x : nums){
            System.out.println(x);
        }
        System.out.println();
    }

    public static void main(String[] args){
        LexicographicalNum obj = new LexicographicalNum();
        int n = 13;
        System.out.println(obj.lexicographicalNumV2(n));
        n = 2;
        System.out.println(obj.lexicographicalNumV2(n));
    }
}
