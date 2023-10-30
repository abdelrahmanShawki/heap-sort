public class binaryHeap {
    private int [] arr = new int[10];
    int count = 0;

    private void resize() {

        if(count == arr.length)
        {

            int [] new_arr = new int[arr.length * 3];
            for(int i = 0; i < arr.length; i++)
            {
                new_arr[i] = arr[i];
            }
            arr = new_arr;
        }
    }

    public void add(int value) {
        arr[count] = value;
        heapfy_up(count);
        count++;

    }
    public void pop(int val) {
        if(val == arr[count - 1])
        {
            arr[count - 1] = 0;
            count--;
        }
        else
        {
            int index = indexOF(val);
            arr[index] = arr[count - 1];
            arr[count - 1] = 0;
            heapfy_down(index);
            count--;
        }
    }

    private int indexOF(int val) {
        for (int i = 0; i < count; i++)
        {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
    public int top() {
        return arr[0];
    }
    private void heapfy_up(int index)
    {
        int parent = indexOfParent(index);
        if(index == 0 || arr[index] < arr[parent] )
            return;


            int swap = arr[parent];
            arr[parent] = arr[index];
            arr[index] = swap;
            heapfy_up(parent);

    }

    private int indexOfParent(int index)
    {
        int index_parent = (int) (index  - 1 )/ 2;
        return index_parent;
    }

    private int[] indexOFChild(int index) {
        int child = 2 * index + 1;
        int ch2 = 2 * index + 2;
        int [] x = new int[2];
        x[0] = child;
        x[1] = ch2;
        return x;
    }

    private void heapfy_down(int index) {
        int [] children = indexOFChild(index);
        int ch1 = children[0];
        int ch2 = children[1];

        if(index == count - 2 || (arr[index] >= arr[ch2] && arr[index] >= arr[ch1]))
            return; //why count - 2 ? because last two elements if exist dont have children , they are leafs

        int max_child = arr[ch2] > arr[ch1] ? ch2 : ch1;

        int swap = arr[index];
        arr[index] = arr[max_child];
        arr[max_child] = swap;
        heapfy_down(max_child);
    }




}
