import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Idean {
	public static void main( String[] main ) {
		IdeaMan idea = new IdeaMan();
	}
}

class IdeaMan implements ActionListener {
	JFrame frame;
	JButton btn1;
	JButton btn2;
	JPanel panel;
	JTextField field;

	public IdeaMan() {
		frame = new JFrame();
		
		frame.setSize( 500, 500 );
		frame.setLocationRelativeTo( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		field = new JTextField( 20 );
		panel = new JPanel();
		panel.add( field );
		Container con = frame.getContentPane();
		con.setLayout( new GridLayout( 2, 1 ) );
		con.add( panel );

		btn1 = new JButton(	"表示" );
		btn2 = new JButton( "保存" );

		panel.add( btn1 );
		panel.add( btn2 );

		frame.setVisible( true );
	}

	public void actionPerformed(ActionEvent ae) { 

	}
}