
package com.java.JavaRefresherIntermediate.JavaAdvanced;

import java.lang.reflect.*;
import java.util.Arrays;

/*
===============================================================================
J39_ReflectionMaster.java
Java Interview Bible

CHAPTER 39 - REFLECTION MASTER

Interview Rating : ★★★★★

Companies
---------
Amazon
Google
Microsoft
Oracle
JPMorgan
Salesforce

===============================================================================

TABLE OF CONTENTS

1. Why Reflection?
2. Compile Time vs Runtime
3. Class Object
4. Obtaining Class Objects
5. Constructors
6. Fields
7. Methods
8. Creating Objects Dynamically
9. Reading/Writing Private Fields
10. Invoking Private Methods
11. Reflection and Spring
12. Reflection and Hibernate
13. Reflection and Jackson
14. Reflection Interview Questions

===============================================================================
*/

public class J39_ReflectionMaster {

    static class Employee{

        private String name;
        private int age;

        public Employee(){}

        public Employee(String name,int age){
            this.name=name;
            this.age=age;
        }

        private void secretMethod(){
            System.out.println("Private Method Executed");
        }

        public String getName(){
            return name;
        }
    }

    public static void main(String[] args) throws Exception{

        /*
        ===========================================================================
        WHY REFLECTION?

        Normally

            Employee e = new Employee();

        We know Employee at COMPILE TIME.

        Frameworks don't.

        Spring

             |

        Reads class metadata

             |

        Creates object

             |

        Injects dependencies

        Reflection makes this possible.
        ===========================================================================
        */

        /*
        ===========================================================================
        WAYS TO GET Class OBJECT
        ===========================================================================
        */

        Class<Employee> c1 = Employee.class;

        Employee emp = new Employee("John",30);

        Class<?> c2 = emp.getClass();

        Class<?> c3 = Class.forName(
                "com.java.JavaRefresherIntermediate.JavaAdvanced.J39_ReflectionMaster$Employee");

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

        /*
        ===========================================================================
        CONSTRUCTORS
        ===========================================================================
        */

        System.out.println("\nConstructors");
        Constructor<?>[] constructors = c1.getDeclaredConstructors();

        for(Constructor<?> c:constructors){
            System.out.println(c);
        }

        Constructor<Employee> constructor =
                c1.getDeclaredConstructor(String.class,int.class);

        Employee e = constructor.newInstance("Alex",25);

        System.out.println(e.getName());

        /*
        ===========================================================================
        FIELDS
        ===========================================================================
        */

        System.out.println("\nDeclared Fields");

        Field[] fields = c1.getDeclaredFields();

        Arrays.stream(fields).forEach(System.out::println);

        Field field = c1.getDeclaredField("name");

        field.setAccessible(true);

        System.out.println(field.get(e));

        field.set(e,"David");

        System.out.println(field.get(e));

        /*
        ===========================================================================
        METHODS
        ===========================================================================
        */

        Method[] methods = c1.getDeclaredMethods();

        Arrays.stream(methods).forEach(System.out::println);

        Method m = c1.getDeclaredMethod("secretMethod");

        m.setAccessible(true);

        m.invoke(e);

        /*
        ===========================================================================
        getFields()

        Returns only PUBLIC fields.

        Includes inherited public fields.

        getDeclaredFields()

        Returns ALL fields declared
        in the current class.

        private
        protected
        default
        public

        Interview Favourite.
        ===========================================================================
        */

        /*
        ===========================================================================
        getMethods()

        Public methods
        + inherited methods.

        getDeclaredMethods()

        Every method declared
        in the class only.
        ===========================================================================
        */

        /*
        ===========================================================================
        SPRING CONNECTION

        @Autowired

            |

        Reflection

            |

        Field.set()

        ------------------------------------------------

        @RequestMapping

            |

        Reflection

            |

        Method.invoke()

        ------------------------------------------------

        @Entity

            |

        Reflection

            |

        Read annotations

            |

        Map object to table
        ===========================================================================
        */

        /*
        ===========================================================================
        INTERVIEW QUESTIONS

        Q. Why Reflection is slow?

        Because JVM performs metadata lookup
        and dynamic invocation.

        ------------------------------------------------

        Q. Can Reflection access private members?

        Yes.

        setAccessible(true)

        ------------------------------------------------

        Q. Why frameworks use Reflection?

        Objects are discovered only at runtime.

        ------------------------------------------------

        Q. Difference

        Class.forName()

        vs

        Employee.class

        ------------------------------------------------

        Q. Difference

        getMethods()

        getDeclaredMethods()

        ------------------------------------------------

        MEMORY

        Class

            ↓

        Metadata

            ↓

        Reflection

            ↓

        Constructors

        Fields

        Methods
        ===========================================================================
        */
    }
}
