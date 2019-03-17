package grade_system;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GradeSystems {
	
	Scanner scanner = new Scanner(System.in);
	
	float weights[] = { 0.1f, 0.1f, 0.1f, 0.3f, 0.4f };
	String subject[] = { "lab1:", "lab2:", "lab3:", "midterm exam:", "final exam:" };
	public int n = 5;
	
	Map< String, Grades > database = new TreeMap<>() ;
	
	public GradeSystems( String filename ){
		File file = new File( filename ) ;
		
		try( Scanner fin = new Scanner(file) ) {
			while( fin.hasNext() ) {
				Grades aGrade = new Grades();
				String ID = aGrade.id = fin.next();
				aGrade.name = fin.next();
				aGrade.lab1 = fin.nextInt();
				aGrade.lab2 = fin.nextInt();
				aGrade.lab3 = fin.nextInt();
				aGrade.midtermExam = fin.nextInt();
				aGrade.finalExam = fin.nextInt();
				aGrade.totalGrade = aGrade.calculateTotalGrade(weights);
				database.put( ID, aGrade ) ;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public final float[] getWeights() { return weights ; }
	
	public final Map< String, Grades > getDatabase() { return database ; }
	public boolean containID( String ID ){ 
		return database.containsKey(ID);
	}
	
	public void showGrade( String ID ) {
		Grades student = database.get(ID) ;
		
		System.out.printf( "%s成績:\n", student.getName() ) ;
		System.out.printf( "lab1:\t\t%d\n", student.getLab1() ) ;
		System.out.printf( "lab2:\t\t%d\n", student.getLab2() ) ;
		System.out.printf( "lab3:\t\t%d\n", student.getLab3() ) ;
		System.out.printf( "midterm exam:\t%d\n", student.getMidtermExam() ) ;
		System.out.printf( "final exam:\t%d\n", student.getFinalExam() ) ;
		System.out.printf( "total grade:\t%d\n", student.getTotalGrade() ) ;
	}
	
	public void showRank( String ID ) {
		int rank = 1 ;
		Grades index = database.get(ID) ;
		
		Set< Map.Entry< String, Grades > > entrySet = database.entrySet() ;
		for( Map.Entry< String, Grades> entry: entrySet ) {
			if( entry.getValue().getTotalGrade() > index.getTotalGrade() )
				++rank ;
		}
		
		System.out.printf( "%s排名第%d\n", index.getName(), rank ) ;
	}
	
	private void printWeights( float[] printweights ) {
		for(int i=0;i<n;i++)
			System.out.println(subject[i]+(int)(printweights[i]*100)+"%");
	}
	
	private void setNewWeights( float[] newWeights ) {
		for( int i=0 ; i<n ; ++i ) 
			this.weights[i] = newWeights[i] ;
		
		Set< Map.Entry< String, Grades > > entrySet = database.entrySet() ;
		for( Map.Entry< String, Grades> entry: entrySet )
			entry.getValue().totalGrade = entry.getValue().calculateTotalGrade(this.weights);
	}
	
	
	public void updateWeights() {
		oldWeights();
		inputWeights();
	}
	
	public void oldWeights() {
		System.out.println( "舊配分" ) ;
		printWeights( weights ) ;
	}
	
	public void inputWeights() {
		float newWeights[] = new float[n] ;
		System.out.println( "輸入新配分" ) ;
		
		for(int i=0;i<n;i++) {
			System.out.print(subject[i] + "\t" ) ;
			newWeights[i] = ((float)(scanner.nextInt()))/100;
		}
		
		System.out.println( "請確認新配分" ) ;
		printWeights( newWeights ) ;
		
		System.out.print( "以上正確嗎? Y (Yes) 或 N (No) " ) ;
		String cmd = scanner.next();
		if( cmd.equals("Y") ) {
			setNewWeights( newWeights ) ;
		}
	}

}
