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

	// 962001044 ��v�� 87 86 98 88 87 -> totalGrade = 88, �ĤG�W
	// 962001051 ���§� 81 98 84 90 93 -> totalGrade = 91, �Ĥ@�W
	
	@BeforeEach 
	public void setUp() throws Exception {
		
		aGradeSystem = new GradeSystems( "./data/testInput.txt" ) ;
	}

	@Test
	void testShowGrade1() {
		
		String expectedOutput = "���§ʦ��Z:\n" + "lab1:\t\t81\n" + "lab2:\t\t98\n" + "lab3:\t\t84\n" + 
				"midterm exam:\t90\n" + "final exam:\t93\n" + "total grade:\t91\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showGrade( "962001051" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
	
	@Test
	void testShowGrade2() {
		
		String expectedOutput = "��v�ʦ��Z:\n" + "lab1:\t\t87\n" + "lab2:\t\t86\n" + "lab3:\t\t98\n" + 
				"midterm exam:\t88\n" + "final exam:\t87\n" + "total grade:\t88\n" ;
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream( expectedOutput.length() ) ;
		System.setOut( new PrintStream( outContent ) ) ;
		
		aGradeSystem.showGrade( "962001044" ) ;
		assertEquals( expectedOutput, outContent.toString() ) ;
	}
}
