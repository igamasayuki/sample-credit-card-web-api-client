package com.example.domain;

/**
 * クレジットカード決済キャンセルAPIのリクエスト情報を扱うドメインクラス.
 * 
 * @author igamasayuki
 *
 */
public class RequestCreditCardCancelApiDomain {

	/** 注文番号 */
	private String oeder_number;

	public String getOeder_number() {
		return oeder_number;
	}

	public void setOeder_number(String oeder_number) {
		this.oeder_number = oeder_number;
	}
	

}
