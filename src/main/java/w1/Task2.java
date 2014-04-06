package w1;

/**
 * Во второй задаче требуется удалить из массива указанные элементы.
 * Примечание: размеры массива изменять не надо, также как и необязательно сохранять
 * порядок чисел после удаления (например, для массива "1 2 3 4 5" после удаления
 * чисел с 0-го по 2-ое включительно допустимо выдать массив "5 4")
 */
public class Task2 
{
    public static void main(String[] args) 
    {
        int size = 12;
        int[] array = new int[size];

        fill(array);
        print(array);

        remove(array, 5, 7, 0);
        print(array);
    }
    
    public static void print(int[] array)
    {
        for(int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    /**
     * Удаляет диапазон элементов из массива. 
     * @param array - данный массив
     * @param m
     * @param n
     * @return Результирующий массив.
     */
    public static int[] remove(int[] array, int m, int n)
    {
        if(m < 0 || n >= array.length)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(m > n)
        {
            throw new IllegalArgumentException();
        }

        for(int i = 0 ; i < array.length - n - 1; ++i)
        {
            array[m + i] = array[n + i + 1];
        }
        return array;
    }
    
    public static int[] fillEnd(int[] arr, int count, int filler)
    {
        for(int i = arr.length - 1 ; i >= arr.length - count ; --i)
        {
            arr[i] = filler;
        }
        return arr;
    }

    /**
     * Удаляет диапазон элементов из массива. 
     * @param arr - данный массив
     * @param from
     * @param to
     * @param filler - заполнитель
     * @return Результирующий массив.
     */
    public static int[] remove(int[] arr, int from, int to, int filler)
    {
        remove(arr, from, to);
        return fillEnd(arr, to - from + 1, filler);
    }

    public static void fill(int[] arr)
    {
        for(int i = 0 ; i < arr.length ; ++i)
        {
            arr[i] = (int)(1 + Math.random() * 40);
        }
    }
}
