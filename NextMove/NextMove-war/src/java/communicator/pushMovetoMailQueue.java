/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator;

import EntityClass.MailsQueueDb;
import EntityClass.MoversDb;
import EntityClass.MovesDb;
import SessionBeansEntityClass.MailsQueueDbFacadeLocal;
import SessionBeansEntityClass.MoversDbFacadeLocal;
import SessionBeansEntityClass.MovesDbFacadeLocal;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author aabuback
 */
public class pushMovetoMailQueue {
    MovesDbFacadeLocal movesDbFacade = lookupMovesDbFacadeLocal();
    MailsQueueDbFacadeLocal mailsQueueDbFacade = lookupMailsQueueDbFacadeLocal();
    MoversDbFacadeLocal moversDbFacade = lookupMoversDbFacadeLocal();

      public static String MOVE_MAIL_TEMPLATE_HEAD    =   "<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "<style>table,th,td{border:1px solid black;border-collapse:collapse;}</style>"+
"    </head>\n" +
"    <body>\n" +
"        <h3 style=\"color:#40B3DF;\">Dear Vendor</h3>\n" +
"        <P>You have new quote request and here is the Move details:- </P>\n"+
            "<table style=\"width:300px\">\n";

   

    
    
    
       public static String MOVE_MAIL_TEMPLATE_END   =   " </table>\n</body>\n</html>\n" ;
    
    
    public void pushMoveToMailQueue(MovesDb movesDb){
        
        List<MoversDb> moversDbs    =   moversDbFacade.findAll();
        Iterator mIterator  =   moversDbs.iterator();
        while(mIterator.hasNext()){
            MoversDb moversDb   =   (MoversDb) mIterator.next();
            MailsQueueDb mailsQueueDb   =   new MailsQueueDb();
            mailsQueueDb.setIsSent(false);
            mailsQueueDb.setMoveMail(moversDb.getMoverEmail());
            mailsQueueDb.setMoverId(moversDb.getMoverId());
            mailsQueueDb.setMoveId(movesDb.getMoveId());
            mailsQueueDb.setMoverEmail(moversDb.getMoverEmail());
            
             String table=   "<tr><td>Small Box</td><td>"+movesDb.getSmallBoxCount()+"</td></tr>"+
                     "<tr><td>Medium Box</td><td>"+movesDb.getMediumBoxCount()+"</td></tr>"+
                     "<tr><td>Large Box</td><td>"+movesDb.getLargeBoxCount()+"</td></tr>"+
                      "<tr><td>Items wont fit in a box</td><td>"+movesDb.getItemsWontFitInBox()+"</td></tr>"+
                     "<tr><td>Items wont fit in elevator</td><td>"+movesDb.getItemsWontFitInElevator()+"</td></tr>"+
                     "<tr><td>Items requires disassembly</td><td>"+movesDb.getItemsNeedDisassembly()+"</td></tr>"+
                     
                     "<tr><td>From Address</td><td>"+movesDb.getSourceAddress()+"</td></tr>"+
                     "<tr><td>To Address</td><td>"+movesDb.getDestinationAddress()+"</td></tr>";
             
             System.out.println(MOVE_MAIL_TEMPLATE_HEAD+table+MOVE_MAIL_TEMPLATE_END);
            mailsQueueDbFacade.create(mailsQueueDb);
        }
        
    }
    
    
    
    
    
    private MoversDbFacadeLocal lookupMoversDbFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (MoversDbFacadeLocal) c.lookup("java:global/NextMove/NextMove-ejb/MoversDbFacade!SessionBeansEntityClass.MoversDbFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MailsQueueDbFacadeLocal lookupMailsQueueDbFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (MailsQueueDbFacadeLocal) c.lookup("java:global/NextMove/NextMove-ejb/MailsQueueDbFacade!SessionBeansEntityClass.MailsQueueDbFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MovesDbFacadeLocal lookupMovesDbFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (MovesDbFacadeLocal) c.lookup("java:global/NextMove/NextMove-ejb/MovesDbFacade!SessionBeansEntityClass.MovesDbFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
}
