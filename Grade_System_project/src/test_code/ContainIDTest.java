package test_code ;

import static org.junit.jupiter.api.Assertions.* ; 
import org.junit.jupiter.api.BeforeEach ;
import org.junit.jupiter.api.Test ;
import grade_system.GradeSystems ;


class ContainIDTest {
	
	GradeSystems aGradeSystem ;

	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名
	
	@BeforeEach
	public void setUp() {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}

	@Test
	void testContainID1() {
		assertEquals( true, aGradeSystem.containID( "962001051" ) ) ;
	}
	
	@Test 
	void testContainID2() {
		
		assertEquals( false, aGradeSystem.containID( "962091051" ) ) ;
	}
	
	@Test 
	void testContainID3() {
		
		assertEquals( false, aGradeSystem.containID( "" ) ) ;
	}
}
