package entities;

import entities.Persons;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-25T12:30:06")
@StaticMetamodel(SwimStyle.class)
public class SwimStyle_ { 

    public static volatile ListAttribute<SwimStyle, Persons> persons;
    public static volatile SingularAttribute<SwimStyle, Long> id;
    public static volatile SingularAttribute<SwimStyle, String> styleName;

}