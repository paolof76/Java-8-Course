package ch.diso.examples.annotation;

@CustomAnnotationClass(author = "Peter Müller", date = "2016-06-20")
public class AnnotatedClass {

    @CustomAnnotationMethod(
            date = "2014-06-05",
            description = "My Description for this method.")
    public String annotatedMethod() {
        return "Nothing real...";
    }

}
