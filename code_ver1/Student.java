
public class Student {
	
		public String id;
		public String name;
		public int lab1;
		public int lab2;
		public int lab3;
		public int midtermExam;
		public int finalExam;
		public int total;
		
		public Student(String id,String name,int lab1,int lab2,int lab3,
						int midtermExam,int finalExam){
			this.id = id;
			this.name = name;
			this.lab1 = lab1;
			this.lab2 = lab2;
			this.lab3 = lab3;
			this.midtermExam = midtermExam;
			this.finalExam = finalExam;
			this.total = total;
		}
		
		public String getID() { return id; }
		public String getName() { return name; }
		public int getLab1() { return lab1; }
		public int getLab2() { return lab2; }
		public int getLab3() { return lab3; }
		public int getMidtermExam() { return midtermExam; }
		public int getFinalExam() { return finalExam; }
		public int getTotal() { return total; }
		
		public int calculateTotalGrade (double d_lab1, double d_lab2, double d_lab3, double d_MidtermExam, double d_FinalExam ){
			total = (int) Math.round(d_lab1 * lab1 + d_lab2 * lab2 + d_lab3 * lab3 + 
					d_MidtermExam * midtermExam + d_FinalExam * finalExam);
			return total;
		}
	
}
