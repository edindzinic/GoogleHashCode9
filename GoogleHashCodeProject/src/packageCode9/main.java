package packageCode9;
import java.io.*;

@SuppressWarnings("unused")
class main {

	public static void main(String[] args) {
		Reader.read("C:\\Users\\ECHO\\git\\GoogleHashCode9\\GoogleHashCodeProject\\src\\packageCode9\\a_example.in");
		
		Dispatch.setTimeLimit(Global.steps);
		Dispatch.setBonus(Global.bonus);
		Dispatch.startDispatching(3);
		
		for (Taxi t: Dispatch.taxis) {
			System.out.println(t.assignedRequest.size());
		}
	}
}
