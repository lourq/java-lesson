package step.learning.oop;

import step.learning.serial.DataObject;

import java.io.*;
import java.text.*;
import java.util.*;
public class Library{

    private List<Literature> funds;

    public Library() {
        funds = new ArrayList<Literature>();
    }

    public void add(Literature literature){
        funds.add(literature);
    }
    public void printFunds(){
        for (Literature literature : funds){
            if(literature instanceof Printable){
                ((Printable)literature).print();
            }
            else{
                System.out.println("Unprintable: " + literature.getTitle());
            }
        }
    }
    public void printPeriodic(){
        for(Literature literature : funds){
            if(literature instanceof Periodic) {
                System.out.println("Printable: " + literature.getTitle());
            }
        }
    }
    public void printNotPeriodic(){
        for(Literature literature : funds){
            if(!(literature instanceof Periodic)) {
                System.out.println("Printable: " + literature.getTitle());
            }
        }
    }

    public void serializationFunds(){
        try( FileOutputStream file = new FileOutputStream( "funds.ser" ) ) {
            ObjectOutputStream oos = new ObjectOutputStream( file ) ;

            oos.writeObject(funds);
            oos.flush() ;

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
    public void deserializationFunds(){
        try( FileInputStream file = new FileInputStream( "funds.ser" ) ) {
            ObjectInputStream ois = new ObjectInputStream(file);

            List<?> list = (List<?>) ois.readObject() ;
            System.out.println(list.size());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }
    public void menu(){
        Scanner kbScanner = new Scanner(System.in);
       String str = "";
        do {
            System.out.println("Make your select:\n"
            +"1)Show object with Printable interface\n"
            +"2)Show object with Periodic interface\n"
            +"3)Exit");
            str = kbScanner.nextLine();
            switch (str) {
                case "1" -> printFunds();
                case "2" -> printPeriodic();
                case "3" -> System.out.println("Exit");
                default -> System.out.println("Err");
            }
        }while (!str.equals("3"));
    }
    public void run() {
        add(new Book()
                .setAuthor("Knuth")
                .setTitle("Art of programming"));
        add(new Journal().setNumber(1).setTitle("Journal Part"));
        try {
            add(new Newspaper().setTitle("Planet").setDate("2022-10-10"));
            add(new Newspaper().setTitle("Planet").setDate("2022-10-10"));
            add(new Newspaper().setTitle("Planet").setDate("2022-10-10"));
        } catch (ParseException ex){
            System.out.println(ex.getMessage());
        }
        printFunds();
        printPeriodic();

//        serializationFunds();
        deserializationFunds();
        menu();
    }


}
