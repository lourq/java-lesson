package step.learning;

import com.google.inject.Inject;

// Часто зависимости называют "службами" - поставщиками данных или услуг
public class StringService {
    @Inject  // сама зависимость (служба) также может иметь зависимости
    private CharService charService;
    @Inject
    private RandomProvider randomProvider ;
    @Inject
    private TimeClass timeClass;

    public String getString() {
        return String.format(
                "Hello, %c, world %d times!",
                charService.getChar(),
                randomProvider.getN() ) ;
    }
    public String getDate(){
        return String.format("Current Date : " + timeClass.getDtfYear().format(timeClass.getLdtNow()));
    }
    public String getTime(){
        return String.format("Current Time : " + timeClass.getDtfDay().format(timeClass.getLdtNow()));
    }
}