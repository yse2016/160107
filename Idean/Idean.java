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
	JTextArea area1;
	JTextArea area2;
	JScrollPane scrollPane;
	String fielddata;
	String textdata;
	JLabel label;
	JLabel label2;
	String[] data = new String[ 5 ];
	// String data[] = { a, b, c, d, e };

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

		con.add( scrollPane );

		label = new JLabel();
		label.setText( "LBL" );

		label2 = new JLabel();
		label2.setText( "OK" );

		panel.add( label );
		panel.add( label2 );

		frame.setVisible( true );

		btn1.addActionListener( this );
		btn2.addActionListener( this );

		btn1.setActionCommand( "表示" );
		btn2.setActionCommand( "保存" );

	}

	public void actionPerformed( ActionEvent ae ) { 
		String cmd = ae.getActionCommand();

		if( cmd.equals( "表示" ) ) {
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory( new File( "." ) );
			int ret = fc.showOpenDialog( frame );
			if( ret == JFileChooser.APPROVE_OPTION ) {
				File file = fc.getSelectedFile();
				fielddata = file.getAbsolutePath();
				field.setText( fielddata );
			}

			try {
				File f = new File( fielddata );
				FileReader fr = new FileReader( f );
				BufferedReader br = new BufferedReader( fr );

				String line;
				while( ( line = br.readLine() ) !=null ) {
					area1.append( line );
					area1.append( "\n" );
				}
				br.close();
			} catch( IOException e ) {
				System.out.println( "Error" );
			}
		} else if( cmd.equals( "保存" ) ) {
			fielddata = field.getText();
			textdata = area1.getText();
			try {
				File f2 = new File( fielddata );
				FileWriter fw = new FileWriter( f2 , true );
				BufferedWriter bw = new BufferedWriter( fw );
				PrintWriter pw = new PrintWriter( bw );

				pw.println( textdata );
				pw.close();

			} catch( IOException e ) {
				System.out.println( "ERROR" );
			}
		}
	}
}