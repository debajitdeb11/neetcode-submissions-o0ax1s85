class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if ((c == ')' || c == ']' || c == '}')) {

                if(st.size() == 0) {
                    return false;
                }

                char out = st.pop();

                System.out.println(out);

                if (out == '(' && c != ')')
                   return false;

                if (out == '[' && c != ']')
                   return false;

                if (out == '{' && c != '}')
                   return false;
            } else {
              st.push(c);
            }

            
        }


        return st.size() == 0;
    }
}
