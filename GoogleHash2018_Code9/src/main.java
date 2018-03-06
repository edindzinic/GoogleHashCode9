
import java.io.*;

@SuppressWarnings("unused")
class main {

	public static void main(String[] args) {
		Reader.read("/Users/edindzinic/IdeaProjects/GoogleHash2018_Code9/input/a_example.in");
		
		Dispatch.setTimeLimit(Global.steps);
		Dispatch.setBonus(Global.bonus);

//		System.out.println(Global.rows);
//		System.out.println(Global.columns);
//		System.out.println("Nr. of cars "+ Global.vehicles);
//		System.out.println("Nr. of requests " + Global.rides);
//		System.out.println("Bonus is: " + Dispatch.getBonus() );
//		System.out.println("Time limit is: " + Dispatch.getTimeLimit() );
//		System.out.println(Dispatch.taxis.length);
//		System.out.println(Dispatch.requests.size());
//		System.out.println(Dispatch.taxis[0]);
//		System.out.println(Dispatch.taxis[1]);
//		System.out.println(Dispatch.requests.get(0));
//		System.out.println(Dispatch.requests.get(1));
//		System.out.println(Dispatch.requests.get(2));

		Dispatch.startDispatching();
	}
}
