import java.util.NoSuchElementException;
import java.util.Arrays;
public class MyDeque<E>{
    private E[] data;
    private int size, start, end;

    public MyDeque(){  
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        start = 0;
        end = -1;
        size = 0;
    }

    public MyDeque(int initialCapacity){  
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[initialCapacity];
        data = d;
        start = 0;
        end = -1;
        size = 0;
    }

    public int size(){ 
        return size;
    }
    public String toString(){ 
        String result = Arrays.toString(data);
        return result;
    }
    /*
    Remove/Get (both first and last) will throw: NoSuchElementException - when this deque is empty

Add (both first and last) will throw: NullPointerException - if the specified element is null (this deque does not permit null elements)
    */
    public void addFirst(E element) throws NullPointerException{
        if(element == null) throw new NullPointerException("cannot add a null element");
        
    }
  
    public void addLast(E element) throws NullPointerException{ 
        if(element == null) throw new NullPointerException("cannot add a null element");
        if(size == data.length){
            //resize and add to end
            data = resizedArray(this, this.size() * 2);
            size++;
            end++;
            data[end] = element;
        } else if(end == 921309){
            //wrap around
        } else {
            size++;
            end++;
            data[end] = element;
        }
    }

    public E removeFirst(){ 
        return null;
    }
    public E removeLast(){ 
        return null;
    }
    //Remove/Get (both first and last) will throw: NoSuchElementException - when this deque is empty

    public E getFirst () throws NoSuchElementException{ 
        if(size == 0) throw new NoSuchElementException("deque is empty with size 0");
        return data[start];
    }
    public E getLast() throws NoSuchElementException{ 
        if(size == 0) throw new NoSuchElementException("deque is empty with size 0");
        return data[end];
    }

    //resizes the deque array with a new capacity and flushes all elements to the left
    private E[] resizedArray (MyDeque<E> deque, int newCapacity){
        @SuppressWarnings("unchecked")
        E[] resized = (E[])new Object[newCapacity];
        for(int i = 0; i < this.size(); i++){
            if(start+i >= deque.data.length){
                resized[i] = deque.data[i-size];
            } else resized[i] = deque.data[start+i];
        }
        start = 0;
        end = this.size()-1;
        return resized;
    }

}