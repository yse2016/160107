import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrameMan {
	public static void main (String[] args ) {
		FrameMan fm = new FrameMan();
	}
}

	// ↓"ActionListener"を実装(implements)する
	class FrameMan implements ActionListener {
		// field
		JFrame frame;
		JLabel label;
		JButton button;

		// method
		public FrameMan() {
			System.out.println( "ALOHAAAAAAAAaaaa" );

			// パーツを作る
			frame = new JFrame( "FrameMan!" );
			label = new JLabel( "ALOHA" );
			button = new JButton( "ClickMe" );

			button.addActionListener( this );

			frame.setSize( 500, 500 );
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			frame.setLayout( new FlowLayout() );

			// ラベルとボタンをはりつける
			Container ctnr = frame.getContentPane();
			ctnr.add( label );
			ctnr.add( button );		

			// windowを表示する
			frame.setVisible( true );

			// windowを真ん中に表示
			frame.setLocationRelativeTo( null ); 

		}

		public void actionPerformed( ActionEvent e ) {
			label.setText("ALOHA");
		}
	}