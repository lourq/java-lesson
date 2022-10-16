package step.learning.anno;

@MarkerAnnotation
public class ClassWithAnnotation {

    @FieldAnnotation( value = "For version 1.0", priority = 1 )
    public int field1;

    @FieldAnnotation( value = "For version 1.1", priority = 2 )
    public String field2;

    @MethodAnnotation( "Deprecated" )
    public void method1() {
        System.out.println( "--method1 works" ) ;
    }

    @MethodAnnotation( "Recommended" )
    private void method2() {
        System.out.println( "--method2 works" ) ;
    }
}

/*
Домашнее задание: в классах ClassWithAnnotation, ClassWithoutAnnotation
реализовать конструкторы, которые задают полям случайные значения.
В сканирующем цикле проверить: если у поля есть аннотация, то нужно вывести
его (поля) значение
- если объекта нет - создать новый (если у полей вообще нет аннотаций, то
  объект и не будет создан)
- если есть (ранее создан) - использовать его
*/