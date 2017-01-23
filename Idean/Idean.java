import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Idean {
	public static void main( String[] main ) {
		IdeaMan idea = new IdeaMan();
	}
}

class IdeaMan {
	JFrame frame;

	public IdeaMan() {
		frame = new JFrame();
		
		frame.setSize( 500, 500 );
		frame.setLocationRelativeTo( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		frame.setVisible( true );
	}
}