package entities;

import entities.Address;
import entities.Fee;
import entities.SwimStyle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-25T12:30:06")
@StaticMetamodel(Persons.class)
public class Persons_ { 

    public static volatile ListAttribute<Persons, Fee> fees;
    public static volatile SingularAttribute<Persons, Address> address;
    public static volatile SingularAttribute<Persons, Integer> year;
    public static volatile SingularAttribute<Persons, String> name;
    public static volatile ListAttribute<Persons, SwimStyle> styles;
    public static volatile SingularAttribute<Persons, Long> id;

}