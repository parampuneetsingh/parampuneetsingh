import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/find-duplicate-file-in-system/

public class FindDuplicateFileinSystem_609 {

	public static List<List<String>> findDuplicate(String[] paths) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> list = new ArrayList<List<String>>();

		for (String path : paths) {
			String[] pathTokens = path.split(" ");
			String directory = pathTokens[0];
			for (int i = 1; i < pathTokens.length; i++) {
				String temp = pathTokens[i];

				String[] splitContent = temp.split("\\(");
				String fileName = splitContent[0];
				String content = splitContent[1].split("\\)")[0];

				List<String> l = map.getOrDefault(content, new ArrayList<String>());
				l.add(directory + "/" + fileName);

				map.put(content, l);
			}
		}

		for (String key : map.keySet()) {
			if (map.get(key).size() > 1) {
				list.add(map.get(key));
			}
		}

		return list;
	}

	public static void main(String[] args) {
		String[] paths = { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
				"root 4.txt(efgh)" };
		System.out.println(findDuplicate(paths));
	}

}
