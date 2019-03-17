package test_code ;

import static org.junit.jupiter.api.Assertions.* ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test ;
import java.io.* ;

import grade_system.GradeSystems;
import grade_system.UI;

class PromptCommandTest {
	
	final String COMMAND_MESSAGE = "1)G ��ܦ��Z\n"
			 					 + "2)R ��ܱƦW\n"
			 					 + "3)W ��s�t��\n"
			 					 + "4)E ���}��� (exit)";
	
	GradeSystems aGradeSystem ;
	UI aUI;
	// 962001044 ��v�� 87 86 98 88 87 -> totalGrade = 88, �ĤG�W
	// 962001051 ���§� 81 98 84 90 93 -> totalGrade = 91, �Ĥ@�W
	
	@BeforeEach
	public void setUp() {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}
	
	@Test
	void testPromptCommand1() {
		
		String input = "E\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		String expectedOutput = COMMAND_MESSAGE ;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		try {
			
			assertEquals( false, aUI.promptCommand() ) ;
			assertEquals( expectedOutput, outContent.toString() ) ;
		}
		catch( Exception ex ) {}
	}
	
	@Test
	void testPromptCommand2() {
		
		String input = "962001044\n" + "G\n" + "E\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		try {
	
			aUI.promptID() ;
			assertEquals( true,  aUI.promptCommand() ) ;
		}
		catch( Exception ex ) {}
	}
	
	@Test
	void testPromptCommand3() {
		
		String input = "962001044\n" + "R\n" + "E\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		try {
			
			aUI.promptID() ;
			assertEquals( true,  aUI.promptCommand() ) ;
		}
		catch( Exception ex ) {}
	}
	
	@Test
	void testPromptCommand4() {
		
		String input = "962001051\n" + "W\n" +
				"20\n" + "20\n" + "20\n" + "20\n" + "20\n" +
				"Y\n" + "G\n" + "E\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		try {
			
			aUI.promptID() ;
			
			assertEquals( true, aUI.promptCommand() );
			assertEquals( true,  aUI.promptCommand() );
			assertEquals( false,  aUI.promptCommand() );
		}
		catch( Exception ex ) {}
	}

}
