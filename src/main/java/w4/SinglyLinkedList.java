package w4;


/** 
 * Односвязный список целых чисел 
 */
public class SinglyLinkedList 
{
    private class Node
    {
        private Integer value;
        private Node next = null;
        
        public Node(Integer val)
        {
            value = val;
        }
        
        /**
         * Вычисляет количество элементов в списке.
         * @return Количество элементов в списке.
         */
        public int size()
        {
            int size = 0;
            Node cur = top;
            while(cur != null)
            {
                ++size;
                cur = cur.next;
            }
            return size;
        }

        /**
         * Меняет местами значения, хранящиеся в узлах.
         * @param node другой узел.
         */
        public void swapValues(Node node)
        {
            int temp = this.value;
            this.value = node.value;
            node.value = temp;
        }
    }
    
    private Node top;
    private int size = 0;
    
    /**
     * Добавляет число i в конец списка
     * @param i
     */
    public void push_back(Integer i)
    {
        Node tmp = new Node(i);
        tmp.next = top;
        top = tmp;
        ++size;
    }

    /**
     * Изымает последний добавленный элемент списка
     * @return
     */
    public Integer pop_back() 
    {
        if(top == null)
        {
            throw new RuntimeException("list is empty!");
        }
        top = top.next;
        --size;
        return top.next.value;
    }

    /**
     * Сортирует односвязный список.
     */
    public void sort() 
    {
        top = mergeSort(top,size);
    }

    /**
     * Сортировка слиянием.
     * @param currentNode текущий узел
     * @return Узел из отсортированного списка.
     */
    private Node mergeSort(Node first, int len)
    {
        if(len < 2) return first;
        Node second = first;
        int center = (int)(len / 2) - 1;
        for(int i = 0 ; i < center ; ++i)
        {
            second = second.next;
        }
        second = divide(second);
        ++center;
        return merge(mergeSort(first, center),
                mergeSort(second, len - center));
    }

    /** Слияние 2 массивов
     * @param firstNode
     * @param secondNode
     * @return centerNode + secondNode
     */
     private Node merge(Node first, Node second)
     {
         if(first == null) return second;
         if(second == null) return first;
         Node result;
         if(first.value < second.value)
         {
             result = divide(first);
             first = first.next;
         }
         else
         {
             result = divide(second);
             second = second.next; // не работает
         }
         Node it = result;
         while(!( (first == null) || (second == null) ))
         {
             it.next = (first.value < second.value) ?
                divide(first) : divide(second);
             it = it.next;
         }
         it.next = (first == null) ? second : first;
         return result;
     }

     /**
      * Делит список на 2 части.
      * @param list список, от которого отделяют другой список
      * @return Отделенный список от исходного
      */
    private static Node divide(Node list)
    {
        if(list == null)
        {
            return null;
        }
        else if(list.next == null)
        {
            return list;
        }
        Node res = list.next;
        list.next = null;
        return res;
    }

    public static void print(SinglyLinkedList arr)
    {
        Node iterator = arr.top;
        while(iterator != null)
        {
            System.out.print(iterator.value + " ");
            iterator = iterator.next;
        }
        System.out.println();
    }
} 
