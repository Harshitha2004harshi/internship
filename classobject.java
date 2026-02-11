package sample1;

class Car {

    String color;   

    void show() {   
        System.out.println("Car color is " + color);
    }
}

public class Main {
    public static void main(String[] args) {

        Car c1 = new Car();   

        c1.color = "Red";    

        c1.show();            
    }
}
