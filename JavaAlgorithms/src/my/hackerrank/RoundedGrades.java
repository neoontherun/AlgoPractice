package my.hackerrank;

import java.util.Arrays;

/**
 * HackerLand University has the following grading policy:
 * 
 * Every student receives a grade in the inclusive range from 0 to 100 . Any
 * less than 40 is a failing grade. Sam is a professor at the university and
 * likes to round each student's according to these rules:
 * 
 * <li>a. If the difference between the grade and the next multiple of 5 is less
 * than 3, round grade up to the next multiple of 5.</li>
 * <li>b. If the value of grade is less than 38, no rounding occurs as the
 * result will still be a failing grade.</li>
 * 
 * For example, grade=84 will be rounded to 83 but grade=29 will not be rounded
 * because the rounding would result in a number that is less than 40.
 * 
 * This is listed because it is normal to over-think when computing the rounding
 * off but it is simple to calculate the next round number
 *
 */

public class RoundedGrades {

	static int[] gradingStudents(int[] grades) {
		for (int i = 0; i < grades.length; i++) {
			int grade = grades[i];
			if (grade < 38) {
				continue;
			} else {
				int times = grade / 5;
				int nextRoundedNum = 5 * ++times;
				if (nextRoundedNum - grade < 3) {
					grades[i] = nextRoundedNum;
				}
			}
		}
		return grades;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 73, 67, 38, 33 };
		System.out.println(Arrays.asList(gradingStudents(arr)));
	}

}
