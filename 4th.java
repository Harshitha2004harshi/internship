

//write java program to check the given number is prime number. number is 19 and 49//

public class primecheck {

	public static void main(String[] args) {
		int num=49;
		boolean isPrime=false;
		if(num<=1) {
			isPrime=false;
		}else {
			for(int i=2;i<=num/2;i++) {
				if(num%i==0) {
					isPrime=false;
					break;
				}
			}
		}
		if(isPrime) {
			System.out.println(num+"is a prime number");
		}else {
			System.out.println(num+"is not a prime number");
		}

	}

}
