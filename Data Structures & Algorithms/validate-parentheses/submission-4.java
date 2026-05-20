class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> dict = new HashMap<>();
       
        dict.put(')', '(');
        dict.put('}', '{');
        dict.put(']', '[');

        for (int i = 0; i < s.length(); i++){
            char symbol = s.charAt(i);
            
            if (dict.containsKey(symbol)){
                // is there is a matching bracket in the stack
                if (!stack.isEmpty() && stack.peek()==dict.get(symbol)){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(symbol);
            }     
        }

        return stack.isEmpty();
    }
}


// every open neeeds closed
// so when we add open brackets to stack (LIFO), 
//the one we pop needs to be equal to the first closed bracker 