package RandomGenerate.com.random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Category {
	private String title;
	private String code;
	List<subCategory> subCategories;

	public void generate(LinkedList<String> titles, LinkedList<String> codes) {
		title = titles.get(0);
		titles.remove(0);
		code = codes.get(0);
		codes.remove(0);
		Random random = new Random();
		int length = random.nextInt(50)+50;
		subCategories = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			subCategories.add(new subCategory(titles, codes));
		}
	}

	public class subCategory {
		public String title;
		public String code;

		public subCategory() {

		}

		public subCategory(LinkedList<String> titles, LinkedList<String> codes) {
			title = titles.get(0);
			titles.remove(0);
			code = codes.get(0);
			codes.remove(0);
		}
	}

	public List<List<String>> getValueList() {
		List<List<String>> ValueList = new ArrayList<>();
		for (subCategory subCategory : subCategories) {
			List<String> list = new ArrayList<>();
			list.add(code);
			list.add(title);
			list.add(subCategory.code);
			list.add(subCategory.title);
			ValueList.add(list);
		}
		return ValueList;
	}

	public String toString() {
		String output = "";
		for (subCategory subCategory : subCategories) {
			output += code + "," + title + "," + subCategory.title + "," + subCategory.code + "\n";
		}
		return output;
	}
}