package Practice;

import org.apache.xerces.util.SynchronizedSymbolTable;

public class StringManipulation {

	public static void main(String[] args) {
		
		String str="The rains have started here";
		
		System.out.println(str.length());
		
		System.out.println(str.charAt(10));
		
		System.out.println(str.indexOf('s'));
		
		System.out.println(str.indexOf('s', str.indexOf('s')+1));
		
		System.out.println(str.indexOf('s', str.indexOf('s', str.indexOf('s')+1)+1));
		
	}

}
