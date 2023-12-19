package SerializationApps;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Accounts {
	//@XmlElement specifica nome elemento XML degli oggetti della lista
	@XmlElement(name="account")
	private List<Account> accounts = new ArrayList<>();	//Memorizza conti
	
	//Restituisce la lista dei conti
	public List<Account> getAccounts(){
		return accounts;
	}
}
