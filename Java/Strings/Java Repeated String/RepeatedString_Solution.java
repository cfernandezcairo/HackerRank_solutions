import java.io.*;

/**
 * @author Kanahaiya Gupta
 *
 */
public class ReapetedString_Solution {

	/*
	 * Complete the 'repeatedString' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts following parameters:
	 *  1. STRING s
	 *  2. LONG_INTEGER n
	 */

	private static int useRecursion(String someString, char searchedChar, int index) {
		if (index >= someString.length()) {
			return 0;
		}

		int count = someString.charAt(index) == searchedChar ? 1 : 0;
		return count + useRecursion(
				someString, searchedChar, index + 1);
	}

	public static long occurrences(String s) {
		return useRecursion(s, 'a', 0);
	}

	public static long occurrences1(String s) {
		return s.chars().filter(ch -> ch == 'a').count();
	}

	public static long repeatedString(String s, long n) {
		// Write your code here
		return (occurrences(s) * (n/s.length())) + occurrences(s.substring(0, Long.valueOf(n).intValue() % s.length()));

	}

	// Complete the repeatedString function below.
	static long repeatedString1(String s, long n) {

		if(!s.contains("a")) return 0;

		if(s.length() == 1) return n;

		long count = 0;

		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == 'a') count++;
		}

		long repetition = n/s.length();
		count = count*repetition;

		long rem = n % s.length();

		for(int i=0; i<rem; i++){
			if(s.charAt(i)=='a') count++;
		}

		return count;

	}

	static long repeatedString2(String s, long n) {

		int sLenght = s.length();
		long cocientNS = 0, restNS = 0;
		cocientNS = n / sLenght;
		restNS = n % sLenght;

		long partialLebght = (restNS == 0) ? 0 : restNS;
		long aCount = cocientNS * getCharacterCount(s, sLenght) + getCharacterCount(s, partialLebght);

		return aCount;
	}

	public static long getCharacterCount(String s, long sLenght) {
		long aCount = 0;
		for(int i=0; i<sLenght; i++){
			if(s.charAt(i)=='a') aCount++;
		}

		return aCount;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	  //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		long n = Long.parseLong(bufferedReader.readLine().trim());

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
