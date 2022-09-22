package step.learning.oop;

public class Journal extends Literature{
    private int number;

    public int getNumber() {
        return number;
    }

    public Journal setNumber(int number) {
        this.number = number;
        return this;
    }
    @Override
    public void print(){
        System.out.printf( "Journal. Number: %s. Title: %s%n",
                this.number, super.getTitle()
        );
    }
}
