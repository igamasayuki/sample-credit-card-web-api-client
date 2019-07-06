package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.RequestCreditCardCancelApiDomain;
import com.example.domain.ResponseCreditCardCancelApiDomain;
import com.example.form.CreditCardCancelForm;

/**
 * カード決済APIを呼び出すサービスクラス.
 * 
 * @author igamasayuki
 *
 */
@Service
public class CreditCardCancelApiCallService {

	@Autowired
	private RestTemplate restTemplate;

	// 外部サーバで動いているWEB-APIのURL
	private static final String URL = "http://153.126.174.131:8080/sample-credit-card-web-api/credit-card/cancel"; 
//	private static final String URL = "http://153.126.174.131:8080/web-api-sample/credit-card/cancel"; 

	/**
	 * カード決済キャンセルWebAPIを呼び出し、レスポンスを返す.
	 * 
	 * @param form クレジットカード情報
	 * @return　WebAPIのレスポンスが入ったドメイン
	 */
	public ResponseCreditCardCancelApiDomain cancelApiService(CreditCardCancelForm form) {
		RequestCreditCardCancelApiDomain requestCreditCardCancelApiDomain = new RequestCreditCardCancelApiDomain();
		BeanUtils.copyProperties(form, requestCreditCardCancelApiDomain);
		return restTemplate.postForObject(URL, form, ResponseCreditCardCancelApiDomain.class);
	}
}
