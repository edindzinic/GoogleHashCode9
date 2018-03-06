

import java.io.*;
import java.util.Scanner;

class Reader {

	private static Scanner sc;

	public static void read(String fileName) {
		File source = new File(fileName);
		try {
			sc = new Scanner(source);
			Global.rows = sc.nextInt();
			Global.columns = sc.nextInt();
			Global.vehicles = sc.nextInt();
			Dispatch.addTaxis(Global.vehicles);
			Global.rides = sc.nextInt();
			Global.bonus = sc.nextInt();
			Dispatch.setBonus(Global.bonus);
			Global.steps = sc.nextInt();
			Dispatch.setTimeLimit(Global.steps);

			for (int i = 0; i < Global.rides; i++) {
				int tempStartX = sc.nextInt();
				int tempStartY = sc.nextInt();
				int tempEndX = sc.nextInt();
				int tempEndY = sc.nextInt();
				int tempSTime = sc.nextInt();
				int tempETime = sc.nextInt();

				Request r = new Request(i, tempStartX, tempStartY, tempEndX, tempEndY, tempSTime, tempETime);
				Dispatch.addRequest(r);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find or open file " + fileName + " due to: " + e);
		}
	}
}
