package inflearn.chapter10.polymorphism.polyabstract.ex1;

import inflearn.chapter10.polymorphism.ex1.Cat;

public class AbstractAnimalMain {

    public static void main(String[] args) {

        Ex1Cat ex1Cat = new Ex1Cat();
        Ex1Dog ex1Dog = new Ex1Dog();
        Ex1Cow ex1Cow = new Ex1Cow();

        soundAnimal(ex1Cat);
        soundAnimal(ex1Cow);
        soundAnimal(ex1Dog);

        moveAnimal(ex1Cat);
        moveAnimal(ex1Cow);
        moveAnimal(ex1Dog);
    }

    private static void soundAnimal(AbstractAnimal animal) {
        animal.sound();
    }

    private static void moveAnimal(AbstractAnimal animal) {
        animal.move();
    }
}
