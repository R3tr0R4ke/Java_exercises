package tipiEnum;

import java.util.EnumSet;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("All books:");
		
		//Visualizza tutti i libri nel tipo enum Book
		for (Book book : Book.values()) {
			System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
		}
		
		System.out.printf("%nDisplay a range of enum constants:%n");
		
		//Visualizza i primi quattro libri
		for (Book book : EnumSet.range(Book.JHTP, Book.CPPHTP)) {
			System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
		}
	}
}