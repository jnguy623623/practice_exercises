package cis44project;
public class Sort {
    
    public static final int MIN_SIZE = 5;

    public static <T extends Comparable<? super T>>
        void mergeSort(T[] a, int n){
        
            mergeSort(a, 0, n-1);
    }//end mergeSort
        
    public static <T extends Comparable<? super T>>
        void mergeSort(T[]a, int first, int last){
                
            @SuppressWarnings("unchecked")
            
            T[] tempArray = (T[])new Comparable<?>[a.length];
            mergeSort(a, tempArray, first, last);
        }//end mergeSort
        
    public static <T extends Comparable <? super T>>
        void mergeSort(T[] a, T[] tempArray, int first, int last){
            
            if (first< last){
                int mid = first + (last-first)/2;
                mergeSort(a, first, mid);
                mergeSort(a, mid+1, last);
                
                if (a[mid].compareTo(a[mid + 1]) > 0){
                    merge(a, tempArray, first, mid, last);
                }
                
                
            }
            
        }//end mergeSort
        
        
        
    public static <T extends Comparable<? super T>>
        void merge(T[] a, T[] tempArray, int first, int mid, int last){
            
            int beginHalf1 = first;
            int endHalf1 = mid;
            int beginHalf2 = mid +1;
            int endHalf2 = last;
            
            int index = beginHalf1;
            
            for(; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++){
                
                if (a[beginHalf1].compareTo (a[beginHalf2]) < 0){
                    
                    tempArray[index] = a[beginHalf1];
                    beginHalf1++;
                    
                }
                else{
                    tempArray[index] = a[beginHalf2];
                    beginHalf2++;
                }
                
            }//end for loop
            
            //finish off nonempty subarray
            
            //finish off first subarray if necessary
            for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
                tempArray[index] = a[beginHalf1];
            
            //finish off second subarray if necessary
            for(; beginHalf2 <= endHalf2; beginHalf2++, index++)
                tempArray[index] = a[beginHalf2];
            
            //copy result back into original array
            for (index = first; index <= last; index++){
                a[index] = tempArray[index]; 
            }          
            
        }//end merge
        
    //see class notes
    public static <T extends Comparable <? super T>>
        void quickSort(T[] array, int n){
            
            quickSort(array, 0, n-1);
    }
        
    public static <T extends Comparable <? super T>>
            void quickSort(T[] a, int first, int last){
                
                if (last - first + 1 < MIN_SIZE){
                    insertionSort(a, first, last);
                }
                
                else{
                    int pivotIndex = partition(a, first, last);
                    
                    quickSort(a, first, pivotIndex-1);
                    quickSort(a, pivotIndex+1, last);
                }
                
            }//end quickSort method
    
    public static <T extends Comparable <? super T>>
        void bubbleSort(T[]a, int n){
            
            if (n > 1){
                for (int index = 0; index < n-1; index++){
                    order(a, index, index+1);
                }
                
                bubbleSort(a, n-1);
                
            }
        
    }//end bubbleSort method
    
    public static <T extends Comparable<? super T>>
            void insertionSort(T[] a, int n){
                
                insertionSort(a, 0, n-1);
            }
    
    public static <T extends Comparable<? super T>>
        void insertionSort(T[] a, int first, int last){
        
            if (first < last){
                
                insertionSort(a, first, last-1);
                insertInOrder(a[last], a, first, last-1);
            }
        }//end insertionSort class
            
    public static <T extends Comparable <? super T>>
            void insertInOrder(T element, T[] a, int begin, int end){
                
                if (element.compareTo(a[end]) >= 0){
                    a[end+1] = element;
                }
                
                else if (begin < end){
                    a[end+1] = element;
                    insertInOrder(element, a, begin, end-1);
                }
                
                else{
                    
                    a[end+1] = a[end];
                    a[end] = element;
                }
                
            }//end insertInOrder method
            
            
   
    //see week7 assignment
    public static <T extends Comparable<? super T>>
        void selectionSort(T[] a, int n){
            
            selectionSort(a, 0, n-1); //recursion
        
    }//end selectionSort
        
    public static <T extends Comparable<? super T>>
        void selectionSort(T[] a, int first, int last){
            
            if (first < last){
                
                //helper methods
                int indexOfNextSmallest = getIndexOfSmallest(a, first, last);
                swap(a, first, indexOfNextSmallest);
                selectionSort(a, first+1, last);
                
            }//end if statement
            
        }//end method
        
    private static <T extends Comparable<? super T>>
        int getIndexOfSmallest(T[] a, int first, int last){
            
            T min = a[first];
            int indexOfMin = first;
            for(int index = first+1; index <= last; index++){
                
                if (a[index].compareTo(min) < 0){
                    
                    min = a[index];
                    indexOfMin = index;
                    //assertion: min is the smallest of a[first] through a[index]
                }
                
            }
           return indexOfMin; 
        }// end getIndexOfSmallest method
          
        
        private static <T extends Comparable <? super T>>
                int partition(T[] a, int first, int last){
                    
                    int mid = first + (last-first)/2;
                    sortFirstMiddleLast(a, first, mid, last);
                    
                    swap(a, mid, last-1);
                    int pivotIndex = last-1;
                    T pivotValue = a[pivotIndex];
                    
                    int indexFromLeft = first+1;
                    int indexFromRight = last-2;
                    
                    boolean done = false;
                    
                    while (done == false){
                        
                        while (a[indexFromLeft].compareTo(pivotValue) < 0){
                            indexFromLeft++;
                        }
                        
                        while (a[indexFromRight].compareTo(pivotValue)>0){
                            indexFromRight--;
                        }
                        
                        assert a[indexFromLeft].compareTo(pivotValue) >= 0 &&
                                a[indexFromRight].compareTo(pivotValue) <= 0;
                        
                        if (indexFromLeft < indexFromRight){
                            
                            swap(a, indexFromLeft, indexFromRight);
                            indexFromLeft++;
                            indexFromRight--;
                            
                        }
                        else {
                         done = true;
                        }
                        
                        
                    }//end while
                    
                    swap(a, pivotIndex, indexFromLeft);
                    pivotIndex = indexFromLeft;
                    return pivotIndex;
                }
    
        private static <T extends Comparable<? super T>>
               void sortFirstMiddleLast(T[] a, int first, int mid, int last){
                   
                   order(a,first,mid); // first <= mid
                   order(a, mid, last); // mid <= last
                   order (a, first, mid); // first <= mid
                   
               }// end sortFirstMiddleLast
        
        
       //Orders two given array elements into ascending order so that a[i] <= a[j]
       private static <T extends Comparable<? super T>>
                void order (T[] a, int i, int j){
                    
                    if (a[i].compareTo(a[j]) > 0)
                        swap(a, i, j);
                    
                }
        
        
        //Swaps the array entries of array[i] and array[j]
        private static void swap(Object[] array, int i, int j){
            Object temp = array[i];
            array[i] = array[j];
            array[j] = temp;     
        }//end swap method
    
}//end class
