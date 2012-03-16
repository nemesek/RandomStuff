import java.util.*;

public class Driver 
{

	/**
	 * @param args
	 */
	static final int value = 20;
	static int[] intArray = new int[value]; // = {90, 65, 7, 305, 120, 110, 8};
	//static int[] intArray = {90, 65, 7, 305, 120, 110, 8};
	//static int[] intArray = {8, 2, 5, 3, 10, 7, 1, 4, 6, 9};
	
	public static void main(String[] args) 
	{
		
		Random generator = new Random();		
		for(int i=0; i< intArray.length; ++i)
		{
			int r = generator.nextInt() % 100;
			if(r < 0)
				r*=-1;
			intArray[i] = r;
		}
		
		
		for(int i=0; i< intArray.length; ++i)
		{
			System.out.print(Integer.toString(intArray[i]) + ", ");
		}
		//MergeSort(intArray);
		//QuickSort(intArray, 0, intArray.length-1);
		SelectionSort(intArray);
		//InsertionSort(intArray);
		//BubbleSort(intArray);
		System.out.println("");
		for(int i=0; i< intArray.length; ++i)
		{
			System.out.print(Integer.toString(intArray[i]) + ", ");
		}
		System.out.println("");
	}
	
	public static void QuickSort(int[] A, int low, int high)
	{
		if(low < high)
		{
			int pivot = Partition(A, low, high);
			QuickSort(A, low, pivot);
			QuickSort(A, pivot+1, high);
			
		}

	}
	
	public static int Partition(int[] A, int low, int high)
	{
		int pivot = A[low + (high - low)/2];
		int leftIndex = low;
		int rightIndex = high;
		while(leftIndex <= rightIndex)
		{
			while(A[leftIndex] < pivot)
				leftIndex++;
			while(A[rightIndex] > pivot)
				rightIndex--;
			if(leftIndex <= rightIndex)
			{
				int temp = A[leftIndex];
				A[leftIndex] = A[rightIndex];
				A[rightIndex] = temp;
				leftIndex++;
				rightIndex--;
			}

		}
		leftIndex--;
		return leftIndex;
		
	}
	
	public static void MergeSort(int[] A)
	{
		int n = A.length;
		int jindex = 0;
		if(n > 1)
		{
			int mid = n/2;
			int[] B = new int[mid];
			for(int i=0; i<B.length; i++)
			{
				B[i] = A[i];
			}
			int[] C = new int[n - mid];
			for(int i=mid; i<A.length; i++)
			{
				C[jindex] = A[i];
				jindex++;
			}
			MergeSort(B);
			MergeSort(C);
			Merge(B, C, A);
		}

	}
	public static void Merge(int[] B, int[] C, int[] A)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < B.length && j < C.length)
		{
			if(B[i] <= C[j])
			{
				A[k] = B[i];
				i++;
			}
			else
			{
				A[k] = C[j];
				j++;
			}
			k++;
		}
		if(i == B.length)
		{
			for(int index = j; index < C.length; index++)
			{
				A[k] = C[index];
				k++;
			}
		}
		else
		{
			for(int index = i; index < B.length; index++)
			{
				A[k] = B[index];
				k++;
			}
		}
			
	}
	
	public static void InsertionSort(int[] A)
	{
		//Invariant: After ith iteration of  loop first ith items are sorted
		for(int i=1; i < A.length; i++)
		{
			int temp = A[i];
			int j = i - 1;
			int k = i;
			while(temp < A[j])
			{
				A[k] = A[j];
				A[j] = temp;
				if(j > 0 && k > 0)
				{
					j--;
					k--;
				}
				
			}			
		}
	}
	
	public static void SelectionSort(int[] A)
	{
		//Invariant: After ith iteration of outer loop first ith items are in place
		int min = 0;
		for(int i=0; i < A.length - 1; i++)
		{
			min = i;
			for(int j = i+1; j < A.length; j++)
			{
				if(A[j] < A[min])
				{
					min = j;
				}
			}
			int temp = A[i];
			A[i] = A[min];
			A[min] = temp;
		}
	}
	
	public static void BubbleSort(int[] A)
	{
		//Invariant: After ith iteration the last ith elements are in place
		for(int i=0; i<A.length -1; i++)
		{
			for(int j=0; j < A.length -(1 +i); j++)
			{
				if(A[j+1] < A[j])
				{
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
	}

}
