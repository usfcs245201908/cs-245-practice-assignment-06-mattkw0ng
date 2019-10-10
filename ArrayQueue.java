public class ArrayQueue<T> implements Queue<T>{
	public T[] a = (T[]) new Object[10];
	public int first = 0;
	public int last =  -1;

	public T dequeue(){
		/*
		if(empty()){
			throw new Exception();
		}else{
			//System.out.println("first: " + first+" last: "+last);
			T item = a[first];
			first = (first+1)%a.length;
			//System.out.println("(after)first: " + first+" last: "+last);
			System.out.println("dequeued: "+item);
			return item;
		}
		*/
		T item = a[first];
		first = (first+1)%a.length;
		//System.out.println("(after)first: " + first+" last: "+last);
		//System.out.println("dequeued: "+item);
		return item;


	}
	public void enqueue(T item){
		int afterlast = (last+1)%a.length; //equal to the next index after the last, and if it is at the end of the array, it will equal zero
		int beforefirst = first -1;
		if(first == 0){
			beforefirst = a.length-1;
		}
		if(afterlast == beforefirst){	//if the front of the queue is one space away from the back to the queue it will grow the array
			grow_array();
		}
		afterlast = (last+1)%a.length;
		a[afterlast] = item;
		last = afterlast;
	}
	public boolean empty(){
		if(last-first == -1){
			return true;
		}else if(last==a.length-1&&first==0){
			return true;
		}else{
			return false;
		}
	}
	private void grow_array(){
		//System.out.println("grew"+first+last);
		int len = a.length;
		int index = 0;
		T[] new_a = (T[]) new Object[len*2];
		if(first > last){
			for(int i = first; i < a.length ; i++){
				new_a[index++] = a[i];
			}
			//System.out.println("grew");
			for(int j = 0 ; j <= last ; j++){
				new_a[index++] = a[j];
			}
			//System.out.println("grew");
		}else{
			for(int i = first ; i<=last ; i++){
				new_a[index++] = a[i];
			}
		}

		a = new_a;
		first = 0;
		last = index -1;
		//System.out.println("grew"+first+last);
		
	}
	
}