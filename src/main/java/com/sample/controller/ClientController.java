package com.sample.controller;

import com.sample.domain.model.Client;
import com.sample.domain.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顧客情報管理.
 *
 * @author yttak
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
  @Autowired
  private ClientService service;
  
  /**
   * 顧客情報を全て返す.
   *
   * @return APIの戻り値
   */
  @GetMapping("/clients")
  public List<Client> getAll() {
    return service.getAll();
  }
  
  /**
   * 顧客情報を1件登録する.
   *
   * @param client 顧客情報
   * @return 結果
   */
  @PostMapping("/clients")
  public ResponseEntity<Client> post(@RequestBody Client client) {
    ResponseEntity<Client> ret = null;
    Client responseData = service.post(client);
    
    if (responseData != null) {
      ret = new ResponseEntity<Client>(responseData, HttpStatus.CREATED);
    }
    
    return ret;
  }
}
