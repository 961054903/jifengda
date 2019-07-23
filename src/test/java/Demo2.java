
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.caogen.jfd.common.Constants;
import com.caogen.jfd.entity.AppUserOrder;
import com.caogen.jfd.entity.AppUserOrder.Mode;
import com.caogen.jfd.entity.AppUserOrder.Type;
import com.caogen.jfd.entity.AppUserSite;
import com.caogen.jfd.model.Distance;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.util.HttpClientUtils;
import com.caogen.jfd.util.PasswordHelper;
import com.caogen.jfd.util.SecretUtils;
import com.google.gson.Gson;
import org.junit.Test;

public class Demo2 {
	Gson gson = new Gson();
	String a_str = "91064C3F2C35D2ACAF41A30F79A976C2299B411E8B8923F0AB2643F80DCBC42F";
	BigInteger g = new BigInteger(Constants.DH_G, 16);
	BigInteger p = new BigInteger(Constants.DH_P, 16);
	BigInteger a = new BigInteger(a_str, 16);

	String iv = "3F0D69BD";
	String key = "7063800F89EA418EBC7BA8EA";

	@Test
	public void signinReq() throws Exception {
		String A = g.modPow(a, p).toString(16).toUpperCase();
		Signin s = new Signin();
		s.setResult(A);
		String text = gson.toJson(s);
		System.out.println(text);
		String pi = SecretUtils.desedeEncode(text, Constants.DES_KEY, Constants.DES_IV);
		System.out.println(pi);
	}

	@Test
	public void signinRes() throws Exception {
		String result = "N8IWb81EvDBnWbyW8aKtPtrmCdlusXoLrm4KCXQNFIYuY98Pms1rLAB3UxVSNF0LojvmnepIUatGJMuC+aU6R3Si+0CFa+nQXwHboISgBCGZbpdh7i23WlBfXp9LFq4eQXhYTrMtthuSNAUjGZLAvpJg1wVpQRpyRxiPs7TQaTYHNEjkRwhvGc3PiX8H49GwCNt8k1Dzbsabr7WlGcAgvQieEFEn4yBgBXO9KUmcGhg5kuY6QJFJPxkdhvN/iLMkyCHH0sZLZthjp63NNC61fHxD3JyHNy8AUCf3SOsJgHazu2jiwkYKZyqKkZeh09jT4ZmpvMsfTzJMsxUABcCmemHLkWvzoy0hQriqm0aHaiekhA2/vQbwoSx4m/PXHu+dTRtBERcWx+k9DH/8AxsEDOQUqNLhJ/1b";
		String en = SecretUtils.desedeDecode(result, Constants.DES_KEY, Constants.DES_IV);
		System.out.println(en);
		Signin s = new Gson().fromJson(en, Signin.class);
		BigInteger B = new BigInteger(s.getResult(), 16);
		String res = B.modPow(a, p).toString(16).toUpperCase();
		String iv = res.substring(0, 8);
		String key = res.substring(8, 32);
		System.out.println("iv=" + iv);
		System.out.println("key=" + key);
	}

	@Test
	public void test2() throws Exception {
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

		AppUserOrder entity = new AppUserOrder();
		entity.setCity("临沂");
		entity.setModel_id(3);
		entity.setMode(Mode.appoint);
		entity.setAppoint_date(LocalDateTime.now());
		entity.setType(Type.multiple);
		entity.setOrigin(
				"{\"name\":\"发货地点\",\"longitude\":114.465302,\"latitude\":40.004717,\"contacts_name\":\"张三\",\"contacts_phone\":\"123456789\"}");
		entity.setDestination(
				"[{\"name\":\"收货地点2\",\"longitude\":114.481028,\"latitude\":39.989643,\"contacts_name\":\"王五\",\"contacts_phone\":\"123456789\"},{\"name\":\"收货地点1\",\"longitude\":116.481028,\"latitude\":39.989643,\"contacts_name\":\"李四\",\"contacts_phone\":\"123456789\"}]");
		entity.setNight_cost(0.0);
		entity.setJam_cost(30.0);
		entity.setEmpty_cost(10.0);
		entity.setOrder_money(20127.96);
		entity.setKilometer(385.466);
		entity.setGap("102313|283153|");
		entity.setIs_support(true);
		entity.setSupport_money(10000.0);
		entity.setSupport_cost(1000.0);
		entity.setActually_paid(0.01);
		entity.setTicket_money(5.0);
		entity.setName("白菜");

		String json = Constants.gson.toJson(entity);
		System.out.println(json);
//		String result = SecretUtils.desedeEncode(json, key, iv);
//		System.out.println(result);
	}

	@Test
	public void encode() throws Exception {
		AppUserOrder entity = new AppUserOrder();
		entity.setCode("1");
		entity.setEvaluate_grade(100);
		entity.setEvaluate_content("yyyyyy");
		System.out.println(Constants.gson.toJson(entity));
		// String result = SecretUtils.desedeEncode(json, key, iv);
		// System.out.println(result);
	}

	@Test
	public void decode() throws Exception {
		String str = "NLrVPlzCQvpQs3vRWtoGXOfQ6RODM1LyUYB3EDIUS5/yY2/kXkWtM/a7PL8b8+5d3T0I00j0+ozGRcYK2JnKjxjqx51s2BC744ou9NtNntfWa3/hDIoKIseP3+hbGbMk";
		System.out.println(SecretUtils.desedeDecode(str, key, iv));
	}

	@Test
	public void gdMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", Constants.GD_KEY);
		map.put("type", Constants.GD_DISTANCE_TYPE);
		map.put("origins", "116.481028,39.989643|114.481028,39.989643|115.481028,39.989643|");
		map.put("destination", "114.465302,40.004717");
		try {
			String result = HttpClientUtils.doGet(Constants.GD_DISTANCE_URL, map);
			System.out.println(result);
			Distance dis = Constants.gson.fromJson(result, Distance.class);
			System.out.println(dis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pwd() {
		String pwd = "111111";
		String salt = PasswordHelper.generateSalt();
		System.out.println(salt);
		System.out.println(PasswordHelper.encryptPassword(pwd, salt));
	}
}
