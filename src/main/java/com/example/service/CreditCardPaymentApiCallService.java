package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.RequestCreditCardPaymentApiDomain;
import com.example.domain.ResponseCreditCardPaymentApiDomain;
import com.example.form.CreditCardPaymentForm;

/**
 * カード決済APIを呼び出すサービスクラス.
 * 
 * @author igamasayuki
 *
 */
@Service
public class CreditCardPaymentApiCallService {

	@Autowired
	private RestTemplate restTemplate;

	// 外部サーバで動いているWEB-APIのURL
	private static final String URL = "http://153.126.174.131:8080/sample-credit-card-web-api/credit-card/payment"; 
//	private static final String URL = "http://153.126.174.131:8080/web-api-sample/credit-card/payment"; 

	/**
	 * カード決済WebAPIを呼び出し、レスポンスを返す.
	 * 
	 * @param form クレジットカード情報
	 * @return　WebAPIのレスポンスが入ったドメイン
	 */
	public ResponseCreditCardPaymentApiDomain paymentApiService(CreditCardPaymentForm form) {
		RequestCreditCardPaymentApiDomain requestCreditCardPaymentApiDomain = new RequestCreditCardPaymentApiDomain();
		BeanUtils.copyProperties(form, requestCreditCardPaymentApiDomain);
		return restTemplate.postForObject(URL, form, ResponseCreditCardPaymentApiDomain.class);
	}
}
