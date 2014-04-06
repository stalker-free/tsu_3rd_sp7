package w1;


/**
 * Примечание: в этой задаче не рекомендуется использовать контейнеры.
 * Попробуйте вместо этого воспользоваться сортировкой и работать уже с отсортированным массивом.
 * Разрешается использовать библиотечные методы для сортировки, а не писать свои.
 */
import static java.util.Arrays.*;

public class Task1 
{
    public static void main(String[] args) 
    {
        int[] arr = new int[(int)(Math.random() * 11)];
        for(int i = 0 ; i < arr.length ; ++i)
        {
            arr[i] = (int)(Math.random() * 11);
        }
        print(arr);
        System.out.println(numberOfUniqueNumbers(arr));
        System.out.println(mostFrequentNumber(arr));
    }
    
	/** Основа для алгоритма нахождения количества уникальных чисел.
	 * @param currentArr - отсортированный массив.
	 * @return Количество уникальных чисел.
	 */
    public static int baseOfCountOfUniques(int[] currentArr)
    {
        int countOfUniques = currentArr.length;
        for(int i = 1 ; i < currentArr.length ; ++i)
        {
            if(currentArr[i - 1] == currentArr[i])
                --countOfUniques;
        }
        return countOfUniques;
    }
    
	/** Алгоритм нахождения количества уникальных чисел.
	 * @param array - данный массив.
	 * @return Количество уникальных чисел.
	 */	
    public static int numberOfUniqueNumbers(int[] array)
    {
        sort(array);
        return baseOfCountOfUniques(array);
    }
    
    public static void print(int[] arr)
    {
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
	/** Метод для нахождения самого часто встречающегося числа.
	 * @param arr - данный массив.
	 * @return Самое часто встречающееся число.
	 */	
    public static int mostFrequentNumber(int[] arr)
    {
        sort(arr);
        return baseOfMostCommonNumber(arr);
    }
	
	/** Основа метода для нахождения самого часто встречающегося числа.
	 * @param arr - отсортированный массив.
	 * @return Самое часто встречающееся число.
	 */
    private static int baseOfMostCommonNumber(int[] arr) 
    {
        if(arr.length == 0)
    	{
    		throw new IllegalArgumentException("Получен пустой массив в качестве аргумента.");
    	}
        
        // Инициализация массива
        int[][] arrayOfUniques = new int[baseOfCountOfUniques(arr)][2];
        arrayOfUniques[0][0] = arr[0];
        
        // Заполнение масссива
        int i = 1;
        for(int it = 0 ; i < arr.length ; ++i)
        {
            if(arr[i] != arr[i - 1])
            {
                arrayOfUniques[++it][0] = arr[i];
            }
            else
            {
                ++arrayOfUniques[it][1];
            }
        }
        
        // Нахождение количества 
        int max = arrayOfUniques[0][1];
        for (i = 1; i < arrayOfUniques.length ; ++i)
        {
            if(max < arrayOfUniques[i][1])
            {
                max = arrayOfUniques[i][1];
            }
        }
        
        // Нахождение самого встречающегося элемента
        for (i = 0; i < arrayOfUniques.length ; ++i)
        {
            if(arrayOfUniques[i][1] == max)
            {
                break;
            }
        }
        
        return arrayOfUniques[i][0];
    }
}