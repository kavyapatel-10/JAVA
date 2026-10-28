
import java.util.ArrayList;

public class GenericStackDemo {

    static class Stack<T> {
        private ArrayList<T> elements = new ArrayList<>();

        // Add an element to the top
        public void push(T item) {
            elements.add(item);
        }

        // Remove and return the top element
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException(
                    "Stack is empty"
                );
            }

            return elements.remove(elements.size() - 1);
        }

        // View the top element without removing it
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException(
                    "Stack is empty"
                );
            }

            return elements.get(elements.size() - 1);
        }

        // Check whether the stack is empty
        public boolean isEmpty() {
            return elements.isEmpty();
        }

        // Return the number of elements
        public int size() {
            return elements.size();
        }

        // Display the stack
        public void display() {
            System.out.println(elements);
        }
    }

    public static void main(String[] args) {

        // Integer stack
        Stack<Integer> numbers = new Stack<>();

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println("Integer stack:");
        numbers.display();

        System.out.println("Top element: " + numbers.peek());
        System.out.println("Popped: " + numbers.pop());
        System.out.println("Stack size: " + numbers.size());
        numbers.display();

        // String stack
        Stack<String> names = new Stack<>();

        names.push("Amit");
        names.push("Rahul");
        names.push("Neha");

        System.out.println("\nString stack:");
        names.display();

        System.out.println("Popped name: " + names.pop());
        System.out.println("Top name: " + names.peek());
    }
}

