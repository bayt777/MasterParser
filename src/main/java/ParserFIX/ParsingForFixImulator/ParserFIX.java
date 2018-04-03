package ParserFIX.ParsingForFixImulator;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import quickfix.InvalidMessage;

public class ParserFIX {
	
	public static String fixStandart = null;
	static ProtocolFIX44 protocolFIX44 = new ProtocolFIX44();
	static ProtocolFIX50 protocolFIX50 = new ProtocolFIX50();
	static String a = "";
	static String b = "close";
	
	 public static void main(String[] args) throws ExecutionException, NullPointerException{
		try {
			Scanner sc = new Scanner(System.in);
			printTitle("Put here the FIX msg");
		while (sc.hasNext()) {
			if(a.equals(b)) {
				sc.close();
				printTitle("Program is closed! Thank you for using this program");
			}else {
				a = sc.nextLine();
				parsFIX(a);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

	public static void parsFIX(String msg) throws StringIndexOutOfBoundsException, InvalidMessage, NullPointerException {
		try {
			fixStandart = msg.substring(0, 10);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("You entered wrong message");
		}
        switch (fixStandart) {
        case "8=FIXT.1.1" :
        	protocolFIX50.parseFix50(msg);
			printTitle("Enter \"close\" if you want finish the program");
        	break;
        case "8=FIX.4.4" :
        	protocolFIX44.parseFix44(msg);
			printTitle("Enter \"close\" if you wan't finish the program");
        	break;
        default:
        	printTitle("Wrong message or not supported version of protocol");
        }
	}
	
	public static void printTitle(String text) {
		int separatorLength = text.split("\n")[0].length();
		String separator = "";
		for (int i = 0; i < separatorLength; i++) {
			separator = separator.concat("-");
		}
		System.out.println(separator);
		System.out.println(text);
		System.out.println(separator);
	}
	
}
