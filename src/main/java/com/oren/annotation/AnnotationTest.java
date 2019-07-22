package com.oren.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) throws Exception{
        Person person = new Person();
        Class<Person> c = Person.class;
        Method someBody = c.getMethod("someBody", String.class, int.class);
        someBody.invoke(person, new Object[]{"lily", 18});
        iteratorAnnotations(someBody);

    }

    public static void iteratorAnnotations(Method method) {
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            String[] value = annotation.value();
            for (String str : value) {
                System.out.printf(str+" ");
            }
            System.out.println();
        }

        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }

    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String [] value() default "unknown";
}


class Person {

    @MyAnnotation
    public void empty() {
        System.out.println("emtpy");
    }

    @MyAnnotation(value = {"grl","body"})
    public void someBody(String name, int age) {
        System.out.println("somebody: "+name+","+age);
    }
}



