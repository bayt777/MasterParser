package ParserFIX.ParsingForFixImulator;

import quickfix.InvalidMessage;

public class ProtocolFIX50 {
	
	public void parseFix50(String message) throws InvalidMessage {
		System.out.println("This is protocol FIX.5.0");
		System.out.println("------------------------");
		try {
    		String[] fields = message.split("");
    		for (String t : fields) {
    			if(t.startsWith("49=")) {
    				System.out.println("+ \"49=FIXIMULATOR\"");
    			} else if(t.startsWith("56=")) {
    				System.out.println("+ \"56=FIXIMULATOR\"");
    			} else if(t.startsWith("37=")) {
    				System.out.println("+ \"37=\"+orderreferenceid+\"\"");
    			} else if(t.startsWith("38=")) {
    				System.out.println("+ \"38=\"+orderQty+\"\"");
    			} else if(t.startsWith("151=")) {
    				System.out.println("+ \"151=\"+leavesQty+\"\"");
    			} else if(t.startsWith("44=")) {
    				System.out.println("+ \"44=\"+price+\"\"");
    			} else if(t.startsWith("1=")) {
    				System.out.println("+ \"1=\"+ACCOUNT_NAME+\"\"");
    			} else if(t.startsWith("48=")) {
    				System.out.println("+ \"48=\"+ticker+\"\"");
    			} else if(t.startsWith("52=")) {
    				System.out.println("+ \"52=\"+DateHelper.getCurrentDateString(\"yyyyMMdd-HH:mm:ss.SSS\")+\"\"");	
    			} else if(t.startsWith("75=")) {
    				System.out.println("+ \"75=\"+DateHelper.getCurrentDateString(\"yyyyMMdd\")+\"\"");	
    			} else if(t.startsWith("60=")) {
    				System.out.println("+ \"60=\"+DateHelper.getCurrentDateString(\"yyyyMMdd-HH:mm:ss.SSS\")+\"\"");
    			} else 
    				System.out.println("+ \""+ t + "\"");
    			}
        } catch (Exception e) {
            throw new InvalidMessage(e.getMessage());
        }
	}
	
}
