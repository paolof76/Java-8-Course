package ch.diso.examples.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RetrieveAnnotation {

    public static void main(String[] args) throws Exception {
        Class<AnnotatedClass> object = AnnotatedClass.class;

        Annotation[] annotations = object.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        if (object.isAnnotationPresent(CustomAnnotationClass.class)) {
            Annotation annotation =
                    object.getAnnotation(CustomAnnotationClass.class);
            System.out.println(annotation);
        }

        for (Method method : object.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CustomAnnotationMethod.class)) {
                Annotation annotation =
                        method.getAnnotation(CustomAnnotationMethod.class);
                System.out.println(annotation);
            }
        }
    }
}
