import java.util.HashMap;

public class TestHashMap {
	public static void main ( String[] args ) {
		// HashMapを作る
		HashMap<String, String> hm = new HashMap<String, String>();

		HashMap<String, Integer> hm2 = new HashMap<String, Integer>();

		// HashMapにデータを入れる
		hm.put( "apple", "リンゴ" );

		// 入れたデータを表示する
		String data = hm.get( "apple" );
		System.out.println( data );

		// HashMap hm2 に、データを、入れる
		hm2.put( "Yoshino", 42 );
		hm2.put( "Yamaguchi", 43 );
		hm2.put( "Aoki", 52 );

		if( hm2.containsKey("Jennifer") ) {
			System.out.println( "Jenniferは登録済み" );
		} else {
			System.out.println( "Jenniferは登録されていない" );
			hm2.put( "Jennifer", 1 );
		}

		System.out.println( "Jennifer: " + hm2.get( "Jennifer" ) );

		int toshi = hm2.get("Aoki");
		System.out.println( "Aoki: " + toshi );

	}
}