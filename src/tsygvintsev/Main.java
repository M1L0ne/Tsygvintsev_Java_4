package tsygvintsev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int taskNum = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Для выхода введите '-1'");
        do {
            int choice = 0;
            System.out.println("Введите номер задачи (от 1 до 7): ");
            System.out.println("1 - Обобщённая коробка, 2 - , 3 - ");
            System.out.println("4 - , 5 - ");
            try {
                taskNum = sc.nextInt();

                switch (taskNum) {
                    case 1:
                        Box<Object> box = new Box<>();
                        do {
                            System.out.println("Выберите действие: 1 - положить объект, 2 - забрать объект");
                            System.out.println("3 - проверить на заполненность");

                            choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Введите значение: ");
                                    sc.nextLine();
                                    Object object = sc.nextLine();
                                    box.setValue(object);
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
                        break;
                    case 2:
                        break;

                    case 3:
                        do {
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    break;

                                case -1:
                                    System.out.println("Выхд...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 4:

                        do {
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                            }
                        } while (choice != -1);
                        break;
                    case 5:

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
}