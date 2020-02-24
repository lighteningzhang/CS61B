1 public class TestAnimals {
2 public static void main(String[] args) {
3 Animal a = new Animal("Pluto", 10);
4 Cat c = new Cat("Garfield", 6);
5 Dog d = new Dog("Fido", 4);
6 a.greet(); // (A) Animal Pluto says: Huh?
7 c.greet(); // (B) Cat Garfield says: Meow!
8 d.greet(); // (C) Dog Fido says: WOOF!
9 a = c;
10 ((Cat) a).greet(); // (D) Cat Garfield says: Meow!
11 a.greet(); // (E) Cat Garfield says: Meow!
12 }
13 }
14 public class Dog extends Animal {
15 public Dog(String name, int age) {
16 super(name, age);
17 noise = "Woof!";
18 }
19 @Override
20 public void greet() {
21 System.out.println("Dog " + name + " says: " + makeNoise());
22 }
23 public void playFetch() {
24 System.out.println("Fetch, " + name + "!");
25 }
26 }