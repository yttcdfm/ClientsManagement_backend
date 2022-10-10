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
  
  /**
   * 顧客情報を複数件更新.
   *
   * @param editTargets 編集対象のリソースの配列
   * @return 更新後の顧客情報のリスト
   */
  List<Client> updateClients(List<Client> editTargets);
  
  /**
   * 顧客情報を複数件削除.
   *
   * @param deleteTargets 削除対象のIDの配列
   * @return 削除件数
   */
  Integer delete(List<Integer> deleteTargets);
}
