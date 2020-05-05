package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.domain.RequestCreditCardPaymentApiDomain;
import com.example.domain.ResponseCreditCardPaymentApiDomain;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditCardWebApiTest {

	@Autowired
	private RestTemplate restTemplate;

	// 外部サーバで動いているWEB-APIのURL
	private static final String URL = "http://192.168.11.111:8080/sample-credit-card-web-api/credit-card/payment"; 

	@Test
	public void paymentApiService() {
		RequestCreditCardPaymentApiDomain requestCreditCardPaymentApiDomain = new RequestCreditCardPaymentApiDomain();
		requestCreditCardPaymentApiDomain.setCard_exp_year("2020");
		requestCreditCardPaymentApiDomain.setCard_exp_month("04");
		requestCreditCardPaymentApiDomain.setCard_cvv("123");
		ResponseCreditCardPaymentApiDomain responseCreditCardPaymentApiDomain = restTemplate.postForObject(URL, requestCreditCardPaymentApiDomain, ResponseCreditCardPaymentApiDomain.class);
		System.out.println(responseCreditCardPaymentApiDomain);
	}
	
}
