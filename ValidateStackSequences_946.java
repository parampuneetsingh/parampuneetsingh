import java.util.LinkedList;

//https://leetcode.com/problems/validate-stack-sequences/submissions/

public class ValidateStackSequences_946 {
	
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        int popIdx = 0;
        
        for (int i=0; i < pushed.length; i++) {
            if (pushed[i] != popped[popIdx]) {
                list.add(pushed[i]);
            } else {
                popIdx++;
                while (popIdx < popped.length && !list.isEmpty() && list.peekLast() == popped[popIdx]) {
                	list.pollLast();
                	popIdx++;
                }
            }
        }
        
        return (popIdx == popped.length);
    }
    
	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1}; //True
		//int[] pushed = {2,1,0}, popped = {1,2,0}; //True
		System.out.println(validateStackSequences(pushed, popped));
	}

}
