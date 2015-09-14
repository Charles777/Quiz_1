package mainpackage;

import java.util.Scanner;

public class QuarterbackScorer {

	public static void main(String[] args) {
		
		//Using the following formula taken from wikipedia:
		
		//a = \left ({\text{COMP} \over \text{ATT}} - .3 \right ) \times 5
		//b = \left ({\text{YDS} \over \text{ATT}} - 3 \right ) \times .25
		//c = \left ({\text{TD} \over \text{ATT}} \right ) \times 20
		//d = 2.375 - \left ({\text{INT} \over \text{ATT}} \times 25 \right )		
		
		//ATT = Number of passing attempts
		//COMP = Number of completions
		//YDS = Passing yards
		//TD = Touchdown passes
		//INT = Interceptions
				
		//Then, the above calculations are used to complete the passer rating:

		//\text{Passer Rating} = \left ({a + b + c + d \over 6} \right ) \times 100

		//The result of each of the four components a through d is capped at 2.375
		//Components that result in a negative number are made to be zero.
		
		Scanner input = new Scanner(System.in);
		
		//Input block
		System.out.print("Enter # of Passing Attempts:");
		double ATT = input.nextDouble();
		System.out.print("Enter # of Completions:");
		double COMP = input.nextDouble();
		System.out.print("Enter # of Passing Yards:");
		double YDS = input.nextDouble();
		System.out.print("Enter # of TD Passes:");
		double TD = input.nextDouble();
		System.out.print("Enter # of Interceptions:");
		double INT = input.nextDouble();
		
		//Calculation block
		double a = ((COMP / ATT) - .3) * 5;
		double b = ((YDS / ATT) - 3) * .25;
		double c = (TD / ATT) * 20;
		double d = 2.375 - ((INT / ATT) * 25);
		
		//Corrections to scores that are too large/small
		if (a > 2.375)
			a = 2.375;
		
		if (b > 2.375)
			b = 2.375;
		
		if (c > 2.375)
			c = 2.375;
		
		if (d > 2.375)
			d = 2.375;
		
		if (a < 0)
			a = 0;
		
		if (b < 0)
			b = 0;
		
		if (c < 0)
			c = 0;
		
		if (d < 0)
			d = 0;
		//Just now realizing I could have done that much more elegantly with a loop and an array.
		//Still, nothing wrong with this way for four variables. 
		
		
		//Calculating the final score...
		double passer_rating = ((a + b + c + d) / 6) * 100;
		
		System.out.print("Your QB has a score of:" + passer_rating);
		
		input.close();
		
	}

}
