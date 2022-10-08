package com.sample.domain.model;

import java.sql.Timestamp;
import lombok.Data;

/**
 * 顧客情報.
 *
 * @author yttak
 */
@Data
public class Client {
  /** ID. */
  private Integer id;
  /** 姓. */
  private String familyname;
  /** 名. */
  private String firstname;
  /** 住所. */
  private String address;
  /** 生成日時. */
  private Timestamp createdAt;
}
