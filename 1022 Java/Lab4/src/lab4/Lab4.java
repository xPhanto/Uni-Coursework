package lab4;

public class Lab4 {
	public static int longestSeq (int[] array) {
		int longestYet = 1;
		int currentStreak = 1;
		
		if(array.length == 0) {
			return 0;
		}
		
		for(int i=1; i<array.length; i++) {
			if(array[i] - 1 == array[i-1]) {
				currentStreak += 1;
			}
			else {
				longestYet = Math.max(currentStreak, longestYet);
				currentStreak = 1;
			}
		}
		longestYet = Math.max(currentStreak, longestYet);
		return longestYet;
	}

	public static String countArray (int[] array) {
		
		String result = "";
		int count[] = new int [99];
		
		if(array.length == 0) {
			return "";
		}
		
		for(int i = 0; i < array.length; i++) {
			int num = array[i];
			
			if((array[i]%2 == 0) && (array[i] < 100) && (array[i] >= 2)) {
				count[num] += 1;
			}
		}
		for(int k = 0; k < count.length; k++) {
			int x = count[k];
			if(x>0) {
				result += k + ": " + count[k] + "\n";
					}
		}
			
		if(result.endsWith("\n")) {
			result = result.substring(0, result.length()-1);
		}
		return result;
		
	}
	
	public static boolean validString (String str1, String str2) {
		if(str1.length() < str2.length()) {
			return false;
		}
		int i= 0;
		int j = 0;
		
		while(i < str1.length() && (j < str2.length())) {
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			i++;
		}
		boolean bool = j == str2.length();
		return bool;
		
	}
	
	public static String arrayResult(int[][] array) {
		String result;
		int sum = 0;
		int prod = 0;
		
		if(array.length == 0) {
			return "";
		}
		if(array.length == 1) {
			if(array[0].length == 0) {
				return "";
			}
		}
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if((i + j) %2 == 0) {
					sum += array[i][j];
				} else {
					if(prod == 0){
						prod += 1;
					}
					prod = prod*array[i][j];
				}
			}
		}
		result = String.format("Sum:%d, Product:%d", sum, prod);
		return result;
	}
	
	public static boolean magicSquare(int[][] array) {
		int len = array.length;
		int mSum = len * (len * len + 1) / 2;
		
		int dia1 = 0;
		int dia2 = 0;
		
		for(int i = 0; i < len; i++){
			int rowSum = 0;
			int colSum = 0;
			for(int j= 0; j < len; j++) {
				rowSum += array[i][j];
				colSum += array[j][i];
			}
			if(colSum != mSum || rowSum!= mSum) {
				return false;
			}
		}
		for(int i = 0; i < len; i++){
			dia1 += array[i][i];
			dia2 += array[i][len-i-1];
			}
		if(dia1 != mSum || dia2 != mSum) {
			return false;
		}
		return true;
	}
	
}
