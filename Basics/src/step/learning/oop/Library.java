package step.learning.oop;

import java.util.ArrayList;
import java.util.List;

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
            literature.print();
        }
    }
    public void Run() {
        add(new Book()
                .setAuthor("Knuth")
                .setTitle("Art of programming"));
        add(new Journal().setNumber(1).setTitle("Journal Part"));
        printFunds();
    }
}
