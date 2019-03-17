package test_code;

import static org.junit.jupiter.api.Assertions.* ;
import org.junit.jupiter.api.Test ;
import java.io.* ;

import grade_system.GradeSystems ;
import grade_system.UI;


class ShowWelcomeMsgTest {
	
	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名

	@Test
	void testShowWelcomeMsg1() {
		
		String input = "962001044\n" + "E\n";
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		try {
			// next two lines set ID to 962001044, and name to 凌宗廷
			UI aUI = new UI();
			GradeSystems aGradeSystem = new GradeSystems("./data/testInput.txt");
			aUI.promptID() ;
			
			String expectedOutput = "Welcome 凌宗廷\n" ;
			ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
			System.setOut( new PrintStream( outContent ) ) ;
			
			aUI.showWelcomeMsg("962001044") ;
			assertEquals( expectedOutput, outContent.toString() ) ;
		}
		catch( Exception ex ) { }
	}

}
