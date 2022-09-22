package step.learning;

public class DataTypes {
    public void Run() {
        System.out.println(ConsoleColors.BLUE + "Data types demo" + ConsoleColors.RESET );

        byte bx = -120;
        short sx = 20;
        int ix = 30;
        long lx = 40;
        float fx = 0.1f;
        float fy = (float) 0.1;
        double dx = 0.1;

        char c = 'A';
        boolean b = true;

        System.out.println((char)60);
        System.out.println((int)'A');

        String s1 = "He" + "llo";
        String s2 = "Hel" + "lo";
        if(s1 == s2) System.out.println("==");
        else System.out.println("!=");

        String s3 = new String("Hello");
        String s4 = new String("Hello");
        if(s3 == s4) System.out.println("==");
        else System.out.println("!=");

        if(s3.equals(s4)) System.out.println("equals");
        else System.out.println("!equals");

        System.out.println("" + b);

        // hw show variable info

        System.out.printf(" Bx:%d%n Sx:%d%n Ix:%d%n Lx:%d%n Fx:%f%n Fy:%f%n Dx:%f%n"
                ,bx,sx,ix,lx,fx,fy,dx);

        System.out.printf("byte:%d%n short:%d%n int:%d%n long:%d%n float:%f%n double:%f%n char:%sd%n "
                ,(byte)'H',(short)'Z',(int)'S',(long)'O',(float)'S',(double)'Q' , (char)12);

    }
}
