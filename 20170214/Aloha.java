import java.util.HashMap;

public class Aloha {
	public static void main( String[] args) {
 		String src = "Kyoko was a high school student. Jennifer, a student from Canada, was staying with Kyoko's family. Kyoko and Jennifer were going to have job experiences together at a bakeryfor a week. Theyweregoing to work as salespersons. Kyoko wasnʼt interestedin it, but Jennifer was because she wanted to have her own bakeryin the future";
		src = src.replace( ".","" );
		src = src.replace( ",","" );
		src = src.replace( "'s","" );
		src = src.replace( "ʼ", "" );

		// 単語に区切る( spirit() )
		String[] kekka = src.split( " " );

		System.out.println( src );
		// System.out.println( kekka[0] );
		// System.out.println( kekka[3] );
		// System.out.println( kekka[6] );

		// 単語数を調べる
		System.out.println( "単語数: " + kekka.length );

		// HashMapを作る
		HashMap<String, Integer> hm = new HashMap<String,Integer>();

		// 単語数
		String[] words = new String[ kekka.length ];
		int num = 0;

		for( int i = 0; i < kekka.length; i++ ) {
			// 単語を変数targetに入れる
			String target = kekka[i];
			System.out.println( target );

			// targetが登録済みか、確認&対応
			if ( hm.containsKey( target ) ) {
				System.out.println( target + "は登録済み,++" );
				int numVal = hm.get( target );
				numVal++;
				hm.put( target, numVal );
			} else {
				System.out.println( target + "は未登録なので登録する" );
				hm.put( target, 1 );
				words[num] = target;
				num++;
				System.out.println( "num: " + num );
			}
		}
		// 単語を表示する
		for (int i = 0; i < num; i++ ) {
			String word = words[i];
			int age = hm.get( word );
			System.out.println( word + ": " + age );
		}

	}
}