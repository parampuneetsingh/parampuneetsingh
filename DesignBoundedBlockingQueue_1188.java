import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//https://www.geeksforgeeks.org/reentrant-lock-java/
//https://www.codejava.net/java-core/concurrency/java-synchronization-tutorial-part-2-using-lock-and-condition-objects
	
public class DesignBoundedBlockingQueue_1188 {

	static class BoundedBlockingQueue {

	    private int[] data;
	    private int head, tail, size;

	    private final ReentrantLock lock;
	    private Condition canPoll;
	    private Condition canOffer;

	    public BoundedBlockingQueue(int capacity) {
	        this.size = capacity + 1;
	        this.head = 0;
	        this.tail = 0;
	        data = new int[capacity + 1];

	        lock = new ReentrantLock();
	        canPoll = lock.newCondition();
	        canOffer = lock.newCondition();
	    }

	    public void enqueue(int element) throws InterruptedException {
	        lock.lock();
	        try{
	            while(next(tail) == head) {
	            	canOffer.await();	
	            }
	            data[tail] = element;
	            tail = next(tail);
	            canPoll.signal();
	        } finally{
	            lock.unlock();
	        }
	    }

	    public int next(int x) { 
	    	return (x + 1) % size;
	    }

	    public int dequeue() throws InterruptedException {
	        lock.lock();
	        try{
	            while (tail == head) canPoll.await();
	            int result = data[head];
	            head = next(head);
	            canOffer.signal();
	            return result;
	        } finally {
	            lock.unlock();
	        }
	    }

	    public int size() {
	        return head <= tail ? tail - head : tail + size - head;
	    }

	public static void main(String[] args) {
		System.out.println("Blocking Queue Problem");
	}
	}

}
