package step.learning;

public class DataTypes {
    public void Run() {
        System.out.println(ConsoleColors.BLUE + "Data types demo" + ConsoleColors.RESET );
        // Типи даних
        byte bx = -120;  // Всі типи знакові, беззнакових не передбачено
        short sx = 20;
        int ix = 30;
        long lx = 40;
        float fx = 0.1f;  // 0.1 - double
        float fy = (float) 0.1;
        double dx = 0.1;

        char c = 'A';   // 2 bytes UTF-16
        boolean b = true;
        // -1 (dec)  = 11111111 (bin) = 255 (unsigned)
        System.out.println((char)60);  // <
        System.out.println((int)'A');  // 65

        String s1 = "He" + "llo";  // String Pool
        String s2 = "Hel" + "lo";  // якщо у пулі є таке значення, береться воно
        if(s1 == s2) System.out.println("==");
        else System.out.println("!=");

        String s3 = new String("Hello");
        String s4 = new String("Hello");
        if(s3 == s4) System.out.println("==");
        else System.out.println("!=");
        /*
        Оператор == працює за посиланнями. Навіть для рядків.
        Для порівняння вживається метод .equals()
         */
        if(s3.equals(s4)) System.out.println("equals");
        else System.out.println("!equals");

        // На відміну від C# у Java не всі об'єкти мають .toString()
        //  для одержання рядку популярний прийом -    "" + obj
        System.out.println("" + b);

        /*
        Д.З. Встановити та переконатись у працездатності IDE Java
        Вивести на консоль усі змінні, оголошені у програмі (bx,sx,...),
        додати до значення відомості про тип даних.
        -120 (byte)
        20 (short)....
         */
    }
}
