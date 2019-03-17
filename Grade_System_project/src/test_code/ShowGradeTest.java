package test_code;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grade_system.GradeSystems;

class ShowGradeTest {
	
	GradeSystems aGradeSystem ;

	// 962001044 凌宗廷 87 86 98 88 87 -> totalGrade = 88, 第二名
	// 962001051 李威廷 81 98 84 90 93 -> totalGrade = 91, 第一名
	
	@BeforeEach 
	public void setUp() throws Exception {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}

	@Test
	void testShowGrade1() {
		
		String expectedOutput = "李威廷成績:\n" + "lab1:\t\t81\n" + "lab2:\t\t98\n" + "lab3:\t\t84\n" + 
				"midterm exam:\t90\n" + "final exam:\t93\n" + "total grade:\t91\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showGrade( "962001051" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
	
	@Test
	void testShowGrade2() {
		
		String expectedOutput = "凌宗廷成績:\n" + "lab1:\t\t87\n" + "lab2:\t\t86\n" + "lab3:\t\t98\n" + 
				"midterm exam:\t88\n" + "final exam:\t87\n" + "total grade:\t88\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showGrade( "962001044" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
}
