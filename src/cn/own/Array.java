package cn.own;

public class Array {
    private int[] data;

    private int size;

    /**
     *
     * @param capacity  初始容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);//默认初始容量为10
    }

    /**
     *
     * @return  数组中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return  数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     *
     * @return  数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 末尾添加元素
     * @param e 元素
     */
    public void addLast(int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        data[size] = e;
        size++;
    }

    /**
     * 指定位置插入
     * @param index 下标
     * @param e 元素
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 add index < size.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, getCapacity()));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}
