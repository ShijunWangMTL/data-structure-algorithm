package ArrayListPractice;

public class CustomArrayOfInts {
    private int[] data = new int[1]; // only grows by doubling size, never shrinks
    private int size = 0; // how many items do you really have

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size == data.length) {
            growStorage();
        }
        data[size] = value;
        size++;
    }

    private void growStorage() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = 0;
        size--;
    }
private void shrinkStorage(){
        if((double)size/data.length*100<25) {
            int[] temp = new int[data.length/2];
            for(int i=0;i<size;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
}

    // delete first value matching, true if value found, false otherwise
    public boolean deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                deleteByIndex(i);
                return true;
            }
        }
        return false;
    }

    public void insertValueAtIndex(int value, int index) {
        if(size==data.length){
            growStorage();
        }
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = 0;
        }
        size = 0;
    }

    // may throw IndexOutOfBoundsException
    public int get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return data[index]; // complexity: o[1]
    }

    // may throw IndexOutOfBoundsException
    public int[] getSlice(int startIdx, int length) {
        if (startIdx < 0 || length <0 || size < startIdx|| size  <  startIdx + length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        int[] arrSlice = new int[length];
        for (int i = 0; i < length; i++) {
            arrSlice[i] = data[i + startIdx];
        }
        return arrSlice;
    }

    @Override
    public String toString() {
        //1st solution, [2, 4, 7, 12, 3]
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i =0; i<size; i++){
            builder.append(i==0 ? "":", ");
            builder.append(data[i]);
        }
        builder.append("]");
        return builder.toString();

        //2nd solution, [2, 4, 7, 12, 3, 0, 0, 0]
      //  return Arrays.toString(data);
    } // returns String similar to: [3, 5, 6, -23]

}
