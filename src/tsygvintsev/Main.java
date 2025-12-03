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
                        do {
                            choice = sc.nextInt();
                            switch (choice) {
                                case 1:
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
                System.out.println("Ошибка: введено не число");
                return;
            }
        } while (taskNum != -1);

    }
}