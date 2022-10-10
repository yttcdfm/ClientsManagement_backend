package com.sample.domain.model;

import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
  @NotNull
  @Size(min = 1, max = 50)
  private String familyname;
  /** 名. */
  @NotNull
  @Size(min = 1, max = 50)
  private String firstname;
  /** 住所. */
  @NotNull
  @Size(min = 1, max = 100)
  private String address;
  /** 生成日時. */
  private Timestamp createdAt;
}
