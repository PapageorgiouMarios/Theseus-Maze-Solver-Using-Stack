import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class GenericsStackImplementation<T> implements GenericsStack<T>
{
    Node<T> top;
    int size;

    static class Node<T>
    {
        T item;
        Node<T> next;

        public Node(T item)
        {
            this.item = item;
            this.next = null;
        }
    }


    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void push(T item)
    {
        Node<T> current = new Node<>(item);
        current.next = top;
        top = current;
        size++;
    }

    @Override
    public T pop() throws NoSuchElementException
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        T lastItem = top.item;
        top = top.next;
        size--;
        return lastItem;

    }

    @Override
    public T peek() throws NoSuchElementException
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        return top.item;
    }

    @Override
    public void printStack(PrintStream stream)
    {
        Node<T> current = top;

        ArrayList<String> stack_content = new ArrayList<>();

        while(current!=null)
        {
            stack_content.add(String.valueOf(current.item));
            current = current.next;
        }

        Collections.reverse(stack_content);

        StringBuilder result = new StringBuilder("[");

        for (String s : stack_content) {
            result.append(s).append(" ");
        }
        result.append("]");

        System.out.print(result);
    }

    @Override
    public int size()
    {
        return size;
    }

}
