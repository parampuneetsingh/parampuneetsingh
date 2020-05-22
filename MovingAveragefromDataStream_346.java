import java.util.LinkedList;

//https://www.lintcode.com/problem/moving-average-from-data-stream/

public class MovingAveragefromDataStream_346 {

	LinkedList<Double> list;
	double total = 0;
	int size = 0;

	public MovingAveragefromDataStream_346(int size) {
		list = new LinkedList<Double>();
		this.size = size;
	}

	public double next(int val) {
		double t = (double) val;

		if (list.size() == size) {
			double lastVal = list.poll();
			total -= lastVal;
		}

		list.add(t);
		total += t;

		return total / list.size();
	}

	public static void main(String[] args) {
		MovingAveragefromDataStream_346 average = new MovingAveragefromDataStream_346(3);
		System.out.println(average.next(1));
		System.out.println(average.next(10));
		System.out.println(average.next(3));
		System.out.println(average.next(5));
	}

}
