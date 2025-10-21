import java.util.*;
class Student{
    int id;
    String name;
    double marks;
    Student(int id, String name, double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    void display(){
        System.out.println(id + " | " + name + " | " + marks);
    }
}
public class SimpleStudentManagement{
    static ArrayList<Student> list=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        int choice;
        do{
            System.out.println("\n1.Add  2.View  3.Update  4.Delete  5.Exit");
            System.out.print("Enter choice: ");
            choice=sc.nextInt();

            switch (choice){
                case 1 -> add();
                case 2 -> view();
                case 3 -> update();
                case 4 -> delete();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice!=5);
    }
    static void add(){
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Marks: ");
        double marks = sc.nextDouble();
        list.add(new Student(id, name, marks));
        System.out.println("Added!");
    }
    static void view(){
        if (list.isEmpty()) System.out.println("No records!");
        else for (Student s:list)s.display();
    }
    static void update() {
        System.out.print("Enter ID to update: ");
        int id=sc.nextInt();
        for (Student s:list) {
            if (s.id==id) {
                System.out.print("New Name: ");
                sc.nextLine();
                s.name=sc.nextLine();
                System.out.print("New Marks: ");
                s.marks=sc.nextDouble();
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("ID not found!");
    }
    static void delete() {
        System.out.print("Enter ID to delete: ");
        int id=sc.nextInt();
        for (Student s:list) {
            if (s.id==id) {
                list.remove(s);
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("ID not found!");
    }
}
