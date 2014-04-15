package w3;

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
    private final Map<Integer,Integer> container = new TreeMap<Integer, Integer>();
    
    /**
     * Добавляет элемент "value"
     * @param value
     * @return true, если в мультимножестве
     * уже есть такой элемент и false иначе
     */
    public boolean add(Integer value)
    {
        boolean contains = container.containsKey(value);
        container.put(value, contains ? container.get(value) + 1 : 1);
        return contains;
    }

    /**
     * Есть ли элемент "value"?
     * @param value
     * @return true, если элемент "value" присутствует
     * в мультимножестве и false иначе
     */
    public boolean contains(Integer value)
    {
        return container.containsKey(value);
    }

    /**
     * Удаляет один элемент "value"
     * @param value
     * @return true, если удаление имело место
     * (т.е. "value" был в мультимножестве перед удалением)
     * и false иначе
     */
    public boolean pop(Integer value)
    {
        boolean contains = container.containsKey(value);
        if(contains)
        {
            Integer quantity = container.get(value);
            if(quantity > 1) container.put(value, quantity - 1);
            else container.remove(value);
        }
        return contains;
    }
    
    /**
     * Удаляет все элементы, равные "value".
     * @param value
     * @return true, если удаление имело место и false иначе
     */
    public boolean remove(Integer value)
    {
        boolean contains = container.containsKey(value);
        container.remove(value);
        return contains;       
    }
    
    public void print()
    {
        System.out.println(container);
        System.out.println();
    }
} 
