public class ArrayStack<T> implements Stack<T>{
	public T[] a = (T[]) new Object[10];
	public int top = -1;

	public void push(T item){
		if(top+1 == a.length){
			grow_array();
		}else{
			a[++top] = item;
		}
		//System.out.println("top: "+top);
	}

	public T pop() 
	{
		/*
		if(empty()){
			//throw new Exception("");
		}else{
			int temp = top;
			System.out.println("poppedd: "+a[temp]);
			top--;
			return a[temp];
		}
		*/
		int temp = top;
		//System.out.println("poppedd: "+a[temp]);
		top--;
		return a[temp];

	}

	public T peek() 
	{
		/*
		if(empty()){
			//throw new Exception("");
		}else{
			return a[top];
		}
		*/
		return a[top];
	}

	public boolean empty(){
		//System.out.println(top);
		if (top == -1){
			return true;
		}else{
			return false;
		}
	}

	private void grow_array(){
		//System.out.println("grew");
		int len = a.length;
		T[] new_a = (T[]) new Object[len*2];
		for(int i = 0 ; i<len ; i++){
			new_a[i] = a[i];
		}
		a = new_a;
		top++;
	}
}	