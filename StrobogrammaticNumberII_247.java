import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII_247 {

	char[][] mapping = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public void findCombination(char[] chs, int low, int high, List<String> res) {
		if (low > high) {
			if (chs.length == 1 || chs[0] != '0') {
				res.add(String.copyValueOf(chs));
			}
			return;
		}

		for (char[] map : mapping) {
			if (low == high && map[0] != map[1])
				continue;

			chs[low] = map[0];
			chs[high] = map[1];
			findCombination(chs, low + 1, high - 1, res);
		}

	}

	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<String>();
		if (n < 1) {
			res.add("");
			return res;
		}
		char[] chs = new char[n];
		findCombination(chs, 0, n - 1, res);
		return res;
	}

	public static void main(String[] args) {
		StrobogrammaticNumberII_247 num = new StrobogrammaticNumberII_247();
		System.out.println(num.findStrobogrammatic(1).toString());
	}

}
