package EntityClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-21T15:27:49")
@StaticMetamodel(MailsQueueDb.class)
public class MailsQueueDb_ { 

    public static volatile SingularAttribute<MailsQueueDb, Long> mailSeqNum;
    public static volatile SingularAttribute<MailsQueueDb, String> moverEmail;
    public static volatile SingularAttribute<MailsQueueDb, String> moveId;
    public static volatile SingularAttribute<MailsQueueDb, String> moverId;
    public static volatile SingularAttribute<MailsQueueDb, String> moveMail;
    public static volatile SingularAttribute<MailsQueueDb, Boolean> isSent;

}