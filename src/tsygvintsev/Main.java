package tsygvintsev;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        int choice;
        int taskNum;
        List<Integer> newList;
        List<String> newStringList;
        HashMap<Integer, List<String>> newMapStringList;
        List<Integer[]> newArrList;

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
                        do {
                            System.out.println("Выберите действие: 1 - перевести строки в их длину");
                            System.out.println("2 - поменять отрицательные числа на положительные");
                            System.out.println("3 - получить максимальные значения из массивов");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    newList = ListFunction.changeTypes(readStringList(), str -> str.length());
                                    printIntegerList(newList);
                                    break;
                                case 2:
                                    newList = ListFunction.changeTypes(readIntegerList(), num -> Math.abs(num));
                                    printIntegerList(newList);
                                    break;
                                case 3:
                                    newList = ListFunction.changeTypes(readArrList(), value -> {
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
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 4:
                        do {
                            System.out.println("Выберите действие: 1 - отфильтровать строки длины меньше 3");
                            System.out.println("2 - отфильтровать положительные элементы");
                            System.out.println("3 - отфильтровать массивы положительных чисел");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    newStringList = ListFilter.filterList(readStringList(), s -> s.length() < 3);
                                    printStringList(newStringList);
                                    break;
                                case 2:
                                    newList = ListFilter.filterList(readIntegerList(), n -> n > 0);
                                    printIntegerList(newList);
                                    break;
                                case 3:
                                    newArrList = ListFilter.filterList(readArrList(), arr -> {
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
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 5:
                        do {
                            System.out.println("Выберите действие: 1 - сформировать 1 строчку из нескольких");
                            System.out.println("2 - вернуть сумму значений списка");
                            System.out.println("3 - получить общее кол-во элементов в списке");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    String longString = ListReduction.reduce(readStringList(), (a, b) -> a + b, "");
                                    System.out.println("Полученная строка: " + longString);
                                    System.out.println();
                                    break;
                                case 2:
                                    int numSum = ListReduction.reduce(readIntegerList(), (a, b) -> a + b, 0);
                                    System.out.println("Полученное число: " + numSum);
                                    System.out.println();
                                    break;
                                case 3:
                                    int elementCount = 0;
                                    List<Integer> listLengths = ListFunction.changeTypes(readArrList(), list -> list.length);
                                    elementCount = ListReduction.reduce(listLengths, (a, b) -> a + b, 0);
                                    System.out.println("Кол-во элементов во всех списках: " + elementCount);
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
                    case 6:
                        do {
                            System.out.println("Выберите действие: 1 - разбить список чисел на положительные и отрицательные");
                            System.out.println("2 - разбить список строк на одинаковые длины");
                            System.out.println("3 - получить список без повторений");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    Map<String, List<Integer>> newMapList;
                                    newMapList = ListCollector.collect(
                                            readIntegerList(),
                                            () -> {
                                                Map<String, List<Integer>> map = new HashMap<>();
                                                map.put("positive", new ArrayList<>());
                                                map.put("negative", new ArrayList<>());
                                                return map;
                                            },
                                            (map, num) -> {
                                                if (num > 0) {
                                                    map.get("positive").add(num);
                                                } else if (num < 0) {
                                                    map.get("negative").add(num);
                                                }
                                            }
                                    );

                                    System.out.println("Новый список: " + newMapList);
                                    System.out.println();
                                    break;
                                case 2:
                                    newMapStringList = ListCollector.collect(readStringList(), () -> new HashMap<Integer, List<String>>(), (map, str) -> {
                                        int len = str.length();
                                        if (!map.containsKey(len)) {
                                            map.put(len, new ArrayList<>());
                                        }

                                        List<String> list = map.get(len);
                                        list.add(str);
                                    });

                                    System.out.println("Новый список: " + newMapStringList);
                                    System.out.println();
                                    break;
                                case 3:
                                    Set<String> uniqueStringList = ListCollector.collect(readStringList(), () -> new HashSet<>(), (set, item) -> set.add(item));

                                    System.out.println("Новый список: " + uniqueStringList);
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

    public static Object boxes(int taskNum) {
        int choice;
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
                        try {
                            String string = sc.nextLine();
                            double doubleString = Double.parseDouble(string);
                            box.setValue(doubleString);
                        } catch (NumberFormatException exception) {
                            System.out.println("Ошибка: введено не число.");
                            break;
                        }
                    } else {
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
                    if (box.isFilled()) {
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

    public static List<Integer> readIntegerList() {
        System.out.println("Введите кол-во чисел в массиве: ");
        int arrayLen = sc.nextInt();
        System.out.println("Вводите элементы массива через Enter:");
        List<Integer> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < arrayLen; i++) {
            list.add(sc.nextInt());
        }
        return list;
    }

    public static List<String> readStringList() {
        System.out.println("Введите кол-во строк в массиве: ");
        int arrayLen = sc.nextInt();
        System.out.println("Вводите элементы массива через Enter:");
        List<String> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < arrayLen; i++) {
            list.add(sc.nextLine());
        }
        return list;
    }

    public static List<Integer[]> readArrList() {
        List<Integer[]> arrList = new ArrayList<>();
        System.out.println("Введите кол-во массивов: ");
        int arrayLen = sc.nextInt();
        System.out.println("Вводите в каждой строчке элементы массива (целые числа):");
        sc.nextLine();

        for (int i = 0; i < arrayLen; i++) {
            String[] arrString = sc.nextLine().split(" ");

            Integer[] arrInteger = new Integer[arrString.length];

            try {
                for (int j = 0; j < arrString.length; j++) {
                    arrInteger[j] = Integer.parseInt(arrString[j]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число.");
                System.out.println();
                break;
            }

            arrList.add(arrInteger);
        }

        return arrList;
    }

    public static void printStringList(List<String> list) {
        System.out.println("Полученный список: ");
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printIntegerList(List<Integer> list) {
        System.out.println("Полученный список: ");
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
