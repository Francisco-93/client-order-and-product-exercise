package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.num.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = sc.nextLine();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order?: ");
		int n = sc.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, sdf.parse(birthDate)));
		
		for(int i=0 ; i<n ; i++) {
			System.out.println("Enter #" + (i+1) + " item data");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			order.addItem(new OrderItem(quantity, price, new Product(productName, price)));
		}
		
		System.out.println("\n\nORDER SUMARY:");
		
		System.out.println(order);
		
		sc.close();
	}

}
