package com.sample.domain.service;

import com.sample.domain.model.Client;
import com.sample.domain.repository.ClientRepository;

import java.util.Iterator;
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
   * 顧客情報を全件取得する.
   *
   * @return 顧客情報のリスト
   */
  public List<Client> getAll() {
    return repository.getAll();
  }
  
  /**
   * 顧客情報を1件登録する.
   *
   * @param client 顧客情報
   * @return 顧客情報
   */
  public Client post(Client client) {
    return repository.post(client);
  }
  
  /**
   * 顧客情報を複数件更新する.
   *
   * @param editTargets 編集対象のリソースの配列
   * @return 更新後の顧客情報リスト
   */
  public List<Client> bulkupdate(List<Client> editTargets) {
    return repository.updateClients(editTargets);
  }
  
  /**
   * 顧客情報を複数件削除する.
   *
   * @param deleteTargets 削除対象のIDの配列
   * @return 削除件数
   */
  public Integer delete(List<Integer> deleteTargets) {
    return repository.delete(deleteTargets);
  }
}
