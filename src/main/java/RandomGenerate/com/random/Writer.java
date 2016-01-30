package RandomGenerate.com.random;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 * Hello world!
 *
 */
public class Writer {

	public final static int categorySize = 1000;
	public final static int productSize = 10000;
	public final static int providerSize = 10000;

	public static CSVPrinter GetCSVPrinter(String[] headers, String filename) {
		CSVFormat format = CSVFormat.DEFAULT.withHeader(headers).withSkipHeaderRecord();
		CSVPrinter csvFilePrinter = null;
		try {
			FileWriter fileWriter = new FileWriter(filename);
			csvFilePrinter = new CSVPrinter(fileWriter, format);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csvFilePrinter;
	}

	/**
	 * 
	 * @param length
	 *            Map<String,String>, code, category name
	 * @return
	 */
	public static Map<String, String> getStringCodePool(int length) {
		Map<String, String> codePool = new HashMap<>();
		for (int i = 0; i < length; i++) {
			codePool.put(Randoms.RandomString(6), Randoms.RandomString(10));
		}
		return codePool;
	}

	public static void main(String[] arg) {
		String csvOneHeader[] = { "CATEGORY-CODE", "CATEGORY-TITLE", "SUB-CATEGORY-CODE", "SUB-CATEGORY-TITLE" };
		String csvTwoHeader[] = { "PRODUCT-ID", "PROVIDER-ID", "PRODUCT-TITLE", "PRODUCT-INFO" };
		String csvThreeHeader[] = { "PROVIDER-ID", "PROVIDER-INFO", "PROVIDER-CONTACT", "PROVIDER-LOCATION" };

		// generate category
		Map<String, String> codePool = getStringCodePool(categorySize * 100);
		LinkedList<String> codes = new LinkedList(codePool.keySet());
		LinkedList<String> names = new LinkedList(codePool.values());

		List<List<String>> allCategories = new ArrayList<>();
		for (int i = 0; i < categorySize; i++) {
			Category category = new Category();
			category.generate(names, codes);
			allCategories.addAll(category.getValueList());
		}
		CSVPrinter csvPrinter = GetCSVPrinter(csvOneHeader, "category.csv");
		for (List<String> list : allCategories) {
			try {
				csvPrinter.printRecord(list);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			csvPrinter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// generate provider
		List<Integer> providersIdList = new ArrayList<>();
		LinkedList<Integer> list = Randoms.RandomIds(providerSize * 2);
		csvPrinter = GetCSVPrinter(csvThreeHeader, "provider.csv");
		for (int i = 0; i < providerSize; i++) {
			Provider provider = new Provider(list);
			providersIdList.add(provider.getId());
			try {
				csvPrinter.printRecord(provider.getList());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			csvPrinter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// generate product
		Random random = new Random();
		csvPrinter = GetCSVPrinter(csvTwoHeader, "product.csv");
		Set<String> productIds = new HashSet<>();
		for (List<String> categoryList : allCategories) {
			int productLengthInSubCategory = random.nextInt(5) + 5;
			for (int i = 0; i < productLengthInSubCategory; i++) {
				Product product = new Product();
				int providerId = providersIdList.get(random.nextInt(providersIdList.size()));
				String productId = product.generate(categoryList, providerId);
				if (!productIds.contains(productId)) {
					productIds.add(productId);
					try {
						csvPrinter.printRecord(product.getList());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		try {
			csvPrinter.close();
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
