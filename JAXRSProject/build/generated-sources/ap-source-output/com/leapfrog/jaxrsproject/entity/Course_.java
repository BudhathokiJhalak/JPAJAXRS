package com.leapfrog.jaxrsproject.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T21:10:10")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Integer> duration;
    public static volatile SingularAttribute<Course, Integer> fees;
    public static volatile SingularAttribute<Course, Date> addedDate;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Date> modifiedDate;
    public static volatile SingularAttribute<Course, Integer> id;
    public static volatile SingularAttribute<Course, String> durationType;
    public static volatile SingularAttribute<Course, Boolean> status;

}