package pack;

public class Sort {
	static <E> void swap(E[] array,int i, int j) 
	{
		E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	static <E extends Comparable<E>> void quicksort(E [] array,int l,int r) {
		int i = l;
	    int j = r;
	    E p = array[(l + r) / 2];
	    while (i < j) {
	        while (array[i].compareTo(p) < 0)  i++;
	        while (array[j].compareTo(p) > 0)  j--;
	        if (i <= j) {
	            swap(array,i,j);
	            i++;
	            j--;
	        }
	    }
	    if (l < j)
	        quicksort(array,l, j); 
	    if (i < r)
	        quicksort(array,i, r);
	}
	
	static <E extends Comparable<E>> void bubblesort(E [] array) {
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i].compareTo(array[j]) > 0)
					swap(array,i,j);
			}
		}
	}
}
