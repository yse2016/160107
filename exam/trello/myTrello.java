import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;


public class myTrello {
	public static void main ( String[] args ) {
		TrelloMan trello = new TrelloMan();
	}
}

class TrelloMan implements ActionListener {
	JFrame frame;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton sbtn1;
	JButton sbtn2;
	JButton sbtn3;
	JButton sbtn4;
	JButton open1;
	JButton open2;
	JButton open3;
	JButton open4;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	JPanel panel9;
	JPanel panel10;
	JPanel panel11;
	JPanel panel12;
	JTextArea area1;
	JTextArea area2;
	JTextArea area3;
	JTextArea area4;
	JScrollPane scrollPane;
	String fielddate;
	String textdata;
	String fielddate2;
	String textdata2;
	String fielddate3;
	String textdata3;
	String fielddate4;
	String textdata4;
	String fielddate5;
	String textdata5;
	String fielddate6;
	String textdata6;
	String fielddate7;
	String textdata7;
	String fielddate8;
	String textdata8;	



	public TrelloMan() {
		frame = new JFrame( "trellon" );

		frame.setSize( 650, 500 );
		frame.setLocationRelativeTo( null );
		//frame.setBackground( Color.BLACK );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		panel1 = new JPanel();
		//panel1.setBackground( new Color( 0, 255, 255) );
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();
		panel12 = new JPanel();

		btn1 = new JButton( "    Someday    " );
		//btn1.setBackground( new Color( 0,255,0 ) );
		btn2 = new JButton( "      ToDo      " );
		btn3 = new JButton( "     Doing     " );
		btn4 = new JButton( "      Done      " );
		sbtn1 = new JButton( "save1" );
		//sbtn1.setBackground( Color.lightGray );
		sbtn2 = new JButton( "save2" );
		sbtn3 = new JButton( "save3" );
		sbtn4 = new JButton( "save4" );
		open1 = new JButton( "open1" );
		open2 = new JButton( "open2" );
		open3 = new JButton( "open3" );
		open4 = new JButton( "open4" );

		area1 = new JTextArea( 24, 12 );
		area2 = new JTextArea( 24, 12 );
		area3 = new JTextArea( 24, 12 );
		area4 = new JTextArea( 24, 12 );

		area1.setEnabled( false );
		area2.setEnabled( false );
		area3.setEnabled( false );
		area4.setEnabled( false );

		//scrollPane = new JScrollPane( area1 );
		//scrollPane = new JScrollPane( area2 );
		//scrollPane = new JScrollPane( area3 );
		//scrollPane = new JScrollPane( area4 );

		Container con = frame.getContentPane();
		con.setLayout( new GridLayout( 1, 4 ) );
		con.add( panel1 );
		con.add( panel2 );
		con.add( panel3 );
		con.add( panel4 );

		
		panel1.add( btn1 );
		panel2.add( btn2 );
		panel3.add( btn3 );
		panel4.add( btn4 );
		
		
		area1.setLineWrap( true );
		area2.setLineWrap( true );
		area3.setLineWrap( true );
		area4.setLineWrap( true );

		//con.add( scrollPane );

		panel1.add( area1 );
		panel2.add( area2 );
		panel3.add( area3 );
		panel4.add( area4 );

		panel1.add( open1 );
		panel2.add( open2 );
		panel3.add( open3 );
		panel4.add( open4 );

		panel1.add( sbtn1 );
		panel2.add( sbtn2 );
		panel3.add( sbtn3 );
		panel4.add( sbtn4 );

		

		frame.setVisible( true );

		btn1.addActionListener( this );
		btn2.addActionListener( this );
		btn3.addActionListener( this );
		btn4.addActionListener( this );

		sbtn1.addActionListener( this );
		sbtn2.addActionListener( this );
		sbtn3.addActionListener( this );
		sbtn4.addActionListener( this );

		open1.addActionListener( this );
		open2.addActionListener( this );
		open3.addActionListener( this );
		open4.addActionListener( this );

		btn1.setActionCommand( "    Someday    " );
		btn2.setActionCommand( "      ToDo      " );
		btn3.setActionCommand( "     Doing     " );
		btn4.setActionCommand( "      Done      " );

		sbtn1.setActionCommand( "save1" );
		sbtn2.setActionCommand( "save2" );
		sbtn3.setActionCommand( "save3" );
		sbtn4.setActionCommand( "save4" );

		open1.setActionCommand( "open1" );
		open2.setActionCommand( "open2" );
		open3.setActionCommand( "open3" );
		open4.setActionCommand( "open4" );
	}

