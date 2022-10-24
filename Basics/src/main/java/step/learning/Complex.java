package step.learning;

import java.util.*;
import step.learning.anno.DemoClass;
import step.learning.anno.EntryPoint;
import java.util.*;
@DemoClass
public class Complex {
    private final Random random;
    public Complex(){
        random = new Random();
    }
    private void arraysDemo(){
        int[] arr1 = new int[4];
        int[] arr2 = new int[] {5,4,3,2,1,0};
        int[] arr3 = {5,4,3,2,1,0};
        for (int i = 0 ; i < 4 ; i++){
            System.out.print(arr1[i]);
        }
        for(int item : arr2){
            System.out.print(item);
        }

        System.out.println();

        int [][] arr4 = {
                {1,1,1},
                {1,1,1,1},
                {1,1}
        };
        int[][] arr5 = new int[3][4];

        showArr(arr5);
        showArr(arr4);
    }
    private void showArr(int [][]arr){
        System.out.println();
        for(int item[] : arr){
            for (int item_2 : item){
                System.out.print(item_2 + " ");
            }
            System.out.println();
        }
    }
    private void randArr(int [][] arr){
    }
    private void collectionsDemo(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        for (Integer item : list1){
            System.out.print(item + " ");
        }
        System.out.println();
        for (int i = 0 ; i < list1.size() ; i++){
            System.out.printf("i=%d x=%d%n",i,list1.get(i));
        }


    }

    // Hw ui
    private void dictionaryUI(){

        Map<String ,String> map = new HashMap<>();
        map.put("Hello" , "Привет");
        map.put("Tree" , "Дерево");
        map.put("Stone" , "Камень");

        Scanner kbScanner = new Scanner(System.in);
        String str;
        boolean flag = false;
        do {

            System.out.print(" Англо-Украинский словарь\n" +
                    "    1. Показать все\n" +
                    "    2. Перевод англ. слова\n" +
                    "    3. Перевод укр. слова\n" +
                    "    4. Добавить слово\n" +
                    "    0. Выход\n" +
                    "    Введите выбор:");

            str = kbScanner.nextLine();

            switch (str) {
                case "1":
                    showList(map);
                    break;
                case "2":
                    System.out.print("Input word :");
                    System.out.println(map.get(kbScanner.nextLine()));
                    break;
                case "3":
                    System.out.print("Введите слово :");
                    System.out.println(SearchValue(map,kbScanner.nextLine()));
                    break;
                case "4":
                    System.out.print("Input key :");
                    str = kbScanner.nextLine();
                    System.out.print("Input value :");
                    String value = kbScanner.nextLine();
                    map.put(str, value);
                    break;
                case "0":
                    flag = true;
                    break;
                default:
                    System.out.print("err");
                    break;
            }
        }while (!flag);
    }

    // Search key by value
    private String SearchValue(Map<String,String> map , String value) {
        for (Map.Entry<String,String> item : map.entrySet()){
            if(item.getValue().equals(value))
                return item.getKey();
        }
        return "nothing";
    }

    // Show List
    private void showList(Map<String,String> map){
        for (String key : map.keySet()){
            System.out.printf("%s:%s%n",key ,map.get(key));
        }
    }

    // Init
    @EntryPoint
    public void run() {
    //        arraysDemo();
    //        collectionsDemo();
        dictionaryUI();
    }
}
