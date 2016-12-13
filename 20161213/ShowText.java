import java.io.*;

public class ShowText {
	public static void main( String[] args ) {
		String data = null;
		try {
			FileReader fr = new FileReader( "date.txt" );
			BufferedReader in = new BufferedReader( fr );

			while( true ) {
				data = in.readLine();

				if ( data == null ) {
					break;
				}

				System.out.print( data );
			}	

			in.close();
		} catch ( IOException e ) {
			System.out.println( "error" );
		}
	}
}