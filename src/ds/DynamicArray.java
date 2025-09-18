package ds;

import java.util.*;


public class DynamicArray<T>
{
    private int size = 4;
    private T[] elements;
    private int currentIndex = 0;
    private T MIN_INF = null;
    public DynamicArray()
    {
        this.elements = (T[]) new Object[size];
        Arrays.fill(this.elements, this.MIN_INF);
    }

    public void addElement(T element)
    {
        if(this.currentIndex >= this.size)
        {
            this.increaseSize();
        }

        if(this.elements[currentIndex] == MIN_INF)
        {
            this.elements[this.currentIndex++] = element;
        }
    }

    public T getElement(int index)
    {
        if(index < 0 || this.elements[index] == this.MIN_INF)
        {
            System.out.println("Not found!");
        }
        return this.elements[index];
    }

    public void increaseSize()
    {
        this.size *= 2;
        T[] copy = (T[]) new Object[this.size];
        Arrays.fill(copy, this.MIN_INF);

        for(int i=0; i<this.elements.length; i++)
        {
            copy[i] = this.elements[i];
        }

        this.elements = copy.clone();
    }

    public void displayAllElements()
    {
        for(T i: this.elements)
        {
            if(i != this.MIN_INF)
            {
                System.out.println(i.toString() + " ");
            }
        }
    }

    public int getCurrentSize()
    {
        int cnt = 0;
        for(T i: this.elements)
        {
            if(i == this.MIN_INF) return cnt;
            cnt++;
        }
        return cnt;
    }

    public int getMaxSize()
    {
        return this.size;
    }

    public boolean contains(T element)
    {
        for(T e: this.elements)
        {
            if(e!=null && e.equals(element))
            {
                return true;
            }
        }
        return false;
    }


    public void deleteElement(int index)
    {
        for(int i=index; i<this.elements.length-1; i++)
        {
            this.elements[i] = this.elements[i+1];
        }
    }

}


