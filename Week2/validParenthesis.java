import java.util.Stack;

public class validParenthesis{
    // tc = O(n)
    // sc = O(n)
       public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if ((ch == ')' && st.peek() == '(') || (ch == ']' && st.peek() == '[') || (ch == '}' && st.peek() == '{')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
    public static void main(String[] args) {
        validParenthesis vp = new validParenthesis();
        String s = "{[()]}";
        String s2 = "{[(])}";
        System.out.println(vp.isValid(s2));
        System.out.println(vp.isValid(s));
    }
}
