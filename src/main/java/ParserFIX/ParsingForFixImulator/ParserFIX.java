package ParserFIX.ParsingForFixImulator;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import quickfix.InvalidMessage;

public class ParserFIX {
	
	public static String fixStandart = null;
	static ProtocolFIX44 protocolFIX44 = new ProtocolFIX44();
	static ProtocolFIX50 protocolFIX50 = new ProtocolFIX50();
	
	 @SuppressWarnings("resource")
	public static void main(String[] args) throws ExecutionException{
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Put here the FIX msg");
			System.out.println("--------------------");
			String a = sc.nextLine();
			parsFIX(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

	public static void parsFIX(String msg) throws InvalidMessage {

		if(msg.startsWith("8=FIXT.1.1")) {
			fixStandart = "FIXT.1.1";
		}else if(msg.startsWith("8=FIX.4.4")){
			fixStandart = "FIX.4.4";
		}else {
           System.out.println("Wrong msg!!! Check separator in the FIX message");
		}
        switch (fixStandart) {
        case "FIXT.1.1" :
        	protocolFIX50.parseFix50(msg);
        	break;
        case "FIX.4.4" :
        	protocolFIX44.parseFix44(msg);
        	break;
        default:
        	System.out.println("Wrong message or not supported version of protocol");
        }
	}	 
}