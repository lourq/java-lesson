package step.learning.anno;

@MarkerAnnotation
public class ClassWithAnnotation {

    @FieldAnnotation( value = "For version 1.0", priority = 1 )
    public int field1;

    @FieldAnnotation( value = "For version 1.1", priority = 2 )
    public String field2;
    @ConstructorAnnotation
    public ClassWithAnnotation(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @MethodAnnotation( "Deprecated" )
    public void method1() {
        System.out.println( "--method1 works" ) ;
    }

    @MethodAnnotation( "Recommended" )
    private void method2() {
        System.out.println( "--method2 works" ) ;
    }
}