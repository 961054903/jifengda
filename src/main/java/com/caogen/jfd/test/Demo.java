package com.caogen.jfd.test;

import java.math.BigInteger;


import com.caogen.jfd.common.Constants;
import com.caogen.jfd.entity.driver.*;
import com.caogen.jfd.entity.user.AppUserPath;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.util.SecretUtils;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static com.caogen.jfd.entity.driver.Peservation.Mode.appoint;

public class Demo {
	Gson gson = new Gson();
	String a_str = "91064C3F2C35D2ACAF41A30F79A976C2299B411E8B8923F0AB2643F80DCBC42F";
	BigInteger g = new BigInteger(Constants.DH_G, 16);
	BigInteger p = new BigInteger(Constants.DH_P, 16);
	BigInteger a = new BigInteger(a_str, 16);

	String iv = "DCCD5BE9";
	String key = "6781B073D2CC775F304A133D";

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
		String result = "466179735A7A343241705369345464414C59734754366A67632B30425230336D4B6C72776D4B616C2F2F42776D7A4A666549332B49714445667A4363563634585A493654506830677A6B64304E6455333147617972734F6A4D6A415777506748566734303332303647305156706647707244526158786B4B30314233766B486770763446477A46765235467A55594F656743386E52626B45756D6B382F4D63502B777A692B4D374F32534A2F67414F3972336E2B4B6F315831784737393870466F7533597852584F7745394D6668372F396F706B75574E365775656862773954677144345A30646F7530594674527032302F72334246754D6E426D514476654E5748706B457448612B306D7838355772646B6A2F734378666D7341734C31344546766C6A3344654A673759742F2B36676A6E364E6474644E5470474B2F734242784A7A695368696439616A4E61616D5842704E553067474655503173556376612B78656670546B4F345469492B396574336A6237492F6162414957784530326D69505A66776C5A4831354C34776C685153364336724A64587265614C553762704F764F634A355A364A7A68696A7A4845455A724263656337693742355650584C76493053616A3268784C6C30506765705464696A42773D3D";
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
		AppDriver entity = new AppDriver();
		entity.setId(2);
		entity.setPassword("123456");
		String json = gson.toJson(entity);
		System.out.println(json);
		String result = SecretUtils.desedeEncode(json, key, iv);
		System.out.println(result);

	}

	@Test
	public void test3() throws Exception {
		String str = "tHLAHjw11c3LoQxCrV8FPbJQ6RLjLnZMnMIc8dY/0HOma/heCcDaYptpIIRoXXbAE2BrxH+uJDxws0syooCuF7yBPvl+4fWGMOUSw5Kq+2JfeNiv6VXaTNCl+Dq52SlbWEylNOlyUA28i8uqwaHPejG/FmpCRuoqGADJvogB1a2YUk08Xq2Py1E0JtJlvhJwXTrhyEy+LftrdjER9P4KsQ=="+
				"";
		System.out.println(SecretUtils.desedeDecode(str, key, iv));
	}

}
