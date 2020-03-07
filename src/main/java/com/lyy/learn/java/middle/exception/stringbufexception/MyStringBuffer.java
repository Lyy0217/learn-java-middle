package com.lyy.learn.java.middle.exception.stringbufexception;

public class MyStringBuffer implements IStringBuffer {

    int capacity = 16;
    int length = 0;
    char[] value;

    public MyStringBuffer() {
        value = new char[capacity];
    }

    public MyStringBuffer(String str) {
        this();
        if (null == str) {
            return;
        }

        if (capacity < str.length()) {
            capacity = str.length() * 2;
            value = new char[capacity];
        }

        if (capacity >= str.length()) {
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        }

        length = str.length();
    }

    @Override
    public void append(String str) throws IndexIsOutofRangeException, IndexIsNagetiveException {
        insert(length, str);
    }

    @Override
    public void append(char c) throws IndexIsOutofRangeException, IndexIsNagetiveException {
        append(String.valueOf(c));
    }

    @Override
    public void insert(int pos, char b) throws IndexIsOutofRangeException, IndexIsNagetiveException {
        insert(pos, String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) throws IndexIsOutofRangeException, IndexIsNagetiveException {
        // 边界条件判断
        if (pos < 0)
            throw new IndexIsNagetiveException();

        if (pos > length)
            throw new IndexIsOutofRangeException();

        if (null == b)
            throw new NullPointerException();

        // 扩容
        if (length + b.length() > capacity) {
            capacity = (int) ((length + b.length()) * 2.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }

        char[] cs = b.toCharArray();

        // 先把已经存在的数据往后移

        System.arraycopy(value, pos, value, pos + cs.length, length - pos);
        // 把要插入的数据插入到指定位置
        System.arraycopy(cs, 0, value, pos, cs.length);

        length = length + cs.length;
    }

    @Override
    public void delete(int start) throws IndexIsOutofRangeException, IndexIsNagetiveException {
        delete(start, length);
    }

    @Override
    public void delete(int start, int end) throws IndexIsOutofRangeException, IndexIsNagetiveException {
        // 边界条件判断
        if (start < 0)
            throw new IndexIsNagetiveException();

        if (start > length)
            throw new IndexIsOutofRangeException();

        if (end < 0)
            throw new IndexIsNagetiveException();

        if (end > length)
            throw new IndexIsOutofRangeException();

        if (start >= end)
            throw new IndexIsOutofRangeException();

        System.arraycopy(value, end, value, start, length - end);
        length -= end - start;

    }

    @Override
    public void reverse() {
        for (int i = 0; i < length / 2; i++) {

            char temp = value[i];
            value[i] = value[length - i - 1];
            value[length - i - 1] = temp;
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public String toString() {
        char[] realValue = new char[length];

        System.arraycopy(value, 0, realValue, 0, length);

        return new String(realValue);
    }

    public static void main(String[] args) {
        try {
            MyStringBuffer sb = new MyStringBuffer("there light");
            System.out.println(sb);
            sb.insert(0, "let ");
            System.out.println(sb);
            sb.insert(10, "be ");
            System.out.println(sb);
            sb.insert(0, "God Say:");
            System.out.println(sb);
            sb.append("!");
            System.out.println(sb);
            sb.append('?');
            System.out.println(sb);
            sb.reverse();
            System.out.println(sb);

            sb.reverse();
            System.out.println(sb);

            sb.delete(0, 4);
            System.out.println(sb);
            sb.delete(4);
            System.out.println(sb);
        } catch (IndexIsNagetiveException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IndexIsOutofRangeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
