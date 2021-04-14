import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * Assumptions 1: Empty string is valid pattern
 * Assumptions 2: No other chars except {}()[] and <space>
 */
public class Lisp {

	public static void main(String args[]) {
		System.out.println("Enter the String: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
//		String input = "{[]}(){{{{{{}  () }}}}[][]}";
		input=input.replaceAll(" ","");
		char c[] = input.toCharArray();
		
		if(lispChecker(c))
			System.out.println("Valid");
		else 
			System.out.println("Not Valid");
		
	}
	
	private static boolean lispChecker(char[] cArr) {
		
		// Char map to get the matching parenthesis 
		HashMap<Character, Character> charMap = new HashMap<>();
		charMap.put('(', ')');
		charMap.put('[', ']');
		charMap.put('{', '}');
		// Storing the left parenthesis to stack for easy operation
		Stack<Character> charStack = new Stack<>();
		for(char each: cArr) {
			if (each=='(' || each=='{' || each=='[') {
				charStack.add(each);
			} 
			// if right parenthesis pop from the stack check in the map for value 
			else if ( (each==')' || each=='}' || each==']') && charMap.get(charStack.pop()) != each) {
				return false;
			}
		}
		// Assumption: Empty input is also valid 
		// if valid then stack should be empty
		if(charStack.isEmpty())
			return true;
		return false;
	}
}
