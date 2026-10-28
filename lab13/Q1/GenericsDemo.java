
public class GenericsDemo {

    // Generic Box class
    static class Box<T> {
        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }

    // Generic Pair class
    static class Pair<A, B> {
        private A first;
        private B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }

    // Generic method to return the first element
    public static <T> T firstElement(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(
                "Array must not be null or empty"
            );
        }
        return array[0];
    }

    public static void main(String[] args) {

        // Box with different types
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer Box: " + intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Hello Java");
        System.out.println("String Box: " + strBox.get());

        // Pair with different types
        Pair<String, Integer> student =
            new Pair<>("Rahul", 17);

        System.out.println("Name: " + student.getFirst());
        System.out.println("Age: " + student.getSecond());

        // Generic first-element method
        String[] names = {"Amit", "Rahul", "Neha"};
        Integer[] numbers = {10, 20, 30};

        System.out.println(
            "First name: " + firstElement(names)
        );
        System.out.println(
            "First number: " + firstElement(numbers)
        );
    }
}
