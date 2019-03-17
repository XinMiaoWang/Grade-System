package test_code ;

import static org.junit.jupiter.api.Assertions.* ;
import org.junit.jupiter.api.Test ;
import java.io.* ;

import grade_system.GradeSystems;
import grade_system.UI;

class ShowFinishMsgTest {
	
	
	
	@Test
	void testShowFinishMsg1() {
				
		String input = "Q\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
		
		UI aUI = new UI() ;
		
		String expectedOutput = "µ²§ô¤F\r\n" ;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aUI.showFinishMsg() ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
}
