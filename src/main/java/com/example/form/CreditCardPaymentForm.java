package com.example.form;

/**
 * クレジットカード支払い情報が入るフォーム.
 * 
 * @author igamasayuki
 *
 */
public class CreditCardPaymentForm {

	/** 購入者ID */
	private String user_id;
	/** 注文番号 */
	private String order_number;
	/** 決済金額(数字10桁) */
	private String amount;
	/** 支払方法ステータス*/
	private String paymentMethod;
	/** カード番号(数字14桁-16桁) */
	private String card_number;
	/** カード有効期限(月)(数字2桁) */
	private String card_exp_month;
	/** カード有効期限(年)(数字4桁) */
	private String card_exp_year;
	/** セキュリティコード(数字3桁-4桁) */
	private String card_cvv;
	/** カード名義人名 */
	private String card_name;
	
	@Override
	public String toString() {
		return "CreditCardPaymentForm [user_id=" + user_id + ", order_number=" + order_number + ", amount=" + amount
				+ ", paymentMethod=" + paymentMethod + ", card_number=" + card_number + ", card_exp_month="
				+ card_exp_month + ", card_exp_year=" + card_exp_year + ", card_cvv=" + card_cvv + ", card_name="
				+ card_name + "]";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getCard_exp_month() {
		return card_exp_month;
	}
	public void setCard_exp_month(String card_exp_month) {
		this.card_exp_month = card_exp_month;
	}
	public String getCard_exp_year() {
		return card_exp_year;
	}
	public void setCard_exp_year(String card_exp_year) {
		this.card_exp_year = card_exp_year;
	}
	public String getCard_cvv() {
		return card_cvv;
	}
	public void setCard_cvv(String card_cvv) {
		this.card_cvv = card_cvv;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	

	
}
