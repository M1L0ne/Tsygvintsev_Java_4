package tsygvintsev;

import java.util.*;

public class Main {
    static int choice = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int taskNum = 0;
        MaximumSearch maximumSearch = new MaximumSearch();
        System.out.println("Для перехода обратно в меню и выхода вводите '-1'");
        do {
            System.out.println("Введите номер задачи (от 1 до 7): ");
            System.out.println("1 - Обобщённая коробка, 2 - Поиск максимума, 3 - Функция");
            System.out.println("4 - , 5 - ");
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
                        int arrayLen;
                        List<String> strList = new ArrayList<>();
                        List<Integer> intList = new ArrayList<>();
                        List<Arrays> arrList = new ArrayList<>();
                        List<Integer> newList;
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

                                    newList = InteractiveTransformer.stringLen(strList);
                                    System.out.println("Полученный список: ");
                                    for(Integer element : newList) {
                                        System.out.print(element + " ");
                                        System.out.println();
                                    }
                                    break;
                                case 2:
                                    System.out.println("Введите кол-во объектов в массиве: ");
                                    arrayLen = sc.nextInt();
                                    System.out.println("Вводите элементы массива через Enter:");
                                    sc.nextLine();
                                    for(int i = 0; i < arrayLen; i++){
                                        intList.add(sc.nextInt());
                                    }

                                    newList = InteractiveTransformer.deleteNegative(intList);
                                    System.out.println("Полученный список: ");
                                    for (Integer element : newList) {
                                        System.out.print(element + " ");
                                        System.out.println();
                                    }
                                    break;
                                case 3:
                                    System.out.println("Вводите м");
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                            }
                        } while (choice != -1);
                        break;
                    case 4:
                        System.out.println("Пример 1:");
                        List<Object> objects = Arrays.asList("qwerty", "asdfg", "zx");
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

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
                    break;
                case 3:
                    if (box.isFilled()){
                        System.out.println("В коробке что-то есть");
                    } else {
                        System.out.println("Коробка пуста");
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
}
