import java.util.*;

public class RemoveInvalidParenthesis {

    static boolean isValidString(String str)
    {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null){
            return res;
        }

        // To keep track of which strings have already been visited
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        visited.add(s);
        boolean found = false;

        //bfs
        while(!q.isEmpty()){
            int size = q.size();
            for(int x = 0; x < size; x++) {
                s = q.poll();
                System.out.println("String " + s);
                System.out.println("found " + found);
                if (isValidString(s)) {
                    res.add(s);
                    found = true;
                }
                if (!found) {
                    // generate all possible states
                    for (int i = 0; i < s.length(); i++) {
                        // we only try to remove left or right paren
                        if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                        String t = s.substring(0, i) + s.substring(i + 1);

                        if (!visited.contains(t)) {
                            // for each state, if it's not visited, add it to the queue
                            q.add(t);
                            visited.add(t);
                        }
                    }
                }
            }
        }

        return res;
    }

    public void print(List<String> list){
        for(String s : list){
            System.out.println(s);
        }
    }

    public static void main(String[] args){
        RemoveInvalidParenthesis obj = new RemoveInvalidParenthesis();
        String s = "()())()";
        obj.print(obj.removeInvalidParentheses(s));

        s = "(a)())()";
        obj.print(obj.removeInvalidParentheses(s));

    }
}
