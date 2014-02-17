package EntityClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T00:11:50")
@StaticMetamodel(MovesDb.class)
public class MovesDb_ { 

    public static volatile SingularAttribute<MovesDb, Integer> largeBoxCount;
    public static volatile SingularAttribute<MovesDb, String> moveId;
    public static volatile SingularAttribute<MovesDb, String> destinationAddress;
    public static volatile SingularAttribute<MovesDb, String> dispatchDate;
    public static volatile SingularAttribute<MovesDb, String> userId;
    public static volatile SingularAttribute<MovesDb, Boolean> isBigItemsPresent;
    public static volatile SingularAttribute<MovesDb, Long> moveSeqNum;
    public static volatile SingularAttribute<MovesDb, Integer> smallBoxCount;
    public static volatile SingularAttribute<MovesDb, String> sourceAddress;
    public static volatile SingularAttribute<MovesDb, String> expectedReceiveDate;
    public static volatile SingularAttribute<MovesDb, Integer> mediumBoxCount;

}