package com.sample.domain.repository;

import com.sample.domain.model.Client;
import java.util.List;

/**
 * ClientRepository.
 *
 * @author yttak
 */
public interface ClientRepository {
  /**
   * 顧客情報の全件取得.
   *
   * @return 顧客情報のリスト
   */
  List<Client> getAll();
  
  /**
   * 顧客情報を1件登録.
   *
   * @param client 顧客情報
   * @return 顧客情報
   */
  Client post(Client client);
}
