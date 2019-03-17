package grade_system;



public class Main {
	public static void main(String[] args) {
		
		try {
			new UI();
		}
		catch( IllegalArgumentException ex ){
			System.out.println(ex) ;
			System.exit(1);
		}
		catch( Exception ex ){
			System.out.println( ex.getMessage() );
		}	
	}
}
