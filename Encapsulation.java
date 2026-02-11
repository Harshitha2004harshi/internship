//program using encapsulation and inheritance to access private variable to print the person salary


package inheritance;
class Person {

 private int salary = 50000;   

 
 public int getSalary() {
     return salary;
 }
}


class Employee extends Person {

 public void displaySalary() {
     System.out.println("Employee Salary: " + getSalary());
 }
}


public class Main1 {
 public static void main(String[] args) {

     Employee emp = new Employee();  
     emp.displaySalary();            
 }
}
