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
            Node current = top;
            while(current != null)
            {
                ++size;
                current = current.next; // Переход на следующий узел.
            }
            return size;
        }
    }
    
    private Node top;
    private int size = 0;
    
    /**
     * Добавляет число i в конец списка.
     * @param i вставляемое в список значение.
     */
    public void push_back(Integer i)
    {
        Node newTop = new Node(i);
        newTop.next = top;
        top = newTop;
        ++size;
    }

    /**
     * Изымает последний добавленный элемент списка.
     * @return значение извлечённого элемента.
     */
    public Integer pop_back() 
    {
        if(top == null)
        {
            throw new RuntimeException("list is empty!");
        }

	    Integer remaining = top.value;
        top = top.next;
        --size;
        return remaining;
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
     * @param first текущий узел.
     * @return Узел из отсортированного списка.
     */
    private Node mergeSort(Node first, int length)
    {
        if(length < 2) return first; // Возращаем исходный узел.

        Node second = first;
	    // Поиск середины.
        int center = (int)(length / 2) - 1;
        for(int i = 0 ; i < center ; ++i)
        {
            second = second.next;
        }
	    // Разделение данного списка на два маленьких.
        second = divide(second);

	    // Слияние 2 отсортированных списков в один.
        ++center;
        return merge(mergeSort(first, center),
                mergeSort(second, length - center));
    }

    /** Слияние 2 массивов
     * @param firstNode
     * @param secondNode
     * @return firstNode + secondNode
     */
     private Node merge(Node firstNode, Node secondNode)
     {
	     // Страховка от нулевых указателей.
         if(firstNode == null) return secondNode;
         if(secondNode == null) return firstNode;

	     // Передача результирующему списку первого узла.
         Node result;
         if(firstNode.value < secondNode.value)
         {
             result = firstNode;
             firstNode = firstNode.next; // Переход в следующий узел.
         }
         else
         {
             result = secondNode;
             secondNode = secondNode.next;
         }

	     // Задание указателя.
         Node it = result;
	     // Объединение списков.
         while(!( (firstNode == null) || (secondNode == null) ))
         {
	         if(firstNode.value < secondNode.value)
	         {
		         it.next = firstNode;
		         firstNode = firstNode.next;
	         }
	         else
	         {
		         it.next = secondNode;
		         secondNode = secondNode.next;
	         }
             it = it.next;
         }

	     // Заполнение конца оставшимся списком.
         it.next = (firstNode == null) ? secondNode : firstNode;
         return result;
     }

     /**
      * Делит список на 2 части.
      * @param head список, от которого отделяют другой список.
      * @return Отделенный список от исходного.
      */
    private static Node divide(Node head)
    {
        if(head == null)
        {
            return null;
        }
        else if(head.next == null)
        {
            return head;
        }
        Node tail = head.next; // Выделение концевого списка.
        head.next = null; // Отсечение концевого списка от исходного.
        return tail;
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