	public void actionPerformed( ActionEvent ae ) {
		String cmd = ae.getActionCommand();

		if( cmd.equals( "    Someday    ") ) {
			area1.setEnabled( true );
		} else if( cmd.equals( "      ToDo      " ) ) {
			area2.setEnabled( true );
		} else if( cmd.equals( "     Doing     " ) ) {
			area3.setEnabled( true );
		} else if( cmd.equals( "      Done      " ) ) {
			area4.setEnabled( true );
		}
		// sbtn1 save
		else if( cmd.equals( "save1" ) ) {
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory( new File( "." ) );
			int ret = fc.showSaveDialog( frame );
			if( ret == JFileChooser.APPROVE_OPTION ) {
				File file = fc.getSelectedFile();
				fielddate = file.getAbsolutePath();	
				textdata = area1.getText();
			}

			try {
				File f = new File( fielddate );
				FileWriter fw = new FileWriter( f );
				BufferedWriter bw = new BufferedWriter( fw );
				PrintWriter pw = new PrintWriter( bw );
				pw.println( textdata );
				pw.close();
			} catch( IOException e ) {
				System.out.println( "error" );
			} 
		} 
		
		// sbtn2 save2
		else if( cmd.equals( "save2" ) ) {
			JFileChooser fc2 = new JFileChooser();
			fc2.setCurrentDirectory( new File( "." ) );
			int ret2 = fc2.showSaveDialog( frame );
			if( ret2 == JFileChooser.APPROVE_OPTION ) {
				File file2 = fc2.getSelectedFile();
				fielddate2 = file2.getAbsolutePath();	
				textdata2 = area2.getText();	
			}
			try {
				File f2 = new File( fielddate2 );
				FileWriter fw2 = new FileWriter( f2 );
				BufferedWriter bw2 = new BufferedWriter( fw2 );
				PrintWriter pw2 = new PrintWriter( bw2 );
				pw2.println( textdata2 );
				pw2.close();
			} catch( IOException e ) {
				System.out.println( "error" );
			}
		} 
		// sbtn3 save3
		else if( cmd.equals( "save3" ) ) {
			JFileChooser fc3 = new JFileChooser();
			fc3.setCurrentDirectory( new File( "." ) );
			int ret3 = fc3.showSaveDialog( frame );
			if( ret3 == JFileChooser.APPROVE_OPTION ) {
				File file3 = fc3.getSelectedFile();
				fielddate3 = file3.getAbsolutePath();	
				textdata3 = area3.getText();	
			}
			try {
				File f3 = new File( fielddate3 );
				FileWriter fw3 = new FileWriter( f3 );
				BufferedWriter bw3 = new BufferedWriter( fw3 );
				PrintWriter pw3 = new PrintWriter( bw3 );
				pw3.println( textdata3 );
				pw3.close();
			} catch( IOException e ) {
				System.out.println( "error" );
			}
		}
		// sbtn4 save4
		else if( cmd.equals( "save4" ) ) {
			JFileChooser fc4 = new JFileChooser();
			fc4.setCurrentDirectory( new File( "." ) );
			int ret4 = fc4.showSaveDialog( frame );
			if( ret4 == JFileChooser.APPROVE_OPTION ) {
				File file4 = fc4.getSelectedFile();
				fielddate4 = file4.getAbsolutePath();	
				textdata4 = area4.getText();	
			}
			try {
				File f4 = new File( fielddate4 );
				FileWriter fw4 = new FileWriter( f4 );
				BufferedWriter bw4 = new BufferedWriter( fw4 );
				PrintWriter pw4 = new PrintWriter( bw4 );
				pw4.println( textdata4 );
				pw4.close();
			} catch( IOException e ) {
				System.out.println( "error" );
			}
		}
		// open1 open
		else if( cmd.equals( "open1" ) ) {
			JFileChooser fc5 = new JFileChooser();
			fc5.setCurrentDirectory( new File( "." ) );
			int ret5 = fc5.showOpenDialog( frame );
			if( ret5 == JFileChooser.APPROVE_OPTION ) {
				File file5 = fc5.getSelectedFile();
				fielddate5 = file5.getAbsolutePath();
			}
			try {
				File f5 = new File( fielddate5 );
				FileReader fr5 = new FileReader( f5 );
				BufferedReader br5 = new BufferedReader( fr5 );
				String line;
				while( ( line = br5.readLine() ) !=null ){
					area1.append( line );
					area1.append( "\n" );
				}
				br5.close();
			} catch( IOException e ) {
				System.out.println("error");
			}
		}
		// open2 open
		else if( cmd.equals( "open2" ) ) {
			JFileChooser fc6 = new JFileChooser();
			fc6.setCurrentDirectory( new File( "." ) );
			int ret6 = fc6.showOpenDialog( frame );
			if( ret6 == JFileChooser.APPROVE_OPTION ) {
				File file6 = fc6.getSelectedFile();
				fielddate6 = file6.getAbsolutePath();
			}
			try {
				File f6 = new File( fielddate6 );
				FileReader fr6 = new FileReader( f6 );
				BufferedReader br6 = new BufferedReader( fr6 );
				String line;
				while( ( line = br6.readLine() ) !=null ){
					area2.append( line );
					area2.append( "\n" );
				}
				br6.close();
			} catch( IOException e ) {
				System.out.println("error");
			}
		}
		// open3 open
		else if( cmd.equals( "open3" ) ) {
			JFileChooser fc7 = new JFileChooser();
			fc7.setCurrentDirectory( new File( "." ) );
			int ret7 = fc7.showOpenDialog( frame );
			if( ret7 == JFileChooser.APPROVE_OPTION ) {
				File file7 = fc7.getSelectedFile();
				fielddate7 = file7.getAbsolutePath();
			}
			try {
				File f7 = new File( fielddate7 );
				FileReader fr7 = new FileReader( f7 );
				BufferedReader br7 = new BufferedReader( fr7 );
				String line;
				while( ( line = br7.readLine() ) !=null ){
					area3.append( line );
					area3.append( "\n" );
				}
				br7.close();
			} catch( IOException e ) {
				System.out.println("error");
			}
		}
		// open4 open
		else if( cmd.equals( "open4" ) ) {
			JFileChooser fc8 = new JFileChooser();
			fc8.setCurrentDirectory( new File( "." ) );
			int ret8 = fc8.showOpenDialog( frame );
			if( ret8 == JFileChooser.APPROVE_OPTION ) {
				File file8 = fc8.getSelectedFile();
				fielddate8 = file8.getAbsolutePath();
			}
			try {
				File f8 = new File( fielddate8 );
				FileReader fr8 = new FileReader( f8 );
				BufferedReader br8 = new BufferedReader( fr8 );
				String line;
				while( ( line = br8.readLine() ) !=null ){
					area4.append( line );
					area4.append( "\n" );
				}
				br8.close();
			} catch( IOException e ) {
				System.out.println("error");
			}
		}
	}
}

// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa