package test_code ;

import static org.junit.jupiter.api.Assertions.* ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.* ;

import grade_system.GradeSystems ;

class UpdateWeightsTest {
	
	GradeSystems aGradeSystem ;

	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名
	
	
	@Test
	void testUpdateWeights1() {
		
		String input = "20\n" + "20\n" + "20\n" + "20\n" + "20\n" + "Y\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		try {
			aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
			aGradeSystem.updateWeights() ;
		}
		catch( Exception ex ) { System.out.println( ex ) ; }
		
		int []a = { 20, 20, 20, 20, 20 } ;
		float[]b = aGradeSystem.getWeights() ;
		
		for( int i=0 ; i<a.length ; ++i )
			assertEquals( a[i], (int)(b[i]*100) ) ;
	}
	
	@Test
	void testUpdateWeights2() {
		
		String input = "20\n" + "20\n" + "20\n" + "20\n" + "20\n" + "N\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		try {
			aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
			aGradeSystem.updateWeights() ;
		}
		catch( Exception ex ) { System.out.println( ex ) ; };
		
		int []a = { 10, 10, 10, 30, 40 } ;
		float[]b = aGradeSystem.getWeights() ;
		
		for( int i=0 ; i<a.length ; ++i )
			assertEquals( a[i], (int)(b[i]*100) ) ;
	}
	

	@Test
	void testUpdateWeights3() {
		
		String input = "20\n" + "20\n" + "20\n" + "20\n" + "20\n" + "Y\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		try {
			aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
			aGradeSystem.updateWeights() ;
		}
		catch( Exception ex ) { System.out.println( ex ) ; }
		
		String expectedOutput = "李威廷成績:\n" + "lab1:\t\t81\n" + "lab2:\t\t98\n" + "lab3:\t\t84\n" + 
				"midterm exam:\t90\n" + "final exam:\t93\n" + "total grade:\t89\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showGrade( "962001051" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
	
}
