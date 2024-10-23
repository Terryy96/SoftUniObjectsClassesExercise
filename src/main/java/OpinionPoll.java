import java.util.Scanner;

public class OpinionPoll {


    public static class Person{
        private String name;
        private int age;


        public static void checkIfOlderThan30(String name, int age){
            if (age>30){
                System.out.println(name + " - " + age);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String info = scanner.nextLine();
            String [] data = info.split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person.checkIfOlderThan30(name,age);
        }
    }
}
