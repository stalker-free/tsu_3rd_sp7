package w2and3;

import java.util.*;

/** * Вы знаете, что такое "множество".
 * В java для работы со множествами используют классы,
 * реализующие интерфейс "Set" (например, HashSet и TreeSet).
 * Вашей задачей будет реализовать мультимноджество,
 * т.е. множество, содержащее одинаковые элементы.
 * (а точнее, все методы этого класса).
 * Для упрощения задачи мультимножество будет содержать только
 * целые числа (Integer).
 */
public class IntegerMultiset
{
    private final TreeMap<Integer,Integer> container = new TreeMap<Integer, Integer>();
    private Integer nextKey = 0;
    
    /** 
     * Генератор ключа
     * @return Следующий ключ
     */
    private Integer nextKey()
    {
        while(container.containsKey(nextKey))
            ++nextKey;
        return nextKey;
    }
    
    /**
     * Добавляет элемент "e"
     * @param e
     * @return true, если в мультимножестве
     * уже есть такой элемент и false иначе
     */
    public boolean add(Integer e)
    {
        boolean contains = container.containsValue(e);
        container.put(nextKey(), e);
        return contains;
    }
    /**
     * Есть ли элемент "e"?
     * @param e
     * @return true, если элемент "e" присутствует
     * в мультимножестве и false иначе
     */
    public boolean contains(Integer e)
    {
        return container.containsValue(e);
    }
    /**
     * Удаляет один элемент "e"
     * @param e
     * @return true, если удаление имело место
     * (т.е. "e" был в мультимножестве перед удалением)
     * и false иначе
     */
    public boolean pop(Integer e)
    {
        boolean contains = container.containsValue(e);
        if(contains)
        {
            for (Integer key : container.keySet()) 
            {
                if(container.get(key).equals(e))
                {
                    container.remove(key);
                    break;
                }
            }
        }
        return contains;
    }
    /**
     * Удаляет все элементы, равные "e".
     * @param e
     * @return true, если удаление имело место и false иначе
     */
    public boolean remove(Integer e)
    {
        boolean contains = container.containsValue(e);
        if(contains)
        {
            Integer[] keyList = container.keySet().toArray(new Integer[0]);
            for (int key = 0 ; key < keyList.length; ++key) 
            {
                if(container.get(keyList[key]).equals(e))
                {
                    container.remove(keyList[key]);
                }
            }
        }
        return contains;       
    }
    
    public void print()
    {
        for(Integer i : container.values())
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
} 