package lab3;

public class Lab3 {

	public static String printStars(int n) {
		String result = "";
		for(int counter = 0; counter < n; counter++) {
			int dashes = 0;
			if(dashes < counter) {
				result += "\n";
				while(dashes < counter) {
					result += "-";
					dashes += 1;
				}
			}
			int stars = n - counter;
			while(stars > 0) {
				result += "*";
				stars -= 1;
			}

		}
		return result;
	}
	
	public static String expand (int num, int d) {
			if(num < 0 || d < 0)
				return "Invalid";
			int zeros = 1;
			int digit;
			String expanded = "";
			String plus = " + ";
			expanded += num%10;
			for (int i = 1; i < d; i++) {
		        num = num/10;
		        digit = num%10;
		        expanded = digit + "*" + 10*zeros + plus + expanded;
		        zeros = zeros*10;
			}
			
			    
			return expanded;
	}
	
	public static String getSeqStat(int ft, int d, int n) {
		String result = "{";
		String sequence;
		
		for(int i = 0; i < n; i++) {
			String term = "[";
			sequence = "<" + ft;
			int sum = ft;
			int prod = ft;
			int oldTerm = ft;
			
			for(int j = 0; j < i; j++) {
				int newTerm = oldTerm += d;
				sequence += ", " + newTerm;
				sum = sum + newTerm;
				prod = prod*newTerm;
				oldTerm = newTerm;
				} 
			sequence += ">";
			term += sequence;
			term += ": " + sum + ", " + prod + "]";
			result += term;
			if(i != n-1) {
				result += "; ";
			}
		}
		
		return result + "}";
	}
	
	public static String seqInterleaving(int ft1, int d1, int n1, int ft2, int d2, int n2) {
		String result = "<";
		/* Commented out, but this was my original thought process.
		 * make the two sequences, then run through them, but I wasn't sure
		 * if we could use arrays and I was struggling to find a way without arrays
		 * until I remembered something from 1015, as we did a similar example
		 * with going back and forth between two lists, putting them into order
		 * by magnitude, then adding the rest of a list if they were not equal lengths.
		 
		String sequence1 = "";
		String sequence2 = "";
		int oldTerm1 = ft1;
		int oldTerm2 = ft2;
		
		for(int i = 0; i < n1; i++) {
			int newTerm1 = oldTerm1 += d1;
			sequence1 += ", " + newTerm1;
			oldTerm1 = newTerm1;
		}
		for(int j = 0; j < n2; j++) {
			int newTerm2 = oldTerm2 += d2;
			sequence2 += ", " + newTerm2;
			oldTerm2 = newTerm2;
		}
		*/
		int i = 0, j = 0;
		while (i < n1 && j < n2) {
			if((i == n1-1) && (j == n2-1)){
				result += (ft1 + d1*i + ", ");
				result += (ft2 + d2*j);
			}else {
				result += (ft1 + d1*i + ", ");
				result += (ft2 + d2*j + ", ");
			}
			i++;
			j++;
		}
		while (i < n1) {
			if(i != n1-1){
				result += (ft1 + d1*i + ", ");
			} else result += (ft1 + d1*i);
			i+= 1;
		}
		while (j < n2) {
			if(j != n2-1){
				result += (ft2 + d2*j + ", ");
			} else result += (ft2 + d2*j);
			j+= 1;
		}
		return result + ">";
	}		
}