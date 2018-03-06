import java.io.*;

class Writer {
	public static void write(int[] vehicle) {
		try{
			  FileWriter fstream = new FileWriter("log.txt",true);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write("x");
			  out.close();
		  }catch (Exception e){
			 System.err.println("Error while writing to file: " +
		          e.getMessage());
		  }
	}
}
