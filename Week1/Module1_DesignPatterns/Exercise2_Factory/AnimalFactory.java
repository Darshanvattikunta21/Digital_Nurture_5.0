public class AnimalFactory {
    public Animal createAnimal(String type) {
        if (type == null) {
            return null;
        }

        switch (type.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "duck":
                return new Duck();
            default:
                return null;
        }
    }
}
