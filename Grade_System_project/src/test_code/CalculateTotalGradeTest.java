package test_code;

import static org.junit.jupiter.api.Assertions.* ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test ;
import grade_system.Grades ;

class CalculateTotalGradeTest {

	Grades aGrade;

	@BeforeEach
	public void setUp() throws Exception {
		aGrade = new Grades();
		
		aGrade.lab1 = 81;
		aGrade.lab2 = 98;
		aGrade.lab3 = 84;
		aGrade.midtermExam = 90;
		aGrade.finalExam = 93;
	}
	
	@Test 
	public void testCalculateTotalGrade1() {
		float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	
		assertEquals( 91, aGrade.calculateTotalGrade(weights));
	}
	
	@Test
	public void testCalculateTotalGrade2() {
		float[] weights = {0.2f, 0.2f, 0.2f, 0.2f, 0.2f};
		
		assertEquals( 89, aGrade.calculateTotalGrade(weights) );
		
	}
	
}
