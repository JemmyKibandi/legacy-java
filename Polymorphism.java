//Polymorphism
//The same method name behaves differently depending on the object.
class Math {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

}
//Method overloading - Method overloading is when you have same method name but different parameters in the same class.

class Animal {

    void sound() {
        System.out.println("Animal sound");
    }

}

class Dog extends Animal {

    void sound() {
        System.out.println("Dog sound");
    }

}
//Method overriding - Method overriding is when a child class changes the method of parent class.

