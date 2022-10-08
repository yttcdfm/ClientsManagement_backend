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
  public List<Client> getAll();
}
