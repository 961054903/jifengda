package com.caogen.jfd.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.caogen.jfd.common.Constants;
import com.caogen.jfd.entity.AppUserOrder;
import com.caogen.jfd.service.AliPayService;

@Service
public class AliPayServiceImpl implements AliPayService {

	private static final String APP_ID = "2019070565783296";
	private static final String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC6vb7ufT7xMH3gPHHEvYCRC9OC+1L07DbZZVLifDEiJ5Mdg4eXRW9nm9G3Dx2GIHL+YF0/dNifZ7yKt3DVgC5ZomzDt6uoc/Sy5xFI8AZAl7JdOi48EzOxSDhNzs3DBBACEyhKnfkiqeiTm916MiaReS5HrHjRCgn5gu/FAP5qFF1KYehhdGdoGtTMahRv/Koir6lMU//pM4mq9IJF4nMCbdvX8kgabCDVwBXcXQpQ6jyIVi+VHhmAlnoHimqwpYjL1OTrC3ObizzVYA1hSsquqU9Qcqz485ZtiZ+gaYvgx5ZifDneCeTFleoNRlFTbGKkJktADLti7ouZFnheCqARAgMBAAECggEBALJ5nv34niuOGQAzRNiv9SyrjN9mrIaBLHriKDFmWN83y5ctmm2tYyg2+FxpCeKjKMSN/REk79SKJNy/Lgwfki0A28rCxEEfcgN6bD61iIQ7d7E6Ze3svD73szhKKsX0IAibnqqSCQZkNXC+SxL603m9w8mkwWOooJfj2J0EsiNW6R+7WDjKY7XWrVbVJI8p3zYbylWRyxyOv5cOXXtbv38j4TQWkZmF+DMDyLV0O1BBgZ+Kz8nfdgBQvqz7iCH8DxSZ2oBkH5SfRjRn7PTXdVoJ3esCnkgrDKtbp2NmOFbD37E1WH02b48qGXRLqPu4ZaOVKr6b84KG+hcnhALIVTECgYEA4XMU7env3IT/MlmjH7VqrEOlkG1vM91Jl0iFkK6BTD3t4zcKosyDfp4I8jZTidERXc7qVnz7pZA1xtecSUe+d3tULMUptbype+trU6jgSAy/p7sY6jGCe1sckF0y4aRsKxjUMzVMdupvKjRVSZcFtrd+mQnx1LtWaAQGADFfM3cCgYEA1Avb5YH0JrP7ZhmiqjpOk9Gv1e9GOxuut0Lfd71NhYtAEFV5YpHWk/UxlxA7jsUDlK2RIAssYHw6L+stEUBXZLBRLoi64a/eUz/9MDobPoChaT5G1yd3j1k2n95Fk2jKj97+tvuZIek8p10yG6rN9JOxGnMnyo7VJhdazyODWrcCgYEA0COoKfI1gXjEBl8dK9QYlMurWgi+hrqBC4tnzGhfdN0j+AbD6gM4Tzhl+ABR5cW/68RxMsIWrgbSry412q3C2Zph3ydz15ZDPuXc45Lg5YPnmVoxqV1mIq6+U0XICOv89Vjp6BEH9C2BzgwcxWEJZGRKG85DluwR3NwCEkGCrAcCgYEAt0NclJnhKoYJM+/Z/2ePPABRCQPYXgOJ2Adq3bD1TALSpotI8qD6pDuY1WeJIdYyRxBPSjN98hHLtFh8Rdmm7nXYY/B2G9IEw0ydhU3i9/zyA+R4E0Gf+ntvU3ImDcXWs8tVt03xxjYvXrKUOQdBIy12NlbqQA18OISczkNyJjcCgYBgFfDsLMeiTYDnxKySviTapbtTGq628fCjPyJInht9p2/KN4J7IQVC9iQM1iSqU8sPLuphPtPkZAdl5FbOLBp+VgwkrzwlUUHheA7XLlDFbFsEr+uIYfF2qST0iIHsQ2DOXfsua1EcnfAUx7bM/jHutBcOliCvtCUBYsoQSVbPxg==";
	private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAur2+7n0+8TB94DxxxL2AkQvTgvtS9Ow22WVS4nwxIieTHYOHl0VvZ5vRtw8dhiBy/mBdP3TYn2e8irdw1YAuWaJsw7erqHP0sucRSPAGQJeyXTouPBMzsUg4Tc7NwwQQAhMoSp35Iqnok5vdejImkXkuR6x40QoJ+YLvxQD+ahRdSmHoYXRnaBrUzGoUb/yqIq+pTFP/6TOJqvSCReJzAm3b1/JIGmwg1cAV3F0KUOo8iFYvlR4ZgJZ6B4pqsKWIy9Tk6wtzm4s81WANYUrKrqlPUHKs+POWbYmfoGmL4MeWYnw53gnkxZXqDUZRU2xipCZLQAy7Yu6LmRZ4XgqgEQIDAQAB";

	@Override
	public String unifiedOrder(AppUserOrder order) throws Exception {
		// 实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID,
				APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2");
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setTotalAmount(String.valueOf(order.getActually_paid()));
		model.setSubject("吉蜂达即配-下单");
		model.setOutTradeNo(order.getCode());
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		request.setBizModel(model);
		request.setNotifyUrl(Constants.ALI_NOTIFY_URL);
		// 这里和普通的接口调用不同，使用的是sdkExecute
		AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
		return response.getBody();// 就是orderString 可以直接给客户端请求，无需再做处理。
	}

	@Override
	public boolean notify(Map<String, String> params) throws Exception {
		return AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, "UTF-8", "RSA2");
	}
}
