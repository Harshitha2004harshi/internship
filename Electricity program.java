/*write a program electricity bill calculation 1st 100 units 5rs per unit next 100 units 7rs per unit 
above 200 units 10rs per unit*/

package electric;
import java.util.Scanner;
public class ElectricityBill {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter units:");
		int units=sc.nextInt();
		/*int bill=0;
		if(units<=100)
			bill=units*5;
		else if(units<=200)
			bill=(100*5)+(units-100)*7;
		else
			bill=(100*5)+(100*7)+(units-200)*10;*/
		int bill=(units<=100)
				?units*5:(units<=200)
						?(100*5)+((units-100)*7)
						:(100*5)+(100*7)+(units-200)*10;
		System.out.println("Electricity Bill=Rs"+bill);
	}

}
