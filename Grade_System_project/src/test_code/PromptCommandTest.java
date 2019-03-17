package test_code ;

import static org.junit.jupiter.api.Assertions.* ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test ;
import java.io.* ;

import grade_system.GradeSystems;
import grade_system.UI;

class PromptCommandTest {
	
	final String COMMAND_MESSAGE = "1)G 顯示成績\n"
			 					 + "2)R 顯示排名\n"
			 					 + "3)W 更新配分\n"
			 					 + "4)E 離開選單 (exit)";
	
	GradeSystems aGradeSystem ;
	UI aUI;
	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名
	
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
