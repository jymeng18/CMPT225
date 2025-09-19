package generics;

import comparableclasses.Point;

class MyArray <E> {

	protected E[] array;
	
	public MyArray(E[] a) {
		array = a;
	}

	public int getSize() {
		return array.length;
	}
	
	public E get(int i) 	{
		if (i < array.length)
			return array[i];
		else {
			String errorMessage = new String("array.length = "
					+ array.length + " Tried to access array[" +i+ "]");
			throw new IndexOutOfBoundsException(errorMessage);
		}
	}

	
	public void set(int i, E elt) {
		if (i>=0 && i < array.length)
			array[i] = elt;
		else {
			String errorMessage = new String("array.length = " + array.length
					+ " Tried to access array[" + i + "]");
			throw new IndexOutOfBoundsException(errorMessage);
		}
	}
	

	public void printMyArray()	{
		for (int i = 0; i < getSize() ; i++)
			System.out.println(array[i]);
	}
	
	
	public static void main(String[] args) {
		Point[] array =new Point[5];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new Point(i+1, i*2);
		}
		
		System.out.println("printing myArrayOfPoints:");
		MyArray<Point> myArrayOfPoints = new MyArray<Point>(array);
		myArrayOfPoints.printMyArray();


		System.out.println("printing myArrayOfIntegers:");
		Integer intsArray[] = {1,2,3,5};
		MyArray<Integer> myArrayOfIntegers = new MyArray<Integer>(intsArray);  
		myArrayOfIntegers.printMyArray();


	}
}

