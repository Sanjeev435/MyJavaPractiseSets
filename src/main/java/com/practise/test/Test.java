package com.practise.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


/*import java.io.FileNotFoundException;
import java.io.IOException;

class A
{
����static
����{
��������System.out.println("THIRD");
����}
}
�
class B extends A
{
����static
����{
��������System.out.println("SECOND");
����}
}
�
class C extends B
{
����static
����{
��������System.out.println("FIRST");
����}
}
�
public class Test
{
����public static void main(String[] args)
����{
��������C c = new C();
����}
}
class a{
	int i = 10;
	Test t = new Test();
	
	 void printthis(){
		System.out.println("THIRD");
	}
}
class b  implements Runnable{
	//static{System.out.println("SECOND");}
	int i = 20;
	boolean suspended = false;
	private Thread t = new Thread(this,"b");
	private Thread t1 = new Thread(this,"c");
	private Thread t2 = new Thread(this,"d");
	b(){
		 t.start();
		 t1.start();
		 t2.start();

	}
	
	 
	 @Override
		public void run() {
			//System.out.println("Thread" + Thread.currentThread().getName());
			try {
				printthis();
			} catch (ArithmeticException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					}
	 
	synchronized  void  printthis() throws ArithmeticException, InterruptedException{
			System.out.println("Thread" + Thread.currentThread().getName());

			while(suspended) {
                wait();
             }

		//	notify();
			System.out.println("Thread after sleep" + Thread.currentThread().getName());

			String abc ="";
			System.out.println("SECOND");
			
			
		}
	 void suspend() {
	      suspended = true;
	   }
	synchronized void resume() {
	     // suspended = false;
	      notify();
	      System.out.println("Thread in resume" + Thread.currentThread().getName());
 
	   }

	

}
class c extends b{
	//static{System.out.println("FIRST");}
	int i = 30;
	 void printthis() throws NullPointerException{
		System.out.println("FIRST");
	//	throw new NullPointerException();
	}
}

public class Test{
	public static void main(String[] args) throws ArithmeticException, InterruptedException {
		b  c = new b();
	//	System.out.println(c.i);;
	//	c.printthis();
		
	}

	
}

SQLException, 
IOException, 
ClassNotFoundException
NullPointerException, 
ArithmeticException ArrayIndexOutOfBoundsException.
*/

/*class RunnableDemo implements Runnable {
   public Thread t;
   private String threadName;
   boolean suspended = false;

   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 10; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(300);
            synchronized(this) {
               while(suspended) {
                  wait();
               }
            }
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
   
   void suspend() {
      suspended = true;
   }
   
   synchronized void resume() {
      suspended = false;
      notify();
   }
}

public class Test {

   public static void main(String args[]) {

      RunnableDemo R1 = new RunnableDemo( "Thread-1");
      R1.start();

      RunnableDemo R2 = new RunnableDemo( "Thread-2");
      R2.start();

      try {
         Thread.sleep(1000);
         R1.suspend();
         System.out.println("Suspending First Thread");
         Thread.sleep(1000);
         R1.resume();
         System.out.println("Resuming First Thread");
         
         R2.suspend();
         System.out.println("Suspending thread Two");
         Thread.sleep(1000);
         R2.resume();
         System.out.println("Resuming thread Two");
      }catch (InterruptedException e) {
         System.out.println("Main thread Interrupted");
      }try {
         System.out.println("Waiting for threads to finish.");
         R1.t.join();
         R2.t.join();
      }catch (InterruptedException e) {
         System.out.println("Main thread Interrupted");
      }
      System.out.println("Main thread exiting.");
   }*/

public class Test implements Comparator<Test>{
	int a;
	Test(int d){
		a = d;
	}
	
	public int compare(Test y, Test k){
		return k.a-y.a;
	}
	public static void main(String[] args) {
		/*System.out.println(check("[()]"));   // true
		System.out.println(check("(()[])")); // true
		System.out.println(check("([)]"));   // false
		System.out.println(check("(("));     // false
		System.out.println(check("[(()])")); // false

		System.out.println(check("([(([[(([]))]]))])"));   // true
		System.out.println(check("[](()()[[]])()[]([])")); // true
		System.out.println(check("([((([(([]))])))))])")); // false
		System.out.println(check("[](()()[[]])[][[([])")); // false
		
*/	
		/*double d =10.0/-0;
			if(d== Double.POSITIVE_INFINITY){
				System.out.println("fdfdfds");
			}
			else{
				System.out.println("dfffdf");
			}*/
		
		/*PriorityQueue<String> d = new PriorityQueue<String>();
		d.add("dis");
		d.add("lau");
		d.add("bills");
		d.offer("bills");
		
		System.out.println(d.size()+d.poll());
		System.out.println(d.peek()+d.poll());
		System.out.println(d.poll()+d.poll());*/
		
		int gg = 10;
		int ggg = 11;
		System.out.println(18/9);
		if(gg>ggg)System.out.println(gg);
		else System.out.println(ggg);
		
		
		Test[] ab ={new Test(40),new Test(200),new Test(60)};
		Arrays.sort(ab, ab[0]);
		int index = Arrays.binarySearch(ab,  new Test(40), ab[0]);
		System.out.println(index+" ");
		index = Arrays.binarySearch(ab,  new Test(80), ab[0]);
		System.out.println(index);
		
		
	
	}
	
	/*public static boolean check(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	// ([(([[(([]))]]))])
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}
	
	private static boolean sortInteger(int[] aint){
		Arrays.sort(aint);;
		Arrays.stream(array, startInclusive, endExclusive)asList(spam);
		List<int[]> ab =  Arrays.asList(aint);
		List<Integer> a = new ArrayList<Integer>();
		return false;
	}*/
}



