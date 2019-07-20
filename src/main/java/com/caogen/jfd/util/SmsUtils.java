package com.caogen.jfd.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.caogen.jfd.common.Constants;

/**
 * 阿里云短信
 * 
 * @author Spuiln
 *
 */
public class SmsUtils {
	private static final String regionId = "default";
	private static final String accessKeyId = "LTAIUV7JNcdlBDTB";
	private static final String accessKeySecret = "xwDvFZ3VU54rY5lfRJIPg6IoHikgtI";

	private static DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
	private static IAcsClient client = new DefaultAcsClient(profile);

	/**
	 * 发送验证码
	 * 
	 * @param phone 手机号
	 * @param code  验证码
	 * @return
	 * @throws ServerException
	 * @throws ClientException
	 */
	public static boolean sendSms(String phone, String code) throws ServerException, ClientException {
		String str = "{\"code\":\"" + code + "\"}";
		return sendSms(phone, Constants.SMS_SIGN_NAME, Constants.SMS_TEMPLATE_CODE, str);
	}

	public static boolean sendSms(String phone, String sign, String template, String param)
			throws ServerException, ClientException {
		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("PhoneNumbers", phone);
		request.putQueryParameter("SignName", sign);
		request.putQueryParameter("TemplateCode", template);
		request.putQueryParameter("TemplateParam", param);
		CommonResponse response = client.getCommonResponse(request);
		AliSms entity = Constants.gson.fromJson(response.getData(), AliSms.class);
		return entity.getMessage().equals("OK");
	}

	public class AliSms {
		private String Message;
		private String RequestId;
		private String BizId;
		private String Code;

		@Override
		public String toString() {
			return "AliSms [Message=" + Message + ", RequestId=" + RequestId + ", BizId=" + BizId + ", Code=" + Code
					+ "]";
		}

		public String getMessage() {
			return Message;
		}

		public void setMessage(String message) {
			Message = message;
		}

		public String getRequestId() {
			return RequestId;
		}

		public void setRequestId(String requestId) {
			RequestId = requestId;
		}

		public String getBizId() {
			return BizId;
		}

		public void setBizId(String bizId) {
			BizId = bizId;
		}

		public String getCode() {
			return Code;
		}

		public void setCode(String code) {
			Code = code;
		}

	}
}
