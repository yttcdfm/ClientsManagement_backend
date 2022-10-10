package com.sample.mapper;

import com.sample.domain.model.Client;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClientMapper.
 *
 * @author yttak
 */
@Mapper
public interface ClientMapper {
  /**
   * 全顧客情報を取得.
   *
   * @return 全顧客情報
   */
  List<Client> selectAll();
  
  /**
   * 顧客情報を1件取得.
   *
   * @param id ID
   * @return 顧客情報
   */
  Client selectOne(int id);
  
  /**
   * 顧客情報を1件登録.
   *
   * @param client 顧客情報
   * @return 登録件数
   */
  int insert(Client client);
  
  /**
   * 顧客情報を複数件更新.
   *
   * @param editTargets 編集対象のリソースの配列
   * @return 更新後の顧客情報のリスト
   */
  int updateMany(List<Client> editTargets);
  
  /**
   * 顧客情報を複数件削除.
   *
   * @param deleteTargets 削除対象のIDの配列
   * @return 削除件数
   */
  int delete(List<Integer> deleteTargets);
}
