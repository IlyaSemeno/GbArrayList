package seminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GbArrayList <T> implements GbList<T>{
    private T [] array;
    private int size;
    private int capacity;

    public GbArrayList() {
        this.capacity = 2;
        this.size = 0;
        this.array = (T[]) new Object[capacity];
    }

    private void addCapacity(){
        T arr[] = (T[]) new Object[capacity*2];
        System.arraycopy(array, 0, arr, 0, array.length);
        array = arr;
    }

    @Override
    public void add(T elem) {
        if (size == capacity){
            addCapacity();
        }
        array[size] = elem;
        size++;

    }



    //@Override
    // public void remove(int index) {
    //  T arr[] = (T[]) new Object[array.length -1];
    //   System.arraycopy(array,0,arr,0,index);
    //   int amountElementAfterIndex = array.length - index - 1;
    //    System.arraycopy(array, index+1, arr, index, amountElementAfterIndex);
    //   array=arr;
    //   size--;
    // }
    public void remove(int index) {
        try {
            T[] temp = array;
            array = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, array, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, array, index, amountElementsAfterIndex);
            size--;
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator(){
        return new ArrayIterator<>(array);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int index = 0;
        while (index != size) {
            sb.append(array[index]).append(",");
            index++;
        }
        if (sb.length() == 1) return "{}";
        sb.deleteCharAt(sb.length() - 1).append("}");
        return sb.toString();
    }
}
