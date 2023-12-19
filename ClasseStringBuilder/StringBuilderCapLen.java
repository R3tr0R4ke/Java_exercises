package ClasseStringBuilder;

public class StringBuilderCapLen {

	public static void main(String[] args) {
		StringBuilder buffer= new StringBuilder("Hello, how are you?");
		
		System.out.printf("buffer = %s%nlength = %d%ncapacity = %d%n%n", buffer.toString(), buffer.length(), buffer.capacity());
		
		//Assicura che uno StringBuilder abbia la capacità specificata
		buffer.ensureCapacity(75);
		System.out.printf("New capacity = %d%n%n", buffer.capacity());
		
		buffer.setLength(10);
		System.out.printf("New lenght = %d%nbuffer = %s%n", buffer.length(), buffer.toString());
	}
}