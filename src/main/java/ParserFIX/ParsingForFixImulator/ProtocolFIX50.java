package ParserFIX.ParsingForFixImulator;

import quickfix.InvalidMessage;
import quickfix.field.*;


class ProtocolFIX50 {
	
	public void parseFix50(String message) throws InvalidMessage {
		System.out.println("This is protocol FIX.5.0");
		System.out.println("------------------------");
		try {
    		String[] fields = message.split("");
    		for (String t : fields) {
    			if(t.startsWith("49=")) {
    				System.out.println("+ \"49=FIXEXCHANGE\"     //"+ (SenderCompID.class.getTypeName()).substring(15));
    			} else if(t.startsWith("56=")) {
    				System.out.println("+ \"56=FIXEXCHANGE\"     //"+ (TargetCompID.class.getTypeName()).substring(15));
    			} else if(t.startsWith("11=")) {
    				System.out.println("+ \"11=\"+clOrdID+\"\"     //"+ (ClOrdID.class.getTypeName()).substring(15));
    			} else if(t.startsWith("37=")) {
    				System.out.println("+ \"37=\"+orderreferenceid+\"\"     //"+ (OrderID.class.getTypeName()).substring(15));
    			} else if(t.startsWith("38=")) {
    				System.out.println("+ \"38=\"+orderQty+\"\"     //"+ (OrderQty.class.getTypeName()).substring(15));
    			} else if(t.startsWith("151=")) {
    				System.out.println("+ \"151=\"+leavesQty+\"\"     //"+ (LeavesQty.class.getTypeName()).substring(15));
    			} else if(t.startsWith("44=")) {
    				System.out.println("+ \"44=\"+price+\"\"     //"+ (Price.class.getTypeName()).substring(15));
    			} else if(t.startsWith("1=")) {
    				System.out.println("+ \"1=\"+ACCOUNT_NAME+\"\"     //"+ (Account.class.getTypeName()).substring(15));
    			} else if(t.startsWith("48=")) {
    				System.out.println("+ \"48=\"+ticker+\"\"     //"+ (SecurityID.class.getTypeName()).substring(15));;
    			} else if(t.startsWith("52=")) {
    				System.out.println("+ \"52=\"+DateHelper.getCurrentDateString(\"yyyyMMdd-HH:mm:ss.SSS\")+\"\"     //"+ (SendingTime.class.getTypeName()).substring(15));;	
    			} else if(t.startsWith("75=")) {
    				System.out.println("+ \"75=\"+DateHelper.getCurrentDateString(\"yyyyMMdd\")+\"\"     //"+ (TradeDate.class.getTypeName()).substring(15));	
    			} else if(t.startsWith("60=")) {
    				System.out.println("+ \"60=\"+DateHelper.getCurrentDateString(\"yyyyMMdd-HH:mm:ss.SSS\")+\"\"     //"+ (TransactTime.class.getTypeName()).substring(15));
    			} else 
    				System.out.println("+ \""+ t + "\"");
    			}
        } catch (Exception e) {
            throw new InvalidMessage(e.getMessage());
        }
	}

}
