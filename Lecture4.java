import java.util.Scanner;

public class Lecture4 {

	public static boolean ktsnt(int n) {
		if (n <= 1) {
			return false;
		} else {
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
//New comment by HTV
//Test Commit
	public static boolean ktscp(int n) {
		int temp = (int) Math.sqrt(n);
		if (temp * temp == n) {
			return true;
		} else {
			return false;
		}
	}

	public static int shh(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static boolean ktshh(int n) {
		if (n == shh(n)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean ktchl(int n) {

		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean chc3(int n) {
		for (int i = 1; i <= n; i++) {
			if (n % 3 == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n;
		Scanner obj = new Scanner(System.in);
		do {
			System.out.println("Nhap n: ");
			n = obj.nextInt();
		} while (n == 0);
		if (ktsnt(n)) 
			System.out.println(n + " La so nguyen to");
		} else {
			System.out.println(n + " Khong phai la so nguyen to");
		}
		if (ktscp(n)) {
			System.out.println(n + " La so chinh phuong");
		} else {
			System.out.println(n + " Khong phai la so chinh phuong");
		}
		if (ktshh(n)) {
			System.out.println(n + " La so hoan hao");
		} else {
			System.out.println(n + " Khong phai la so hoan hao");
		}
		if (ktchl(n)) {
			System.out.println(n + " La so chan");
		} else {
			System.out.println(n + " La so le");
		}
		if (chc3(n)) {
			System.out.println(n + " Chia het cho 3");
		} else {
			System.out.println(n + " Khong chia het cho 3");
		}
		obj.close();
	}
}
