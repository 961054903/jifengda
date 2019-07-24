import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.entity.AppUserPath;
import com.caogen.jfd.entity.AppUserSite;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Demo {
	@Test
	public void test() {
		String json = "{\"transaction_id\":\"4200000357201907187560340205\",\"nonce_str\":\"fb207570a688480ab62809138ddd5796\",\"bank_type\":\"CFT\",\"openid\":\"oMaNSw_M81VEao48n9-ZANnMEGWU\",\"fee_type\":\"CNY\",\"mch_id\":\"1487406822\",\"cash_fee\":\"1\",\"out_trade_no\":\"67478EF1631A47BFB32C1BA955C78672\",\"appid\":\"wx3c8ca807138bfa30\",\"total_fee\":\"1\",\"trade_type\":\"APP\",\"result_code\":\"SUCCESS\",\"time_end\":\"20190718084005\",\"is_subscribe\":\"N\",\"return_code\":\"SUCCESS\"}";
		Map<String, String> map = new Gson().fromJson(json, new TypeToken<Map<String, String>>() {
		}.getType());
		System.out.println(map);
	}

	@Test
	public void test1() {
		AppUserSite entity = new AppUserSite();
		entity.setLongitude(12.345678);
		entity.setLatitude(23.456789);
		entity.setId(26);
		entity.setName("草根快递1");
		entity.setDescription("描述1");
		entity.setContacts_name("vhis");
		entity.setContacts_phone("666666");
		System.out.println(Constants.gson.toJson(entity));
	}

	@Test
	public void test2() {
		AppUserSite site = new AppUserSite();
		site.setLongitude(114.465302);
		site.setLatitude(40.004717);
		site.setName("发货地点");
		site.setContacts_name("张三");
		site.setContacts_phone("123456789");
		AppUserSite site1 = new AppUserSite();
		site1.setLongitude(116.481028);
		site1.setLatitude(39.989643);
		site1.setName("收货地点1");
		site1.setContacts_name("李四");
		site1.setContacts_phone("123456789");
		AppUserSite site2 = new AppUserSite();
		site2.setLongitude(114.481028);
		site2.setLatitude(39.989643);
		site2.setName("收货地点2");
		site2.setContacts_name("王五");
		site2.setContacts_phone("123456789");
		ArrayList<AppUserSite> list = new ArrayList<AppUserSite>();
		list.add(site1);
		list.add(site2);
		AppUserPath path = new AppUserPath();
		path.setId(123);
		String json = Constants.gson.toJson(path);
		System.out.println(json);
	}

}
