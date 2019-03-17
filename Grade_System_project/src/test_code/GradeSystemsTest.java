package test_code ;

import static org.junit.jupiter.api.Assertions.* ;
import org.junit.jupiter.api.BeforeEach ;
import org.junit.jupiter.api.Test ;
import grade_system.GradeSystems ;
import java.io.IOException ;

class GradeSystemsTest {
	
	GradeSystems aGradeSystem ;

	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名
	
	@BeforeEach 
	public void setUp() throws Exception {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}
	
	@Test
	public void testGradeSystems1() {
		
		assertNotEquals( null, aGradeSystem ) ;
	}
	
	
	@Test
	public void testGradeSystems2() {
		
		float a[] = { 10, 10, 10, 30, 40 } ;
		float b[] = aGradeSystem.getWeights() ;
		
		for( int i=0 ; i<a.length ; ++i ) {
			assertEquals( a[i], (int)(b[i]*100) ) ;
		}
	}
	
	@Test
	public void testGradeSystems3() {
		
		assertEquals( 2, aGradeSystem.getDatabase().size() ) ;
	}
}
