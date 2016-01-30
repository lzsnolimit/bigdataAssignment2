package RandomGenerate.com.random;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int providerId;
	private String productId;
	private String productTitle;
	private String productInfo;

	public String generate(List<String> category, int providerId) {
		productId = category.get(0) + "-" + category.get(2) + "-" + providerId;
		this.providerId=providerId;
		productTitle = Randoms.RandomString();
		productInfo = Randoms.RandomString();
		return productId;
	}

	public List<String> getList() {
		List<String> out = new ArrayList<>();
		out.add(productId);
		out.add(String.valueOf(providerId));
		out.add(productTitle);
		out.add(productInfo);
		return out;
	}
}
