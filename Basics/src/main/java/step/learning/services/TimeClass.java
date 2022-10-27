package step.learning.services;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import javax.inject.Singleton;

@Singleton
public class TimeClass {
    private final DateTimeFormatter dtfYear = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final DateTimeFormatter dtfDay = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalDateTime ldtNow = LocalDateTime.now();
    /**
     * @Note return DateTimeFormatter dd.MM.yyyy */
    public DateTimeFormatter getDtfYear(){
        return dtfYear;
    }
    /**
     * @Note return DateTimeFormatter HH:mm:ss */
    public DateTimeFormatter getDtfDay(){
        return dtfDay;
    }
    /**
     * @Note return LocalDateTime*/
    public LocalDateTime getLdtNow(){
        return ldtNow;
    }
}