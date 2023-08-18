package IO;

import java.io.*;
import java.util.Scanner;

class Person implements Serializable{
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }



}

public class MP1PersonIO {
    String fileName;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    static Scanner kbInput = new Scanner(System.in);

    public MP1PersonIO(String fileName) {
        this.fileName = fileName;
    }

    public void add() {

        ObjectOutputStream outputStream = null;
        try {
           outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

           while(true) {
               System.out.println("Please enter name or enter to exit:");
               String name = kbInput.nextLine();
               if(name.isBlank()) {
                   break;
               }

               System.out.println("Please enter age: ");
               int age = kbInput.nextInt();

               kbInput.nextLine();

               Person person = new Person(name, age);
               //System.out.println(person);

               outputStream.writeObject(person);
           }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void display() {
        System.out.println("***********************");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            while(true){
                Person person = (Person) objectInputStream.readObject();
                System.out.println(person);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            //System.out.println("End of Display");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            System.out.println("***********************");
    }

    public static void main(String[] args)  {
        MP1PersonIO mp1 = new MP1PersonIO("person.ser");
        try {
            int option = -1;
            while (option != 0) {
                System.out.println("Please choose an option:");
                System.out.println("0: quit");
                System.out.println("1: add");
                System.out.println("2: display");
                option = kbInput.nextInt();
                kbInput.nextLine();
                switch (option) {
                    case 0:
                        System.out.println("Bye");
                        break;
                    case 1:
                        mp1.add();
                        break;
                    case 2:
                        mp1.display();
                }

            }
        } finally {
            //close oos
            //close ois
        }

    }

}