package step.learning.oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Newspaper
        extends Literature
        implements Printable {
    private Date date ;
    private Calendar calendar ;

    static private final SimpleDateFormat
            dateParser = new SimpleDateFormat( "yyyy-MM-dd" ) ;
    static private final SimpleDateFormat
            datePrinter = new SimpleDateFormat( "dd.MM.yyyy" ) ;
    static private final SimpleDateFormat
            datePrinterShort = new SimpleDateFormat( "dd.MM" ) ;
    public Date getDate() {
        return date;
    }
    public Newspaper setDate( String dateString ) throws ParseException {
        this.date = dateParser.parse( dateString ) ;
        this.calendar = Calendar.getInstance() ;
        calendar.setTime( this.date ) ;
        return this ;
    }
    @Override
    public Newspaper setTitle( String title ) {
        return (Newspaper) super.setTitle( title ) ;
    }
    @Override
    public void print() {
        Calendar now = Calendar.getInstance() ;
        String dateString =
                now.get( Calendar.YEAR ) == calendar.get( Calendar.YEAR )
                        ? datePrinterShort.format( this.getDate() )
                        : datePrinter.format( this.getDate() ) ;
        System.out.printf( "Newspaper '%s' @%s%n",
                super.getTitle(), dateString ) ;

    }
}