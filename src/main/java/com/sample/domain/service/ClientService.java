package com.sample.domain.service;

import com.sample.domain.model.Client;
import com.sample.domain.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClientService.
 *
 * @author yttak
 *
 */
@Service
public class ClientService {
  @Autowired
  private ClientRepository repository;
  
  /**
   * 顧客情報を全て返す.
   *
   * @return 顧客情報のリスト
   */
  public List<Client> getAll() {
    return repository.getAll();
  }
}
