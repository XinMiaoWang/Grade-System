package test_code ;

import static org.junit.jupiter.api.Assertions.* ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test ;
import grade_system.Grades ;

class GradesTest {
	
	Grades aGrade;

	@BeforeEach
	public void setUp() throws Exception {
		aGrade = new Grades();
		
		aGrade.name = "§õ«Â§Ê";
		aGrade.lab1 = 81;
		aGrade.lab2 = 98;
		aGrade.lab3 = 84;
		aGrade.midtermExam = 90;
		aGrade.finalExam = 93;
	}
	

	@Test
	public void testGrades1() {
		assertEquals( "§õ«Â§Ê", aGrade.getName()) ;
	}
	
	@Test
	public void testGrades2() {
		assertEquals( 81, aGrade.getLab1()) ;
	}
	
	@Test
	public void testGrades3() {
		assertEquals( 98, aGrade.getLab2()) ;
	}
	
	@Test
	public void testGrades4() {
		assertEquals( 84, aGrade.getLab3()) ;
	}
	
	@Test
	public void testGrades5() {
		assertEquals( 90, aGrade.getMidtermExam()) ;
	}
	
	@Test
	public void testGrades6() {
		assertEquals( 93, aGrade.getFinalExam()) ;
	}
}
