public class MyHeap {

  /**Swap the element at the provided index downward into the correct position.
    This will swap with the larger of the child nodes provided thatchild is larger.
    This stops when a leaf is reached, or neither child is larger.
  *@param size the number of heap elements in the data array.
          This is needed to allow a partially full array to be provided.
  *@precondition the children of data[index] are valid heaps.
  *@precondition index is between 0 and size-1 inclusive
  *@precondition size is between 0 and data.length inclusive.
  */
  public static void pushDown(int[]data, int size, int index){
    int larger = index;
    int left = index * 2 + 1;
    int right = index * 2 + 2;
    if(left < size && data[left] > data[larger]){
      larger = left;
    }
    if(right < size && data[right] > data[larger]){
      larger = right;
    }
    if(larger!=index){
      int temp = data[larger];
      data[larger] = data[index];
      data[index]=temp;
      pushDown(data, size, larger);
    }
  }
      

  /**Reorder the provided array to be a valid heap.
   *@param data is the array to be modified
  */
  public static void buildHeap(int[]data){

  }//We will discuss this today:Before moving onto the next two methods, you must thoughroughly test the pushDown() and buildHeap() commands!


  /**Swap the root node with the element at the provided index.
   *Then push the new root down, but not past the index that it swapped with.
  *@precondition: size is between 0 and data.length inclusive.
  */
  public static void remove(int[]data,int size){
      
  }

  /**Sort the provided array
   *@param data is the array to be sorted
  */
  public static void heapsort(int[]data){

      }
}
