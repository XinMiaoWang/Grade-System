package test_code ;

import static org.junit.jupiter.api.Assertions.* ;
import org.junit.jupiter.api.BeforeEach ;
import org.junit.jupiter.api.Test ;
import grade_system.GradeSystems ;
import java.io.* ;

class ShowRankTest {
	
	GradeSystems aGradeSystem ;

	// 962001044 ��v�� 87 86 98 88 87 -> totalGrade = 88, �ĤG�W
	// 962001051 ���§� 81 98 84 90 93 -> totalGrade = 91, �Ĥ@�W
	
	@BeforeEach 
	public void setUp() throws Exception {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}

	@Test // test ���§ʱƦW��1 print correctly
	void testShowRank1() {
		
		String expectedOutput = "���§ʱƦW��1\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showRank( "962001051" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
	
	@Test // test ��v�ʱƦW��2 print correctly
	void testShowRank2() {
		
		String expectedOutput = "��v�ʱƦW��2\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showRank( "962001044" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
	
}
