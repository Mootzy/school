
public class sortingTesting
{

	public static void main( String[ ] args )
	{
		int intArr[] = { 12, 11, 13, 5, 6 };

		insertionSort ( intArr );
		printArray ( intArr );

		spacingForArrays();

		bubbleSort ( intArr );
		printArray ( intArr );

		spacingForArrays();

		selectionSort ( intArr );
		printArray ( intArr );

		spacingForArrays();

		shellSort ( intArr );
		printArray ( intArr );

	}

	/* Function to sort array using insertion sort */
	public static void insertionSort( int arr[] )
	{
		int n = arr.length;
		for ( int i = 1; i < n; ++i )
		{
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
			 */
			while ( j >= 0 && arr[j] > key )
			{
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

	}
	// function to sort array using shellSort
	static int shellSort( int arr[] )
	{
		int n = arr.length;

		// Start with a big gap, then reduce the gap

		for ( int gap = n / 2; gap > 0; gap /= 2 )
		{
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted

			for ( int i = gap; i < n; i += 1 )
			{
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i

				int temp = arr[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found

				int j;
				for ( j = i; j >= gap && arr[j - gap] > temp; j -= gap )
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location

				arr[j] = temp;
			}
		}
		return 0;
	}
	/**
	 * function to sort array using bubble sort
	 * @param arr
	 */
	static void bubbleSort( int arr[] )

	{
		int n = arr.length;
		for ( int i = 0; i < n - 1; i++ )
			for ( int j = 0; j < n - i - 1; j++ )
				if ( arr[j] > arr[j + 1] )
				{
					// swap arr[j+1] and arr[j]

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}
	/**
	 * function to sort array using selection sort
	 * @param arr
	 */
	static void selectionSort( int arr[] )
	{
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for ( int i = 0; i < n - 1; i++ )
		{
			// Find the minimum element in unsorted array
			int min_idx = i;
			for ( int j = i + 1; j < n; j++ )
				if ( arr[j] < arr[min_idx] )
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
	/**
	 * function for spacing and stars inbetween array
	 */
	static void spacingForArrays( )
	{

		System.out.println ( "*************************" );
		System.out.println ( "************************* \n" );
	}
	/**
	 * function to print arrays2
	 * @param arr
	 */
	static void printArray( int arr[] )
	{
		int n = arr.length;
		for ( int i = 0; i < n; i++ )
		{
			System.out.println ( arr[i] );
			System.out.println ( );

		}
	}
}
