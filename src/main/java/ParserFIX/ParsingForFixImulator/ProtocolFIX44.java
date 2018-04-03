package ParserFIX.ParsingForFixImulator;

import quickfix.InvalidMessage;

public class ProtocolFIX44 {
	
	public void parseFix44(String message) throws InvalidMessage {
    	try {
    		try {
    			if(message.contains("|"));
    			}
    			catch (Exception e) {
    	            throw new InvalidMessage(e.getMessage());
    	        }
    		String[] fields = message.split("");
    		for (String t : fields) {
    			if(t.startsWith("49=")) {
    				System.out.println("+ \"49=FIXIMULATOR\"");
    			} else if(t.startsWith("56=")) {
    				System.out.println("+ \"56=FIXIMULATOR\"");
    			} else if(t.startsWith("11=")) {
    				System.out.println("+ \"11=\"+clOrdID+\"\"");
    			} else if(t.startsWith("37=")) {
    				System.out.println("+ \"37=\"+orderreferenceid+\"\"");
    			} else if(t.startsWith("1=")) {
    				System.out.println("+ \"1=\"+ACCOUNT_NAME+\"\"");
    			} else if(t.startsWith("55=")) {
    				System.out.println("+ \"55=\"+ticker+\"\"");
    			} else if(t.startsWith("432=")) {
    				System.out.println("+ \"432=\"+expireDate+\"\"");
    			} else if(t.startsWith("52=")) {
    				System.out.println("+ \"52=\"+DateHelper.DT_SHORT_WITH_MILLISECONDS_FOR_FIX_MSG+\"\"");	
    			} else if(t.startsWith("75=")) {
    				System.out.println("+ \"75=\"+DateHelper.DateHelper.DT_SHORTED+\"\"");	
    			} else if(t.startsWith("60=")) {
    				System.out.println("+ \"60=\"+DateHelper.DT_SHORT_WITH_MILLISECONDS_FOR_FIX_MSG+\"\"");
    			} else 
    				System.out.println("+ \""+ t + "\"");
    			}
        } catch (Exception e) {
            throw new InvalidMessage(e.getMessage());
        }
	}
}
