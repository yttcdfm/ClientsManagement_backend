package com.sample.controller;

import com.sample.domain.model.Client;
import com.sample.domain.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顧客情報管理いえい.
 *
 * @author yttak
 */
@RestController
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
}
