package step.learning.services;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import step.learning.services.CharService;
import step.learning.services.RandomProvider;
// Часто зависимости называют "службами" - поставщиками данных или услуг
public class StringService {
    @Inject  // сама зависимость (служба) также может иметь зависимости
    private SymbolService charService;  // SymbolService - интерфейс, CharService - его реализация
    // private CharService charService; - предпочтительно внедрять интерфейсы
    @Inject @Named("max")  // именованные зависимости - для одинаковых типов
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
