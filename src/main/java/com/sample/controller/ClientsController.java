package com.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.data.Client;

@RestController
public class ClientsController {
	@GetMapping("/api/v1/clients")
	public List<Client> get() {
		Client client = new Client();
		client.setId(0001);
		client.setName("田中太郎");
		client.setAddress("神奈川県");
		client.setEmail("hogehoge@test.mail");
		
		List<Client> ret = new ArrayList<Client>();
		ret.add(client);
		return ret;
	}
}
