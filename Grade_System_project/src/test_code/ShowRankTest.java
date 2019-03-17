package test_code ;

import static org.junit.jupiter.api.Assertions.* ;
import org.junit.jupiter.api.BeforeEach ;
import org.junit.jupiter.api.Test ;
import grade_system.GradeSystems ;
import java.io.* ;

class ShowRankTest {
	
	GradeSystems aGradeSystem ;

	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名
	
	@BeforeEach 
	public void setUp() throws Exception {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}

	@Test // test 李威廷排名第1 print correctly
	void testShowRank1() {
		
		String expectedOutput = "李威廷排名第1\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showRank( "962001051" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
	
	@Test // test 凌宗廷排名第2 print correctly
	void testShowRank2() {
		
		String expectedOutput = "凌宗廷排名第2\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showRank( "962001044" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
	
}
