package step.learning.oop;

import java.sql.SQLOutput;
import java.text.*;
import java.util.*;
public class Library {

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
            if(literature instanceof Periodic){
                System.out.println("Printable: " + literature.getTitle());
            }
            else{
               printNonPeriodic(literature);
            }
        }
    }
    public void printNonPeriodic(Literature literature){
        System.out.println("Unprintable: " + literature.getTitle());
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
    }
}
