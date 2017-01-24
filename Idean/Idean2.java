import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Idean2 {
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
	JTextArea area1;
	JTextArea area2;
	JScrollPane scrollPane;
	String fielddata;
	String textdata;
	JLabel label;
	JLabel label2;
	String[] da = new String[ 10 ];
	//String da[] = { "表示", "保存" };
	int co = 0;

	int num = (int)( Math.random()*10 );

	public IdeaMan() {
		frame = new JFrame( "Idean" );
		
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

		area1 = new JTextArea( 10, 12 );
		scrollPane = new JScrollPane( area1 );

		label = new JLabel();
		label.setText( "" );

		label2 = new JLabel();
		label2.setText( "" );

		panel.add( label );
		panel.add( label2 );	

		con.add( scrollPane );

		frame.setVisible( true );

		btn1.addActionListener( this );
		btn2.addActionListener( this );

		btn1.setActionCommand( "表示" );
		btn2.setActionCommand( "保存" );

		try {
			File f = new File( "idea.txt" );
			FileReader fr = new FileReader( f );
			BufferedReader br = new BufferedReader( fr );

			String line;
			while( ( line = br.readLine() ) !=null ) {
				da[ co ] = line;
				co++;
			}
			br.close();
		} catch( IOException e ) {
			System.out.println( "error" );
		}

	}

	public void actionPerformed( ActionEvent ae ) { 
		String cmd = ae.getActionCommand();

		if( cmd.equals( "表示" ) ) {
			num = (int)( Math.random()*10 );
			area1.setText( da[ num ] );
			area1.append( "\n" );
			num = (int)( Math.random()*10 );
			area1.append( da[ num ] );	
		}  else if( cmd.equals( "保存" ) ) {
			textdata = area1.getText();
			try {
				File f2 = new File( "result.txt" );
				FileWriter fw = new FileWriter( f2, true );
				BufferedWriter bw = new BufferedWriter( fw );
				PrintWriter pw = new PrintWriter( bw );

				pw.println( textdata + "\n" );
				pw.close();

			} catch( IOException e ) {
				System.out.println( "ERROR" );
			}
		}
	}
}