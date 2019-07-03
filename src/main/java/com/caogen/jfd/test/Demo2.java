package com.caogen.jfd.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.entity.user.AppUserOrder;
import com.caogen.jfd.entity.user.AppUserOrder.Mode;
import com.caogen.jfd.entity.user.AppUserOrder.Type;
import com.caogen.jfd.entity.user.AppUserSite;
import com.caogen.jfd.model.Distance;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.util.HttpClientUtils;
import com.caogen.jfd.util.PasswordHelper;
import com.caogen.jfd.util.SecretUtils;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class Demo2 {
	Gson gson = new Gson();
	String a_str = "91064C3F2C35D2ACAF41A30F79A976C2299B411E8B8923F0AB2643F80DCBC42F";
	BigInteger g = new BigInteger(Constants.DH_G, 16);
	BigInteger p = new BigInteger(Constants.DH_P, 16);
	BigInteger a = new BigInteger(a_str, 16);

	String iv = "561E8E40";
	String key = "831FED5145408095DFB0764A";

	@Test
	public void signinReq() throws Exception {
		String A = g.modPow(a, p).toString(16).toUpperCase();
		Signin s = new Signin();
		s.setPhone("17610611351");
		s.setResult(A);
		String text = gson.toJson(s);
		System.out.println(text);
		String pi = SecretUtils.desedeEncode(text, Constants.DES_KEY, Constants.DES_IV);
		System.out.println(pi);
	}

	@Test
	public void signinRes() throws Exception {
		String result = "466179735A7A343241705369345464414C59734754366A67632B30425230336D4B6C72776D4B616C2F2F42737875306457724133427859765955554A6354727949713071444F386248355A466263363639784D39684C37716B76563558343556797A3747724D477462782F7452767438557A524774616B643848637474374B32777643724A6C703876437459667A364353682F57434476594E7671736E722F596B3566423761353045444C375977644977456174656F6872726D556A4A7834344D44525A43774B7A374B70784F31654958492B4D443353694D433365512B78414C687074333538513739675A79477269514C774C467346787757624832577A6F7138586B6856716450536539764C4E7575323254726178445A3877516A54374F7032433250697475756B345747424C696E5170376F4A4979343870704E5571705A5A6155342F61484C757673416156417871433145462F4C56317A584A4D623267342F4F34366D7530684C4B66525962387171382B6A507A4A55686935714278357650785A4C4C776961474649303249514844447978344E33374235466D73334F6D374C525553483671773147413342747233496334494A554D6666615178564363576E4A2B6D796B4A655655437A785A316A5558773D3D";
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
		AppUserSite site3 = new AppUserSite();
		site3.setLongitude(115.481028);
		site3.setLatitude(39.989643);

		ArrayList<AppUserSite> list = new ArrayList<AppUserSite>();
		list.add(site1);
		list.add(site2);
//		list.add(site3);

		AppUserOrder entity = new AppUserOrder("17610611351");
		entity.setModel_id(1);
		entity.setType(Type.multiple);
		entity.setMode(Mode.appoint);
		entity.setOrigin(gson.toJson(site));
		entity.setDestination(gson.toJson(list));
		entity.setName("洗衣粉");
		entity.setNight_service_cost(0.0);
		entity.setTraffic_jam_cost(0.0);
		entity.setIs_support(true);
		entity.setSupport_money(1000.0);
		entity.setSupport_cost(10.0);
		entity.setOrder_money(100.0);
		entity.setTicket_money(10.0);
		entity.setActually_paid(100.0);
		entity.setKilometre(10.0);
		entity.setBonus(50.0);

		String json = gson.toJson(entity);
		System.out.println(json);
		String result = SecretUtils.desedeEncode(json, key, iv);
		System.out.println(result);
	}

	@Test
	public void encode() throws Exception {
		AppUserOrder entity = new AppUserOrder("17610611351");
		entity.setCode("4");
		String json = gson.toJson(entity);
		System.out.println(json);
		String result = SecretUtils.desedeEncode(json, key, iv);
		System.out.println(result);
	}

	@Test
	public void decode() throws Exception {
		String str = "NLrVPlzCQvpQs3vRWtoGXOfQ6RODM1LyUYB3EDIUS5/yY2/kXkWtM/a7PL8b8+5d3T0I00j0+ozGRcYK2JnKjxjqx51s2BC744ou9NtNntfWa3/hDIoKIseP3+hbGbMk";
		System.out.println(SecretUtils.desedeDecode(str, key, iv));
	}

	@Test
	public void test4() {
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

	@Test
	public void test6() {
		String str = "[\"临沂\",\"济南\"]";
		String[] a = Constants.gson.fromJson(str, String[].class);
		System.out.println(Arrays.toString(a));
	}
}
