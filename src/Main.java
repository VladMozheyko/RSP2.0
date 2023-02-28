import java.util.Random;
import java.util.Scanner;

/**
 * @author group24.01-23
 * @version 1.0
 */
public class Main {
    /*
    Задача
    Реализовать игру "Камень, ножницы, бумага" в версии компьютер против человека
     */

    /*
    Теория
    Главный цикл приложения - это цикл функционирования программы, он будет исполняться до тех пор, пока не будет получена
    команд от пользователя на завершение работы. Как правило, огромное количество задач прикладной разработки сводится к
    взаимодействию с главным циклом

     */

    /*
    Заметки
    Паттерн - шаблон как нужно решать задачи.
    Существует антипаттерн - "Божественный метод". Это метод, который выполняет более одной задачи, таким образом нарушается
    гибкость программы. Программист должен стремиться к тому, чтобы один метод решал одну конкретную задачу.
    final - модификатор, который делает переменную константой, константы принято называть большими буквами
     */

    /*
    Решение
    1) Реализовать генерацию случайных чисел и присвоить числу от 1 до 3 строку, которая будет ходом компьютера
    2) Реализовать считывание хода человека
    3) Реализовать метод для проверки победителя
    4) Реализовать главный цикл приложения
     */

    static Random random = new Random();  // Объект класса Random
    static Scanner scanner = new Scanner(System.in); // Объект для считывания хода человека
    final static String WRONG_INPUT = "Your input is wrong. "; // Объявляем константу

    public static void main(String[] args) {  // Точка входа. Отсюда начинается исполнение любой Java программы
//        A a = new A(1000);               // Пояснение работы с классами - разница между статическими и
//                                         // нестатическими переменными
//        A b = new A(2000);
//
//        System.out.println("A: \n" + "Balance: " + a.balance + " \n" + "BankName: " + a.BanKName );
//        System.out.println("B: \n" + "Balance: " + b.balance + " \n" + "BankName: " + b.BanKName );
        while (true){
            System.out.println(checkWinner(makeComputerMove(), makePlayerMove()));
            if(isEndGame()){
                break;
            }
        }
    }

    public static boolean isEndGame(){
        char ch = ' ';
        while (true) {
            System.out.println("Would you like to end the game?\n" +
                    "y - yes\n" +
                    "n - no");
            ch = scanner.nextLine().charAt(0);
            if (ch == 'y' || ch == 'n') {
                break;
            }
            else{
                System.out.println(WRONG_INPUT);
            }
        }

        if(ch == 'y'){
            return true;
        }
        else
        return false;
    }

    public static String makeComputerMove(){
       int rand = random.nextInt(3) + 1;
       String compMove = "";
       if(rand == 1){
           compMove = "Rock";
       }
       if(rand == 2){
           compMove = "Scissors";
       }
       if(rand == 3) {
           compMove = "Paper";
       }
       return compMove;
    }

    public static String makePlayerMove(){
        String move = "";
        while (true){
            System.out.println("Make your move: ");
            move = scanner.nextLine();
            if(isRightMove(move)) {
               break;
            }
            else {
                System.out.println(WRONG_INPUT);
            }
        }

        return move;
    }

    private static boolean isRightMove(String move) {
        if(!move.equals("Scissors") && !move.equals("Rock") && !move.equals("Paper")){
            return false;
        }
        else
            return true;
    }

    public static String checkWinner(String comp, String player){

        System.out.println("Computer's move: " + comp + " Player's move: " + player);
         if(comp.equals("Scissors") && player.equals("Paper")){
             return "Computer win";
         }
         else if(comp.equals("Scissors") && player.equals("Rock")){
             return "Player win";
         }
        else if(comp.equals("Rock") && player.equals("Paper")){
            return "Player win";
        }
         else if(comp.equals("Rock") && player.equals("Scissors")){
             return "Computer win";
         }
         else if(comp.equals("Paper") && player.equals("Scissors")){
             return "Player win";
         }
         else if(comp.equals("Paper") && player.equals("Rock")){
             return "Computer win";
         }
           else
               return "Draw";
    }
}
