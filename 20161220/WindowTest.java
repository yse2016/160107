import java.awt.*;
import javax.swing.*;

public class WindowTest {
	public static void main( String[] args ) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("ALOHA");
		JButton button = new JButton("ClickMe!");

		// windowの設定
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
}