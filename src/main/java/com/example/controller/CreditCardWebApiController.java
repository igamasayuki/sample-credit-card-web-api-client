package com.example.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.ResponseCreditCardCancelApiDomain;
import com.example.domain.ResponseCreditCardPaymentApiDomain;
import com.example.form.CreditCardCancelForm;
import com.example.form.CreditCardPaymentForm;
import com.example.service.CreditCardCancelApiCallService;
import com.example.service.CreditCardPaymentApiCallService;

/**
 * 決済処理するコントローラ.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/")
public class CreditCardWebApiController {
	
	@Autowired
	private CreditCardPaymentApiCallService creditCardPaymentApiCallService;
	@Autowired
	private CreditCardCancelApiCallService creditCardCancelApiCallService;
	
	@ModelAttribute
	public CreditCardPaymentForm setUpForm() {
		return new CreditCardPaymentForm();
	}

	/**
	 * 支払い方法入力画面を表示します.
	 * 
	 * @param model モデル
	 * @return 支払い方法入力画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		Map<Integer, String> paymentMethodMap = new LinkedHashMap<>();
		paymentMethodMap.put(1, "銀行振込");
		paymentMethodMap.put(2, "クレジットカード");
		model.addAttribute("paymentMethodMap", paymentMethodMap);
		return "insert";
	}

	/**
	 * 支払い処理を実施します.
	 * 
	 * @param creditCardPaymentForm
	 * @return 支払い完了画面
	 */
	@RequestMapping("/payment")
	public String payment(CreditCardPaymentForm creditCardPaymentForm, RedirectAttributes redirectAttributes) {
		if ("1".equals(creditCardPaymentForm.getPaymentMethod())) {
			return "redirect:/finished";
		}
		
		// 支払い処理
		ResponseCreditCardPaymentApiDomain responseCreditCardPaymentApiDomain = creditCardPaymentApiCallService.paymentApiService(creditCardPaymentForm);
		redirectAttributes.addFlashAttribute("responseCreditCardPaymentApiDomain", responseCreditCardPaymentApiDomain);
		return "redirect:/toFinished";
	}
	
	/**
	 * 完了画面を表示します.
	 * 
	 * @return 完了画面
	 */
	@RequestMapping("/toFinished")
	public String toFinished() {
		return "finished";
	}
	
	/**
	 * キャンセル実施画面を表示します.
	 * 
	 * @return キャンセル実施画面
	 */
	@RequestMapping("/toCancel")
	public String toCancel() {
		return "cancel";
	}
	
	/**
	 * キャンセル処理を実施します.
	 * 
	 * @return キャンセル完了画面
	 */
	@RequestMapping("/cancel")
	public String cancel(CreditCardCancelForm creditCardCancelForm, RedirectAttributes redirectAttributes) {
		
		// キャンセル処理
		ResponseCreditCardCancelApiDomain responseCreditCardCancelApiDomain = creditCardCancelApiCallService.cancelApiService(creditCardCancelForm);
		redirectAttributes.addFlashAttribute("responseCreditCardCancelApiDomain", responseCreditCardCancelApiDomain);
		return "redirect:/toCancelled";
	}
	
	/**
	 * キャンセル完了画面を表示します.
	 * 
	 * @return キャンセル完了画面
	 */
	@RequestMapping("/toCancelled")
	public String toCancelled() {
		return "cancelled";
	}
	
}
