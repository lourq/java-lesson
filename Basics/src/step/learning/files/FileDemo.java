package step.learning.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class FileDemo {
    public void run() {
        // fsDemo() ;
//        ioDemo() ;
        fsNav();
    }
    // region Работа с файловой системой
    /**
     * Работа с файловой системой
     */

    private void commandCd(String dirName){
        File file = new File(dirName);
        if(file.isDirectory()){
            String[] dirValue = file.list();
            assert dirValue != null;
            System.out.println("|");
            for(String value : dirValue){
                System.out.println("|_"+value);
            }
        }
        else
            System.out.println("Resource not found");
    }
    private void commandCat(String fileName){
        File file = new File(fileName);
        StringBuilder strBuild = new StringBuilder();
        if(file.isFile()) {
            if (file.canRead()) {
                try (FileReader fos = new FileReader(file)) {
                    int symbol ;
                    while( ( symbol = fos.read() ) != -1 ) {
                        strBuild.append((char)symbol) ;
                    }
                    System.out.println(strBuild.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else
            System.out.println("Resource not found");
    }

    //region hw fileNav
    private void fsNav(){
        String command = null;

        Scanner kbScanner = new Scanner(System.in);
        commandCd(".");
        do {
            System.out.print("> ");
            command = kbScanner.nextLine();
            switch (command.split(" ")[0]) {
                case "cd" -> commandCd(command.split(" ")[1]);
                case "cat" -> commandCat(command.split(" ")[1]);
                case "exit" -> System.out.println("exit");
                default -> System.out.println("Command unknown");
            }
        }while(!command.equals("exit"));

    }


    private void fsDemo() {
        File file = new File( "newItem" ) ;   // "." - текущая (рабочая) директория

        if( file.isDirectory() ) {
            System.out.println( file.getName() + " - is existing directory" ) ;
            String[] list = file.list() ;
            if( list != null ) {
                for( String itemName : list ) {
                    System.out.println( itemName ) ;
                }
            } else System.out.println( "List request error" ) ;

            // Предложим удалить директорию
            System.out.print( "Delete directory? (y/...) " ) ;
            int sym ;
            try {
                sym = System.in.read() ;
            }
            catch( IOException ex ) {
                System.out.println( "System error: " + ex.getMessage() ) ;
                return ;
            }
            if( sym == 'y' ) {
                boolean res = file.delete() ;
                if( res ) {
                    System.out.println( "Directory deleted successfully" ) ;
                }
                else {
                    System.out.println( "Deletion error" ) ;
                }
            }
            else {
                System.out.println( "Delete cancelled" ) ;
            }
        }
        else if( file.isFile() ) {
            System.out.println( file.getName() + " - is existing file" ) ;

            if( file.canRead() ) System.out.println( "Readable" ) ;
            else System.out.println( "Non-Readable" ) ;

            if( file.canWrite() ) System.out.println( "Writable" ) ;
            else System.out.println( "Non-Writable" ) ;

            if( file.canExecute() ) System.out.println( "Executable" ) ;
            else System.out.println( "Non-Executable" ) ;

            System.out.println( "File size: " + file.length() ) ;
        }
        else {
            System.out.println( file.getName() + " - does not exist" ) ;
            boolean res = file.mkdir() ;   // создать директорию
            if( res ) {
                System.out.printf( "Directory '%s' created%n", file.getName() );
            }
            else {
                System.out.println( "Directory creation error" ) ;
            }
        }
    }
    // endregion

    /**
     * Работа с файлами для хранения данных
     */
    private void ioDemo() {
        // чтение из файла. низкоуровневый вариант
        String fileContent ;
        StringBuilder sb = new StringBuilder() ;
        try( InputStream reader = new FileInputStream( "hello.txt" ) ) {
            int symbol ;
            while( ( symbol = reader.read() ) != -1 ) {  // "12345" - 5 символов  (10+45-  100+5000-  1к+500к- )
                // fileContent += (char) symbol ;   // "" - "1" - "12" - "123" - "1234" - мусор: 5 объектов, 10 символов
                sb.append( (char) symbol ) ;
            }
            // fileContent = sb.toString() ; - переносим за блок try, это позволит
            // System.out.println( fileContent ) ;  быстрее закрыть поток (файл)
        }
        catch( IOException ex ) {
            System.out.println( ex.getMessage() ) ;
            return ;
        }
        // fileContent = sb.toString() ;   // Кодировка по умолчанию - ISO 8859-1 (ASCII)
        fileContent = new String(          // Если нужно менять кодировку
                sb.toString().getBytes(    // используем конструктор строки
                        StandardCharsets.ISO_8859_1 ),
                StandardCharsets.UTF_8 ) ;

        System.out.println( fileContent ) ;

        // Запись в файл на примере более высокого уровня
        try( FileWriter writer = new FileWriter( "result.txt" ) ) {
            writer.write( "Здоровенькі були!" ) ;
            writer.flush() ;
        }
        catch( IOException ex ) {
            System.out.println( ex.getMessage() ) ;
            return ;
        }
        System.out.println( "Write finished" ) ;
    }
}
