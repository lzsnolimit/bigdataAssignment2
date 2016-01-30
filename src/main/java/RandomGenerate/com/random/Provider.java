package RandomGenerate.com.random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Provider {
	int id;
	String info;
	String contact;
	String location;

	public Provider(LinkedList<Integer> list) {
		id =list.get(0);
		list.remove(0);
		info = Randoms.RandomString();
		contact = Randoms.randomPhoneNumber();
		location = Randoms.randomLocation();
		// TODO Auto-generated constructor stub
	}

	public List<String> getList() {
		List<String> out = new ArrayList<>();
		out.add(String.valueOf(id));
		out.add(info);
		out.add(contact);
		out.add(location);
		return out;
	}
	
	public int getId()
	{
		return id;
	}
}
