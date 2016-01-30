package RandomGenerate.com.random;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class Randoms {
	public static String RandomString() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWYXYZ";
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		int length = random.nextInt(5) + 5;
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(26);
			buf.append(str.charAt(num));
		}
		return buf.toString();
	}

	public static String RandomString(int length) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWYXYZ";
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(26);
			buf.append(str.charAt(num));
		}
		return buf.toString();
	}
	
	public static LinkedList<Integer> RandomIds(int length) {
		Random random = new Random();
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < length; i++) {
			set.add(random.nextInt(100000)+1000);
		}
		return new LinkedList<>(set);
	}

	public static String randomPhoneNumber() {
		Random rand = new Random();
		int num1, num2, num3;

		num1 = rand.nextInt(900) + 100;
		num2 = rand.nextInt(643) + 100;
		num3 = rand.nextInt(9000) + 1000;

		return num1 + "-" + num2 + "-" + num3;
	}
	
	public static String randomLocation() {
		double minLat = -90.00;
	    double maxLat = 90.00;      
	    double latitude = minLat + (double)(Math.random() * ((maxLat - minLat) + 1));
	    double minLon = 0.00;
	    double maxLon = 180.00;     
	    double longitude = minLon + (double)(Math.random() * ((maxLon - minLon) + 1));
		return String.valueOf(latitude)+" "+String.valueOf(longitude);	
	}
}
