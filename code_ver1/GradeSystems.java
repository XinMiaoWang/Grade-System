import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GradeSystems {
	public String id;
	public String name;
	public int lab1;
	public int lab2;
	public int lab3;
	public int midtermExam;
	public int finalExam;
	public int total;
	
	public double d_lab1 = 0.1;
	public double d_lab2 = 0.1;
	public double d_lab3 = 0.1;
	public double d_midtermExam = 0.3;
	public double d_finalExam = 0.4;
	
	double OldWeight[] = {d_lab1, d_lab2, d_lab3, d_midtermExam, d_finalExam};
	double TmpWeight[] = {0,0,0,0,0};
	String subject[] = {"lab1:","lab2:","lab3:","midterm exam:","final exam:"};
	public int n = 5;
	
	public GradeSystems() {
		this.id =id;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midtermExam = midtermExam;
		this.finalExam = finalExam;
		this.total = total;
		
		this.d_lab1 =d_lab1;
		this.d_lab2 = d_lab2;
		this.d_lab3 = d_lab3;
		this.d_midtermExam = d_midtermExam;
		this.d_finalExam = d_finalExam;
	}
		
	public boolean containID(String ID,List<Student> Userlist) {
		for(Student s:Userlist) {
			if(ID.equals(s.getID())) {
				System.out.println("Welcome "+s.getName());
				return true;
			}
		}
		return false;
	}
	
	public void LoadGrade(List<Student> Userlist) {
		for(Student s:Userlist) {
			id = s.getID();
			name = s.getName();
			lab1 = s.getLab1();
			lab2 = s.getLab2();
			lab3 = s.getLab3();
			midtermExam = s.getMidtermExam();
			finalExam = s.getFinalExam();
			total = s.calculateTotalGrade(d_lab1,d_lab2,d_lab3,d_midtermExam,d_finalExam);
		}
	}
	
	public void showGrade(String ID,List<Student> Userlist) {
		for(Student s:Userlist) {
			if(ID.equals(s.getID())) {
				System.out.println("Welcome "+s.getName());
				id = s.getID();
				name = s.getName();
				lab1 = s.getLab1();
				lab2 = s.getLab2();
				lab3 = s.getLab3();
				midtermExam = s.getMidtermExam();
				finalExam = s.getFinalExam();
				total = s.calculateTotalGrade(d_lab1,d_lab2,d_lab3,d_midtermExam,d_finalExam);
				break;
			}
		}
		
		System.out.println(name + "���Z: lab1: " + lab1 +
				"\n           lab2: " + lab2 +
				"\n           lab3: " + lab3 +
				"\n           midterm exam: " + midtermExam +
				"\n           final exam: " + finalExam +
				"\n           total grade: " + total);
	}
	
	public void showRank(String ID,List<Student> Userlist) {
		Collections.sort(Userlist, new StudentComparator());
		int i = 1, score = 0;
		
		for(Student s:Userlist) {
			if(ID.equals(s.getID())) {
				score = s.getTotal();
				break;
			}
		}
		
		// �Τ��ƨӷj�M�ƦW�A�ۦP���ƬۦP�ƦW
		for(Student s:Userlist) {
			if(score == s.getTotal()) {
				System.out.println("�ƦW : "+i);
				break;
			}
			i++;
		}
	}
	
	public class StudentComparator implements Comparator<Student> {
	    public int compare(Student s1, Student s2) {
	        return s1.getTotal()<s2.getTotal()?1:-1;
	    }
	}
	 
	public void updateWeights() {
		oldWeights();
		inputWeights();
		confirmWeights();
	}
	
	
	public void oldWeights() {
		System.out.println("�°t��");
		for(int i=0;i<n;i++)
			System.out.println(subject[i]+(int)(OldWeight[i]*100)+"%");
	}
	
	
	public void inputWeights() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("��J�s�t��");
		for(int i=0;i<n;i++)
			TmpWeight[i] = scanner.nextDouble();
	}
	
	
	public void confirmWeights() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("�нT�{�s�t��");
		for(int i=0;i<n;i++)
			System.out.println(subject[i]+(int)TmpWeight[i]+"%");
		
		System.out.println("�H�W���T��? Y (Yes) �� N (No)");
		String input = scanner.next();
		if(input.equals("Y")) {
			OldWeight[0] = d_lab1 = TmpWeight[0]/100;
			OldWeight[1] = d_lab2 = TmpWeight[1]/100;
			OldWeight[2] = d_lab3 = TmpWeight[2]/100;
			OldWeight[3] = d_midtermExam = TmpWeight[3]/100;
			OldWeight[4] = d_finalExam = TmpWeight[4]/100;
		}
	}
	
	public void loadData(String filename,List<Student> Userlist) throws FileNotFoundException{
		FileReader fr = new FileReader(filename); 
        BufferedReader br = new BufferedReader(fr);
        String line,tmpString;
        String[] tmpArray= new String[7]; // �@���ƥi�H���X7�Ӧr��
        String pattern = "\\s+"; // regular expression
        
        int i=0;
        
			try {
				while((line = br.readLine())!=null){
					//br.readLine()�O��Ū��txt�ɪ��C�@����,��Ū�쪺��Ʀs��line
					//�A�Nline�ᵹtmpString�h�x�s
					tmpString = line; 
					
					// �ϥγ�@�ť���Ӥ��r��A�|�]���s��ť���ӳy�����~�A�Υ��W��F�����r��A�i�קK�����~�C
					tmpArray = tmpString.split(pattern);
				   
					Userlist.add(new Student( tmpArray[0], tmpArray[1], Integer.parseInt(tmpArray[2]), Integer.parseInt(tmpArray[3]) ,
							Integer.parseInt(tmpArray[4]), Integer.parseInt(tmpArray[5]), Integer.parseInt(tmpArray[6]) )); 
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

}
