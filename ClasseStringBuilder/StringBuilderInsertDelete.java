package ClasseStringBuilder;

public class StringBuilderInsertDelete {

	public static void main(String[] args) {
		Object objectRef = "hello";
		String string = "goodbye";
		char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
		boolean booleanValue = true;
		char characterValue = 'K';
		int integerValue = 7;
		long longValue = 10000000000L;
		float floatValue = 2.5f;
		double doubleValue = 33.333;
		
		StringBuilder buffer = new StringBuilder();
		
		buffer.insert(0, objectRef);
		buffer.insert(0, "  "); 	//Ciascuno di questi contiene due spazi
		buffer.insert(0, string);
		buffer.insert(0, "  ");
		buffer.insert(0, charArray);
		buffer.insert(0, "  ");
		buffer.insert(0, charArray, 3, 3);
		buffer.insert(0, "  ");
		buffer.insert(0, booleanValue);
		buffer.insert(0, "  ");
		buffer.insert(0, characterValue);
		buffer.insert(0, "  ");
		buffer.insert(0, integerValue);
		buffer.insert(0, "  ");
		buffer.insert(0, longValue);
		buffer.insert(0, "  ");
		buffer.insert(0, floatValue);
		buffer.insert(0, "  ");
		buffer.insert(0, doubleValue);
		
		System.out.printf("buffer after inserts:%n%s%n%n", buffer.toString());
		
		buffer.deleteCharAt(10); //Elimina 5 in 2,5
		buffer.deleteCharAt(9);
		buffer.delete(2, 6);	//Elimina .333 in 33.333
		//buffer.delete(8, 17);
		
		System.out.printf("buffer after deletes:%n%s%n", buffer.toString());
	}
}