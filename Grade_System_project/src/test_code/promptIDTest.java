package test_code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grade_system.GradeSystems;
import grade_system.UI;

class promptIDTest {

	GradeSystems aGradeSystem ;
	UI aUI;
	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名
	
	@BeforeEach
	public void setUp() throws Exception {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}
	
	@Test
	void testPromptID1() {
			
		String input = "Q\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
			
		try {
			aUI = new UI();
			assertEquals( false ,  aUI.promptID() ) ;
		}
			catch( Exception ex ) {}
		}
		
	@Test
	void testPromptID2() {
			
		String input = "123456789\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
			
		try {
			aUI = new UI();
			assertEquals( false ,  aUI.promptID() ) ;
		}
			catch( Exception ex ) { }
		}
		
	@Test
	void testPromptID3() {
			
		String input = "962001044\n" ;
		ByteArrayInputStream inContent = new ByteArrayInputStream( input.getBytes() ) ;
		System.setIn( inContent ) ;
			
		try {
			aUI = new UI();
			assertEquals( true ,  aUI.promptID() ) ;
		}
			catch( Exception ex ) { }
	}
		
}
