import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextEditor {
	public static void main ( String[] args){
		TextEditorMan text = new TextEditorMan();
	} 
}

class TextEditorMan implements ActionListener {
	JFrame frame;
	JButton btnOpen;
	JButton btnSave;
	JPanel fieldPanel;
	JTextField field;
	JTextArea area;
	JTextArea area2;
	JScrollPane scrollPane;
	String fielddata;
	String textdata;

	public TextEditorMan() {
		frame = new JFrame( "Text Editor" );
		frame.setLocation( 	500, 250 );
		frame.setSize( 500, 500 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		field = new JTextField( 20 );
		fieldPanel = new JPanel();

		fieldPanel.add( field );
		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(2, 1));
		con.add( fieldPanel );

		btnOpen = new JButton( "開く" );
		btnSave = new JButton( "保存" );
		fieldPanel.add( btnOpen );
		fieldPanel.add( btnSave );

		area = new JTextArea( 10, 30 );
		scrollPane = new JScrollPane( area );

		con.add( scrollPane );

		frame.setVisible( true );

		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);

		btnSave.setActionCommand( "save" );
		btnOpen.setActionCommand( "open" );

	}

	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();

		if(cmd.equals("open")) {
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
				while( ( line = br.readLine() ) !=null ){
					area.append( line );
					area.append( "\n" );
				}

				br.close();

			} catch( IOException e ) {
				System.out.println("error");
			}
		} else if(cmd.equals("save")) {
			fielddata = field.getText();
			textdata = area.getText();
			try {
				File f2 = new File( fielddata );
				FileWriter fw = new FileWriter( f2 );
				BufferedWriter bw = new BufferedWriter( fw );
				PrintWriter pw = new PrintWriter( bw );

				pw.println( textdata );
				pw.close();

			} catch( IOException e ){
				System.out.println("ERROR");
			}
		}
	}
}

