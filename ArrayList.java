/**
 * @author Shounima
 * @version 1.0
 */
public class ArrayList<T> {

    private T[] backingArray;
    private int size;

    /**
     * The initial capacity of the array list.
     */
    public static final int INITIAL_CAPACITY = 9;

    /**
     * Constructs a new ArrayList.
     */
    public ArrayList() {

        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds the element to the index specified.
     * @param index the index where you want the new element
     * @param data the data to add to the list
     * @throws java.lang.IndexOutOfBoundsException if index is negative
     * or index > size
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addAtIndex(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(
                    "Cannot insert data into a negative index.");
        } else if (index > size()) {
            throw new IndexOutOfBoundsException(
                    "Index is not within the array's capacity");
        } else if (data == null) {
            throw new IllegalArgumentException(
                    "Cannot insert null values into array");
        } else {
            if (size == backingArray.length) {
                resizeArray();
            }
            for (int i = size; i > index; i--) {
                backingArray[i] = backingArray[i - 1];
            }
            backingArray[index] = data;
            size++;
        }
    }

    /**
     * doubles the backingArray whenever this method is called
     */
    private void resizeArray() {
        T[] newArray = (T[]) new Object[backingArray.length * 2];
        for (int i = 0; i < backingArray.length; i++) {
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    /**
     * Adds the given data to the front of your array list.
     *
     * @param data the data to add to the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot insert null values.");
        } else if (backingArray[backingArray.length - 1] != null) {
            resizeArray();
        }
        for (int i = size; i > 0; i--) {
            backingArray[i] = backingArray[i - 1];
        }
        backingArray[0] = data;
        size++;
    }

    /**
     * Adds the given data to the back of your array list: O(1).
     *
     * @param data the data to add to the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        int index;
        if (data == null) {
            throw new IllegalArgumentException("Cannot insert null data");
        } else if (size >= backingArray.length) {
            index = backingArray.length;
            resizeArray();
        } else {
            index = size;
        }
        backingArray[index] = data;
        size++;
    }

    /**
     * Removes and returns the element at {@code index}.
     * O(1) for index {@code size - 1} and O(n) in
     * all other cases.
     *
     * @param index the index of the element
     * @return the object that was formerly at that index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or
     * index >= size
     */
    public T removeAtIndex(int index) {
        T remove;
        if (index < 0) {
            throw new IndexOutOfBoundsException(
                    "Cannot insert data into a negative index.");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index is not within the array's capacity");
        } else {
            remove = backingArray[index];
            for (int i = index; i < size - 1; i++) {
                backingArray[i] = backingArray[i + 1];
            }
            backingArray[size - 1] = null;
            size--;
        }
        return remove;
    }

    /**
     * Removes and returns the first element in the list: O(n).
     *
     * @return the data from the front of the list or null if the list is empty
     */
    public T removeFromFront() {
        T removeFront;
        if (size != 0) {
            removeFront = backingArray[0];
            for (int i = 0; i < size - 1; i++) {
                backingArray[i] = backingArray[i + 1];
            }
            backingArray[size - 1] = null;
            size--;
        } else {
            removeFront = null;
        }
        return removeFront;
    }

    /**
     * Removes and returns the last element in the list: O(1).
     *
     * @return the data from the back of the list or null if the list is empty
     */
    public T removeFromBack() {
        if (size != 0) {
            T removeBack = backingArray[size - 1];
            backingArray[size - 1] = null;
            size--;
            return removeBack;
        } else {
            return null;
        }

    }

    /**
     * Returns the element at the given index.
     *
     * O(1).
     *
     * @param index the index of the element
     * @return the data stored at that index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or
     * index >= size
     */
    public T get(int index) {
        if (index < 0 || backingArray.length == 0) {
            throw new IndexOutOfBoundsException(
                    "Cannot insert data into a negative index.");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index is not within the array's capacity");
        } else {
            return backingArray[index];
        }
    }

    /**
     * Finds the index at which the given data is located in the ArrayList.
     *
     * If there are multiple instances of the data in the ArrayList, then returns
     * the index of the last instance.
     *
     * O(n)
     *
     * @param data the data to find the last index of
     * @return the last index of the data or -1 if the data is not in the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public int lastIndexOf(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot find null data");
        }
        int dataIndex = -1;
        for (int i = size - 1; i > 0; i--) {
            if (backingArray[i].equals(data)) {
                dataIndex = i;
                break;
            }
        }
        return dataIndex;
    }

    /**
     * Returns a boolean value representing whether or not the list is empty.
     *
     * O(1).
     *
     * @return true if empty; false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list. Resets the backing array to a new array of the initial
     * capacity.
     *
     * O(1).
     */
    public void clear() {
        T[] newArray = (T[]) new Object[INITIAL_CAPACITY];
        backingArray = newArray;
        size = 0;
    }
}
