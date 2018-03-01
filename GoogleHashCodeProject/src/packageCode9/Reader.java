package packageCode9;

import java.io.*;
import java.util.Scanner;

class Reader {

	public static void read(String fileName) {
		File source = new File(fileName);
		try {
			Scanner sc = new Scanner(source);
			Global.rows = sc.nextInt();
			Global.columns = sc.nextInt();
			Global.vehicles = sc.nextInt();
			Global.rides = sc.nextInt();
			Global.bonus = sc.nextInt();
			Global.steps = sc.nextInt();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find or open file " + fileName + " due to: " + e);
		}
	}
}
