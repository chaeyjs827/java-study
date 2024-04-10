package inflearn.chapter10.polymorphism.ownex1;

public class AnimalMain {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal cow = new Cow();

        sound(dog);
        sound(cat);
        sound(cow);

        Animal[] animalArray = {dog, cat, cow};
        doSound(animalArray);
    }

    private static void sound(Animal animal) {
        animal.sound();
    }

    private static void doSound(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

}
