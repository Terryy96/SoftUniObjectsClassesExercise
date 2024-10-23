import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    public static class Person implements Comparable<Person> {
        private String name;
        private String id;
        private int age;

        public Person(String name, String id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }



        @Override
        public int compareTo(Person other) {
            return Integer.compare(other.age, this.age);
        }

        public String toString(){
            return String.format("%s with ID: %s is %d years old.", name, id, age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
       ArrayList<Person> people = new ArrayList<>();

        while (!input.equals("End")){
            String [] elements = input.split(" ");
            String name = elements[0];
            String id = elements[1];
            int age = Integer.parseInt(elements[2]);

            Person person = new Person(name, id, age);
            people.add(person);

            input = scanner.nextLine();
        }

        Collections.sort(people, Collections.reverseOrder());
        for (Person person :people){
            System.out.println(person.toString());
        }
    }
}
