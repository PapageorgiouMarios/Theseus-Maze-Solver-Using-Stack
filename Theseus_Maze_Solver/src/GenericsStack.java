import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Defines the methods for a Stack that handles generics(T) items
 */
public interface GenericsStack<T>
{

    /**
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * insert a T item to the stack
     */
    public void push(T item);

    /**
     * remove and return the item on the top of the stack
     * @return the item on the top of the stack
     * @throws  NoSuchElementException if the stack is empty
     */
    public T pop() throws NoSuchElementException;

    /**
     * return without removing the item on the top of the stack
     * @return the item on the top of the stack
     * @throws  NoSuchElementException if the stack is empty
     */
    public T peek() throws NoSuchElementException;

    /**
     * print the elements of the stack, starting from the item
     * on the bottom to the top,
     * to the stream given as argument
     * printStack(System.out);
     */
    public void printStack(PrintStream stream);

    /**
     * return the size of the stack, 0 if it is empty
     * @return the number of items currently in the stack
     */
    public int size();

}