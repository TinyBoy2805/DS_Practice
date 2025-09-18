package ds;

import java.util.Arrays;

public class Stack<T>
{
    private int top;
    private T[] elements;
    private int defaultSize;

    public Stack()
    {
        this.defaultSize = 2;
        this.elements = (T[]) new Object[this.defaultSize];
        this.top = -1;
    }

    public void push(T element)
    {
        if(this.top == this.elements.length - 1) this.resize(this.elements.length * 2);
        this.elements[++top] = element;
    }

    public T pop()
    {
        if (isEmpty()) throw new RuntimeException("Stack empty!");
        T element = this.elements[top];
        this.elements[top] = null;
        top--;

        if(top > 0 && top < this.elements.length / 4)
        {
            this.resize(this.elements.length/2);
        }

        return element;
    }

    public T peek()
    {
        if (isEmpty()) throw new RuntimeException("Stack empty!");
        return this.elements[top];
    } 

    public boolean isEmpty()
    {
        return top == -1;
    }

    public int size()
    {
        return top+1;
    }

    public void clear()
    {
        Arrays.fill(this.elements, null);
        T[] newArr = (T[]) new Object[this.defaultSize];
        this.elements = newArr;
        top = -1;
    }

    public boolean contains(T e)
    {
        for(int i=0; i < top; i++)
        {
            if(this.elements[i] != null && this.elements[i].equals(e)) return true;
        }
        return false;
    }


    private void resize(int capacity)
    {
        T[] newData = (T[]) new Object[capacity];
        System.arraycopy(this.elements, 0, newData, 0, top+1);
        this.elements = newData;
    }

}
