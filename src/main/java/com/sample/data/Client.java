package com.sample.data;

import lombok.Data;

@Data
public class Client {
	/* ID .*/
	private Integer id;
	/* 名前 .*/
	private String name;
	/* 住所 .*/
	private String address;
	/* メールアドレス .*/
	private String email;
}
