import java.util.Scanner;

public class GradeStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		begin();
		
		double[] midtermResult = midterm();
		int remainWeightFinal = 100 - (int)midtermResult[0];
		
		double[] finalExResult = finalExam(remainWeightFinal);
		int remainWeightHw = (int)(remainWeightFinal - finalExResult[0]);
		double hwResult = homework(remainWeightHw);
		report(midtermResult[1], finalExResult[1], hwResult);
	}
	
	
	public static void begin() {
	System.out.println("This program reads exam /homework scores and reports your overall course grade");
	}
	
	
	static Scanner input = new Scanner(System.in);
	
	
	public static double[] midterm() {
		int weight;//trong so
		int earnedScore;//diem dat duoc
		int isShift;//co duoc tang diem khong
		int shiftedScore = 0;//diem duoc tang
		int totalPoints = 0;//tong diem = diem dat duoc + diem duoc tang (max = 100)
		double weightedScore;// = (tong diem / 100) * trong so
		System.out.println("Midterm:");
		do{
			System.out.print("Weight (0 - 100)? ");
			weight = input.nextInt();
			if(weight < 0 || weight > 100) {
				System.out.println("Trong so phai la nguyen duong be hon 100");
			}
		}
		while(weight < 0 || weight > 100);
		do {
			System.out.print("Score earned (0 - 100)? ");
			earnedScore = input.nextInt();
			if(earnedScore < 0 || earnedScore > 100) {
				System.out.println("Diem dat duoc phai la nguyen duong be hon 100");
			}
		}while(earnedScore < 0 || earnedScore > 100);
		
		System.out.print("Were scores shifted (1 = yes, 2 = no) ");
		isShift = input.nextInt();
		while(isShift != 1 && isShift != 2) {
			
			System.out.println("Ban chi co hai lua chon nhap 1 hoac 2");
			
			System.out.print("Were scores shifted (1 = yes, 2 = no) ");
			isShift = input.nextInt();
		}
		do {
			if(shiftedScore < 0) {
				System.out.println("Diem duoc cong phai la nguyen duong");
			}
			if(isShift == 1) {
				System.out.print("shiftedScore? ");
				shiftedScore = input.nextInt();
				totalPoints = earnedScore + shiftedScore;
			}else if (isShift == 2) {
				totalPoints = earnedScore;
			}
		}while(shiftedScore < 0);
		if(totalPoints >= 100) {
			totalPoints = 100;
		}
		weightedScore = ((double)totalPoints / 100) * weight;
		System.out.println("Total points = " + totalPoints + " /100");
		System.out.println("Weighted score = " + Math.round(weightedScore * 10) / 10.0 + " / " + weight);
		System.out.println();
		return new double[] {weight, weightedScore};
		
	}
	
	
	public static double[] finalExam(double remainWeight) {
		int weight;//trong so
		int earnedScore;//diem dat duoc
		int isShift;//co duoc tang diem khong
		int shiftedScore = 0;//diem duoc tang
		int totalPoints = 0;//tong diem = diem dat duoc + diem duoc tang (max = 100)
		double weightedScore;// = (tong diem / 100) * trong so
		System.out.println("Final:");
		do{
			System.out.print("Weight (0 - 100)? ");
			weight = input.nextInt();
			if(weight < 0 || weight > remainWeight) {
				System.out.println("Trong so phai la nguyen duong be hon " + (int)remainWeight);
			}
		}
		while(weight < 0 || weight > remainWeight);
		do {
			System.out.print("Score earned (0 - 100)? ");
			earnedScore = input.nextInt();
			if(earnedScore < 0 || earnedScore > 100) {
				System.out.println("Diem dat duoc phai la nguyen duong be hon 100");
			}
		}while(earnedScore < 0 || earnedScore > 100);
			System.out.print("Were scores shifted (1 = yes, 2 = no) ");
			isShift = input.nextInt();
			while(isShift != 1 && isShift != 2) {
				
				System.out.println("Ban chi co hai lua chon nhap 1 hoac 2");
			
			System.out.print("Were scores shifted (1 = yes, 2 = no) ");
			isShift = input.nextInt();
		}
			do {
				if(shiftedScore < 0) {
					System.out.println("Diem duoc cong phai la nguyen duong");
				}
				if(isShift == 1) {
					System.out.print("shiftedScore? ");
					shiftedScore = input.nextInt();
					totalPoints = earnedScore + shiftedScore;
				}else if (isShift == 2) {
					totalPoints = earnedScore;
				}
		
		}while(shiftedScore < 0);
		if(totalPoints >= 100) {
			totalPoints = 100;
		}
		weightedScore = ((double)totalPoints / 100) * weight;
		System.out.println("Total points = " + totalPoints + " /100");
		System.out.println("Weighted score = " + Math.round(weightedScore * 10) / 10.0 + " / " + weight);
		System.out.println();
		return new double[] {weight, weightedScore};
		
	}
	
	
	public static double homework(double remainWeight) {
		int numOfAsm;//so bai asm
		int scoreOfAsm;
		int maxScore;
		int sumOfMaxScore = 0;
		int sumOfScore = 0;
		int attendedSections;//So buoi tham gia
		int sectionPoints; //Diem chuyen can = so buoi tham gia * 5 (<= 30)
		int totalPoints;//Tong diem = 3 asm + chuyen can
		double weightedScore;// = (tong diem / (tong 3 diem toi da + 30)) * remainWeight
		System.out.println("Homework:");
		
		System.out.print("Number of assingnments? ");
		numOfAsm = input.nextInt();
		for(int i = 1; i <= numOfAsm; i++) {
			System.out.print("Assignment " + i + " score and max? ");
			scoreOfAsm = input.nextInt();
			maxScore = input.nextInt();
			if(scoreOfAsm > maxScore) {
				System.out.println("Diem cua ban se bang voi diem toi da la " + maxScore);
			}
			scoreOfAsm = Math.min(scoreOfAsm, maxScore);
			sumOfMaxScore += maxScore;
			sumOfScore += scoreOfAsm;
			}
		System.out.print("How many scections did you attend? ");
		attendedSections = input.nextInt();
		sectionPoints = attendedSections * 5;
		if(sectionPoints >= 30) {
			sectionPoints = 30;
		}
		if(sumOfMaxScore >= 120) {
			sumOfMaxScore = 120;
		}
		totalPoints = sumOfScore + sectionPoints;
		totalPoints = Math.min(totalPoints, 150);
		weightedScore =Math.round((((double)totalPoints / (sumOfMaxScore + 30)) * remainWeight) * 10) / 10.0;
		System.out.println("Section points = " + sectionPoints + " / 30");
		System.out.println("Total points = " + totalPoints + " / " + (sumOfMaxScore + 30));
		System.out.println("Weighted score = " + weightedScore + " / " + (int)remainWeight);
		System.out.println();
		return weightedScore;
	}
	
	
	public static void report(double midScore, double finalScore, double homeworkScore) {
		double grade = Math.round((midScore + finalScore + homeworkScore) * 10) / 10.0;
		double GPA;
		System.out.println("Overall percentage = " + grade);
		if(grade >= 85) {
			GPA = 3.0;
			System.out.println("Your grade will be at least: " + GPA);
			System.out.println("sugoi @@");
		}else if(grade < 85 && grade >= 75) {
			GPA = 2.0;
			System.out.println("Your grade will be at least: " + GPA);
			System.out.println("mama ne :)");
		}else if(grade < 75 && grade >= 60) {
			GPA = 1.0;
			System.out.println("Your grade will be at least: " + GPA);
			System.out.println("motto gambatte ^^");
		}else {
			GPA = 0.0;
			System.out.println("Your grade will be at least: " + GPA);
			System.out.println("dame yo -_-");
		}
	}
}