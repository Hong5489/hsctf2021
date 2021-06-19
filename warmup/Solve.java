import java.util.Scanner;

public class Solve {
  
	public static String cold(String t) {
		return t.substring(16) + t.substring(0, 16);
	}
	
	public static String cool(String t) {
		String s = "";
		for (int i = 0; i < t.length(); i++)
			if (i % 2 == 0)
				s += (char) (t.charAt(i) - 3 * (i / 2));
			else
				s += t.charAt(i);
		return s;
	}
		
	public static String warm(String t,int x,int y) {
		String a = t.substring(0, x + 1);
		String t1 = t.substring(x + 1);
		String b = t1.substring(0, y + 1);
		String c = t1.substring(y + 1);
		return c + b + a;
	}
	
	public static String hot(String t) {
		int[] adj = {-72, 7, -58, 2, -33, 1, -102, 65, 13, -64, 
				21, 14, -45, -11, -48, -7, -1, 3, 47, -65, 3, -18, 
				-73, 40, -27, -73, -13, 0, 0, -68, 10, 45, 13};
		String s = "";
		for (int i = 0; i < t.length(); i++)
			s += (char) (t.charAt(i) - adj[i]);
		return s;
	}

	public static void main(String[] args) {
		String match = "4n_3nd0th3rm1c_rxn_4b50rb5_3n3rgy";
		for (int i=0;i<=17 ;i++ ) {
			for (int j=0;j<=17 ;j++ ) {
				System.out.println(cold(cool(warm(hot(match),i,j))));
			}
		}
	}
  
}
