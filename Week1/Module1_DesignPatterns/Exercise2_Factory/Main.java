public class Main {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal dog = factory.createAnimal("dog");
        Animal cat = factory.createAnimal("cat");
        Animal duck = factory.createAnimal("duck");

        dog.speak();
        cat.speak();
        duck.speak();
    }
}
