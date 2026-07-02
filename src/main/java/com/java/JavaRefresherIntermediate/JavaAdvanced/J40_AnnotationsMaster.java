
package com.java.JavaRefresherIntermediate.JavaAdvanced;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/*
===============================================================================
J40_AnnotationsMaster.java

Topics
------
1. Built-in annotations
2. Custom annotations
3. Meta annotations
4. RetentionPolicy
5. Target
6. Reflection + Annotations
7. Spring connection
===============================================================================
*/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@interface InterviewInfo{
    String author();
    int version() default 1;
}

@InterviewInfo(author="ChatGPT",version=1)
public class J40_AnnotationsMaster {

    @InterviewInfo(author="Developer")
    public void hello(){}

    public static void main(String[] args) throws Exception{

        /*
        WHY ANNOTATIONS?

        Store metadata.

        They DO NOT change business logic.

        Frameworks read them using Reflection.

        Spring
            @Autowired
            @Service
            @RestController

        Hibernate
            @Entity
            @Column

        JUnit
            @Test
        */

        Class<J40_AnnotationsMaster> cls=J40_AnnotationsMaster.class;

        InterviewInfo classInfo=cls.getAnnotation(InterviewInfo.class);
        System.out.println(classInfo.author());

        Method m=cls.getDeclaredMethod("hello");
        InterviewInfo methodInfo=m.getAnnotation(InterviewInfo.class);
        System.out.println(methodInfo.author());

        /*
        Meta Annotations

        @Retention
        @Target
        @Inherited
        @Documented
        @Repeatable

        Retention

        SOURCE
        CLASS
        RUNTIME  <-- Reflection can read

        Interview

        Reflection + Annotation
                =
        Spring Boot
        */
    }
}
