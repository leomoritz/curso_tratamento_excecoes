package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account = null;
		
		System.out.println("Enter account data");
		try {
			System.out.print("Number:");
			int number = sc.nextInt();
			System.out.print("Holder:");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance:");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit:");
			double withdrawLimit = sc.nextDouble();
			account = new Account(number, holder, initialBalance, withdrawLimit);

			System.out.print("\nEnter amount for withdraw:");
			account.withdraw(sc.nextDouble());
			System.out.println(account);

		} catch (WithdrawException we) {
			System.out.println("Withdraw error: " + we.getMessage());
		} catch (NullPointerException np) {
			System.out.println("Null value: " + np.getMessage());
			np.printStackTrace();
		} catch (InputMismatchException ime) {
			System.out.println("Invalid value: " + ime.getMessage());
		} finally {
			sc.close();
		}

	}

}
