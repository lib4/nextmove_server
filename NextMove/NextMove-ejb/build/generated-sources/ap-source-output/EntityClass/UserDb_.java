package EntityClass;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T19:04:24")
@StaticMetamodel(UserDb.class)
public class UserDb_ { 

    public static volatile SingularAttribute<UserDb, Long> userSegNum;
    public static volatile SingularAttribute<UserDb, String> phoneNumber;
    public static volatile SingularAttribute<UserDb, String> address;
    public static volatile SingularAttribute<UserDb, String> userId;
    public static volatile SingularAttribute<UserDb, String> name;
    public static volatile SingularAttribute<UserDb, String> emailAddress;
    public static volatile SingularAttribute<UserDb, Boolean> isEmailVerified;
    public static volatile SingularAttribute<UserDb, String> password;
    public static volatile SingularAttribute<UserDb, Boolean> isPhoneVerified;

}