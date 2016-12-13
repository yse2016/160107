public class aloha {
  public static void main( String[] args){
	String mainMsg;
	String subMsg;
	while( true ) {
		System.out.println("come on");
		mainMsg = new java.util.Scanner(System.in).nextLine();
		if ( mainMsg.equals("exit") ) {
			break;
		} else {
  			System.out.println(mainMsg);
  		}
  	}
  }
}
