import java.util.Scanner;

public class OpenResult {

	public static void main(String[] args) {
		Shop s = new Shop();

		Scanner scn = new Scanner(System.in);
		System.out.print("몇 팩 까시겠습니까? (최고 1000팩)  : ");
				int number = scn.nextInt();


		// 배열을 고치면? = > 고친만큼 개봉할 수 있음 (5 = 1팩)
		for (int i=0; i<number ; i++) {  
			s.howMany();
		}
		s.result();
	}
} 