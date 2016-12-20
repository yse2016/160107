import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrameMan2 {
	public static void main (String[] args ) {
		FrameMan fm = new FrameMan();
	}
}

	// ↓"ActionListener"を実装(implements)する
	class FrameMan implements ActionListener {
		// field
		JFrame frame;
		JPanel panel1;
		JPanel panel2;
		JLabel label;
		JButton button;
		JTextField  textfield;

		// method
		public FrameMan() {
			System.out.println( "ALOHAAAAAAAAaaaa" );

			// パーツを作る
			frame = new JFrame( "FrameMan!" );
			panel1 = new JPanel();
			panel2 = new JPanel();
			label = new JLabel( "ALOHA" );
			button = new JButton( "ClickMe" );
			textfield = new JTextField( 15 );

			button.addActionListener( this );

			frame.setSize( 500, 400 );
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			frame.setLayout( new BorderLayout() );

			// ラベルとボタンをはりつける
			panel1.add( textfield );
			panel1.add( button );
			panel2.add( label );
			frame.add( panel1, BorderLayout.NORTH );
			frame.add( panel2, BorderLayout.CENTER );

			// windowを表示する
			frame.setVisible( true );

			// windowを真ん中に表示
			frame.setLocationRelativeTo( null ); 

		}

		public void actionPerformed( ActionEvent e ) {
			String data = textfield.getText();
			label.setText( data );
		}
	}