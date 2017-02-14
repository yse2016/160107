import java.util.HashMap;

public class TestHashMap2 {
	public static void main( String[] args ) {
		// HashMapを作る
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put( "Yoshino", 42 );
		// HashMapを表示する
		int age = hm.get( "Yoshino" );
		System.out.println( "Yoshino: " + age );

		// args[0]を使って、単語を出力する。
		System.out.println( args[0] );

		// args[0]が、HashMapにあるか調べる
		String target = args[0];
		System.out.println( hm.containsKey( target ) );

		// 新しいデータならば登録する。
		if( hm.containsKey( target ) ) {
			System.out.println( "既に存在するので加算します" );
			age++;
			hm.put( target, age );
		} else {
			System.out.println( "存在しないので、登録します" );
			hm.put( target, 1 );
		}



		// HashMapを表示する
		int value = hm.get( target );
		System.out.println( "Yoshino: " + value );

		value = hm.get( target );
		System.out.println( target + ": " + 1 );

		// ↑登録されていなかったら、[1]とする。

		// ↑登録されていれば、[+1]とする。
	}
}