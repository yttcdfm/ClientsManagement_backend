package com.sample.mapper;

import com.sample.domain.model.Client;
import java.util.List;
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
}
