import java.util.Arrays;

public class Statistics {

	Statistics(){
		
	}
	
	public static int[] StringToArray(String setOfIntegers) {
		String[] arrayOfStrings =setOfIntegers.split(" ") ;
		int[] array;
		array = new int[arrayOfStrings.length];
		for (int i=0;i<arrayOfStrings.length;i++)
	    array[i] = Integer.parseInt(arrayOfStrings[i]);
		
		return array;
	}
	
	
	 public static double calculateMean(String setOfIntegers) {
		    int array[]=StringToArray(setOfIntegers);
			double mean=0;
			double sum=0;
			for (int i = 0; i < array.length; i++) {
	            sum +=  array[i];
	            mean = sum/array.length;
			}
			return mean;
		}
	 
	    // To calculate the median, you need to sort the array first
		// if array.length is odd, median in the middle number
		// if array.length is even, median is half of the sum of the middle numbers
	 
	    public static double calculateMedian(String setOfIntegers) {
	    	int array[]=StringToArray(setOfIntegers);
	    	double median=0.0;
	    	Arrays.sort(array);
	    	if (array.length % 2 == 0) {
	    		median = (double)(array[array.length/2] + array[array.length/2 - 1])/2;
	    	}
	    	else {
	    		median = (double)array[array.length/2];
	    	}
	    	return median;
	    }
	    
	    public static int calculateMode(String setOfIntegers) {
	    	int array[]=StringToArray(setOfIntegers);
		      int maxValue = 0, maxCount = 0, i, j;
		      for (i = 0; i < array.length; ++i) {
		         int count = 0;
		         for (j = 0; j < array.length; ++j) {
		            if (array[j] == array[i])
		            count++;
		         }

		         if (count > maxCount) {
		            maxCount = count;
		            maxValue = array[i];
		         }
		      }
		      return maxValue;
		}

	    public static double calculateStandardDeviation(String setOfIntegers){
	    	int array[]=StringToArray(setOfIntegers);
	    	double deviation=0;
	    	double mean=calculateMean(setOfIntegers);
	    	double sum=0;
	    	
	    	for(int i=0;i<array.length;i++) {
	    		sum+=Math.pow(array[i]-mean,2);
	    	}
	    	deviation = Math.sqrt(sum/(array.length-1));
	    	
	    	
	    	return deviation;
	    }
	
}
