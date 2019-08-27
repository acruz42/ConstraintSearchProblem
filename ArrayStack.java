public class ArrayStack implements Stack {
  /** Default array capacity. */
  public static final int CAPACITY=1000;   // default array capacity

  /** Generic array used for storage of stack elements. */
  private TNode[] data;                        // generic array used for storage

  /** Index of the top element of the stack in the array. */
  private int t = -1;                      // index of the top element in stack

  /** Constructs an empty stack using the default array capacity. */
  public ArrayStack() {
     this(CAPACITY);
  }  // constructs stack with default capacity

  /**
   * Constructs and empty stack with the given array capacity.
   * @param capacity length of the underlying array
   */
  public ArrayStack(int capacity) {        // constructs stack with given capacity
    data = new TNode[capacity];     // safe cast; compiler may give warning
  }

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  public int size() { return (t + 1); }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  
  public boolean isEmpty() { return (t == -1); }

  /**
   * Inserts an element at the top of the stack.
   * @param e   the element to be inserted
   * @throws IllegalStateException if the array storing the elements is full
   */
  
  public void push(TNode e) throws IllegalStateException {
    if (size() == data.length) throw new IllegalStateException("Stack is full");
    data[++t] = e;                           // increment t before storing new item
  }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * @return top element in the stack (or null if empty)
   */
  
  public TNode top() {
    if (isEmpty()) return null;
    return data[t];
  }

  /**
   * Removes and returns the top element from the stack.
   * @return element removed (or null if empty)
   */
  
  public TNode pop() {
    if (isEmpty()) return null;
    TNode answer = data[t];
    data[t] = null;                        // dereference to help garbage collection
    t--;
    return answer;
  }

  /**
   * Modified toString method as per the instructions
   * of the lab. Very similar to the original one
   *
   * @return the stack in string format
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("Top:\n");
    for (int j = t; j >= 0; j--) {
      sb.append(data[j]);
      if (j > 0) sb.append("\n");
    }
    sb.append("\n");
    return sb.toString();
  }

}