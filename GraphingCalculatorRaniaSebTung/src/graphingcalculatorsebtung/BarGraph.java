
public class BarGraph {

	BarGraph(){
		
	}
	
	public static int[] StringToArray(String setOfIntegers) {
		String[] arrayOfStrings =setOfIntegers.split(" ") ;
		int[] array;
		array = new int[arrayOfStrings.length];
		for (int i=0;i<arrayOfStrings.length;i++)
	    array[i] = Integer.parseInt(arrayOfStrings[i]);
		
		return array;
	}
	
}
