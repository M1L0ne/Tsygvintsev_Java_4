package tsygvintsev;

import java.util.*;

public class Main {
    static int choice = 0;
    static List<String> strList = new ArrayList<>();
    static List<Integer> intList = new ArrayList<>();
    static String[] arrString;
    static Integer[] arrInteger;
    static List<Integer[]> arrList = new ArrayList<>();
    static List<Integer[]> newArrList = new ArrayList<>();
    static List<Integer> newList = new ArrayList<>();
    static List<String> newStringList = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int taskNum = 0;
        int arrayLen = 0;

        MaximumSearch maximumSearch = new MaximumSearch();
        System.out.println("Для перехода обратно в меню и выхода вводите '-1'");
        do {
            System.out.println("Введите номер задачи (от 1 до 7): ");
            System.out.println("1 - Обобщённая коробка, 2 - Поиск максимума, 3 - Функция");
            System.out.println("4 - Фильтр, 5 - Сокращение, 6 - Коллекционирование");
            try {
                taskNum = sc.nextInt();

                switch (taskNum) {
                    case 1:
                        boxes(1);
                        break;
                    case 2:
                        do {
                            System.out.println("Выберите действие: 1 - добавить коробку, 2 - найти максимум");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    Object newBox = boxes(2);
                                    maximumSearch.addBox((Box<?>) newBox);
                                    break;
                                case 2:
                                    double max = maximumSearch.findMaximum();
                                    System.out.println("Максимальное значение: " + max);
                                    System.out.println();
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 3:
                        clearLists();

                        do {
                            System.out.println("Выберите действие: 1 - перевести строки в их длину");
                            System.out.println("2 - поменять отрицательные числа на положительные");
                            System.out.println("3 - получить максимальные значения из массивов");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    System.out.println("Введите кол-во объектов в массиве: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите элементы массива через Enter:");
                                    sc.nextLine();
                                    for(int i = 0; i < arrayLen; i++){
                                        strList.add(sc.nextLine());
                                    }

                                    newList = ListTransformer.changeTypes(strList, str -> str.length());
                                    System.out.println("Полученный список: ");
                                    for(Integer element : newList) {
                                        System.out.print(element + " ");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("Введите кол-во объектов в массиве: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите элементы массива через Enter:");
                                    sc.nextLine();
                                    for(int i = 0; i < arrayLen; i++){
                                        intList.add(sc.nextInt());
                                    }

                                    newList = ListTransformer.changeTypes(intList, num -> Math.abs(num));
                                    System.out.println("Полученный список: ");
                                    for (Integer element : newList) {
                                        System.out.print(element + " ");
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("Введите кол-во массивов: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите в каждой строчке элементы массива (целые числа):");
                                    sc.nextLine();

                                    for(int i = 0; i < arrayLen; i++) {
                                        arrString = sc.nextLine().split(" ");

                                        arrInteger = new Integer[arrString.length];

                                        try {
                                            for (int j = 0; j < arrString.length; j++) {
                                                arrInteger[j] = Integer.parseInt(arrString[j]);
                                            }
                                        } catch (NumberFormatException e) {
                                            throw new RuntimeException("Ошибка: ведено не число.");
                                        }

                                        arrList.add(arrInteger);
                                    }

                                    newList = ListTransformer.changeTypes(arrList, value -> {
                                        int max = Integer.MIN_VALUE;

                                        for (int i = 0; i < value.length; i++) {
                                            if (value[i] > max) {
                                                max = value[i];
                                            }
                                        }

                                        return max;
                                    });

                                    System.out.println("Максимальные числа в массивах: ");

                                    for (int i = 0; i < newList.size(); i++) {
                                        System.out.println(i + " массив: " + newList.get(i));
                                        System.out.println();
                                    }
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                            }
                        } while (choice != -1);
                        break;
                    case 4:
                        clearLists();

                        do {
                            System.out.println("Выберите действие: 1 - отфильтровать строки длины меньше 3");
                            System.out.println("2 - отфильтровать положительные элементы");
                            System.out.println("3 - отфильтровать положительные числы массивов");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    System.out.println("Введите кол-во объектов в массиве: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите элементы массива через Enter:");
                                    sc.nextLine();
                                    for(int i = 0; i < arrayLen; i++){
                                        strList.add(sc.nextLine());
                                    }

                                    newStringList = ListFilter.filterList(strList, s -> s.length() < 3);
                                    System.out.println("Полученный список: ");
                                    for(String element : newStringList) {
                                        System.out.print(element + " ");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("Введите кол-во объектов в массиве: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите элементы массива через Enter:");
                                    sc.nextLine();
                                    for(int i = 0; i < arrayLen; i++){
                                        intList.add(sc.nextInt());
                                    }

                                    newList = ListFilter.filterList(intList, n -> n > 0);
                                    System.out.println("Полученный список: ");
                                    for (Integer element : newList) {
                                        System.out.print(element + " ");
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("Введите кол-во массивов: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите в каждой строчке элементы массива (целые числа):");
                                    sc.nextLine();

                                    for(int i = 0; i < arrayLen; i++) {
                                        arrString = sc.nextLine().split(" ");

                                        arrInteger = new Integer[arrString.length];

                                        try {
                                            for (int j = 0; j < arrString.length; j++) {
                                                arrInteger[j] = Integer.parseInt(arrString[j]);
                                            }
                                        } catch (NumberFormatException e) {
                                            throw new RuntimeException("Ошибка: ведено не число.");
                                        }

                                        arrList.add(arrInteger);
                                    }

                                    newArrList = ListFilter.filterList(arrList, arr -> {
                                        for (int element : arr) {
                                            if (element < 0) {
                                                return false;
                                            }
                                        }

                                        return true;
                                    });

                                    System.out.println("Массивы без положительных элементов: ");
                                    int arrNum = 0;
                                    for (Integer[] arr : newArrList) {
                                        arrNum++;
                                        System.out.println("Массив " + arrNum + ":");
                                        for (int i = 0; i < arr.length; i++) {
                                            System.out.print(arr[i] + " ");
                                        }
                                        System.out.println();
                                    }
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                            }
                        } while (choice != -1);
                        break;
                    case 5:
                        clearLists();

                        do {
                            System.out.println("Выберите действие: 1 - сформировать 1 строчку из нескольких");
                            System.out.println("2 - вернуть сумму значений списка");
                            System.out.println("3 - получить общее кол-во элементов в списке");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    String longString = "";
                                    System.out.println("Введите кол-во объектов в массиве: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите элементы массива через Enter:");
                                    sc.nextLine();
                                    for(int i = 0; i < arrayLen; i++){
                                        strList.add(sc.nextLine());
                                    }

                                    longString = ListReduction.reduce(strList, (a, b) -> a + b, "");
                                    System.out.println("Полученная строка: " + longString);
                                    System.out.println();
                                    break;
                                case 2:
                                    int numSum = 0;
                                    System.out.println("Введите кол-во объектов в массиве: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите элементы массива через Enter:");
                                    sc.nextLine();
                                    for(int i = 0; i < arrayLen; i++){
                                        intList.add(sc.nextInt());
                                    }

                                    numSum = ListReduction.reduce(intList, (a, b) -> a + b, 0);
                                    System.out.println("Полученное число: " + numSum);
                                    System.out.println();
                                    break;
                                case 3:
                                    int elementCount = 0;
                                    System.out.println("Введите кол-во массивов: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите в каждой строчке элементы массива (целые числа):");
                                    sc.nextLine();

                                    for(int i = 0; i < arrayLen; i++) {
                                        arrString = sc.nextLine().split(" ");

                                        arrInteger = new Integer[arrString.length];

                                        try {
                                            for (int j = 0; j < arrString.length; j++) {
                                                arrInteger[j] = Integer.parseInt(arrString[j]);
                                            }
                                        } catch (NumberFormatException e) {
                                            throw new RuntimeException("Ошибка: ведено не число.");
                                        }

                                        arrList.add(arrInteger);
                                    }

                                    List<Integer> listLenghts = ListTransformer.changeTypes(arrList, list -> list.length);
                                    elementCount = ListReduction.reduce(listLenghts, (a, b) -> a + b, 0);
                                    System.out.println("Кол-во элементов во всех списках: " + elementCount);
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                            }
                        } while (choice != -1);
                        break;
                    case 6:

                        break;
                    case -1:
                        System.out.println("Выход...");
                        break;
                    default:
                        System.out.println("Ошибка: введено число вне диапазона");


                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено некорректное значение");
                return;
            }
        } while (taskNum != -1);

    }

    public static Object boxes (int taskNum) {
        Box<Object> box = new Box<>();
        do {
            System.out.println("Выберите действие: 1 - положить объект, 2 - забрать объект");
            System.out.println("3 - проверить на заполненность");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите значение: ");
                    sc.nextLine();
                    if (taskNum == 2) {
                        String string = sc.nextLine();
                        double doubleString = Double.parseDouble(string);
                        box.setValue(doubleString);
                    }
                    else {
                        Object object = sc.nextLine();
                        box.setValue(object);
                    }
                    break;
                case 2:
                    Object returnObject = box.getValue();
                    System.out.println("Вы забрали: " + returnObject);
                    System.out.println();
                    break;
                case 3:
                    if (box.isFilled()){
                        System.out.println("В коробке что-то есть");
                        System.out.println();
                    } else {
                        System.out.println("Коробка пуста");
                        System.out.println();
                    }
                    break;
                case -1:
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Ошибка: введено число вне диапазона");
                    break;
            }
        } while (choice != -1);

        return box;
    }

    public static void clearLists() {
        arrList.clear();
        newArrList.clear();
        newList.clear();
        newStringList.clear();
        strList.clear();
        intList.clear();
        arrString = null;
        arrInteger = null;
    }
}
