package com.sample.controller;

import com.sample.domain.model.Client;
import com.sample.domain.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 顧客情報管理.
 *
 * @author yttak
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
  private static final String RESOURCE_NAME = "/clients";
  @Autowired
  private ClientService service;
  
  /**
   * 顧客情報を全て返す.
   *
   * @return APIの戻り値
   */
  @GetMapping(RESOURCE_NAME)
  public List<Client> getAll() {
    return service.getAll();
  }
  
  /**
   * 顧客情報を1件登録する.
   *
   * @param client 顧客情報
   * @return 結果
   */
  @PostMapping(RESOURCE_NAME)
  public ResponseEntity<Client> post(@Validated @RequestBody Client client, BindingResult bindingResult) {
    ResponseEntity<Client> ret = null;
    // バリデーション
    if (bindingResult.hasErrors()) {
      ret = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      return ret;
    }
    
    Client responseData = service.post(client);
    
    if (responseData != null) {
      ret = new ResponseEntity<Client>(responseData, HttpStatus.CREATED);
    }
    
    return ret;
  }
  
  /**
   * 顧客情報を複数件更新する.
   *
   * @param editTargets 編集対象のリソースの配列
   * @return 更新後の顧客情報のリスト
   */
  @Transactional
  @PostMapping(RESOURCE_NAME + "/bulk_update")
  public ResponseEntity<List<Client>> bulkupdate(@RequestBody List<Client> editTargets) {
    ResponseEntity<List<Client>> ret = null;
    
    //バリデーション
    if (!validateBulkupdate(editTargets)) {
      ret = new ResponseEntity<List<Client>>(HttpStatus.BAD_REQUEST);
      return ret;
    }
    
    ret = new ResponseEntity<List<Client>>(service.bulkupdate(editTargets), HttpStatus.OK);
    return ret;
  }
  
  /**
   * 顧客情報を複数件削除する.
   *
   * @param deleteTargets 削除対象のIDの配列
   * @return 削除件数
   */
  @Transactional
  @PostMapping(RESOURCE_NAME + "/delete")
  public ResponseEntity<Integer> deleteClients(@RequestBody List<Integer> deleteTargets) {
    ResponseEntity<Integer> ret = null;
    
    // バリデーション
    if (!validateDeleteClients(deleteTargets)) {
      ret = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
      return ret;
    }
    
    ret = new ResponseEntity<Integer>(service.delete(deleteTargets), HttpStatus.OK);
    return ret;
  }
  
  /**
   * バリデーション.
   *
   * @param editTargets 更新対象の顧客情報のリスト
   * @return 結果
   */
  private Boolean validateBulkupdate(List<Client> editTargets) {
    Boolean ret = false;
    if ((editTargets == null) || (editTargets.size() == 0)) {
      return ret;
    }
    
    for (Client client : editTargets) {
      if ((client.getId() == null)
          || (client.getFamilyname() == null)
          || (client.getFamilyname().isEmpty())
          || (client.getFirstname() == null)
          || (client.getFirstname().isEmpty())
          || (client.getAddress() == null)
          || (client.getAddress().isEmpty())) {
        return ret;
      }
    }
    
    ret = true;
    return ret;
  }
  
  /**
   * バリデーション.
   *
   * @param deleteTargets 削除対象の顧客情報のリスト
   * @return 結果
   */
  private Boolean validateDeleteClients(List<Integer> deleteTargets) {
    Boolean ret = false;
    
    if ((deleteTargets == null) || (deleteTargets.size() == 0)) {
      return ret;
    }
    
    for (Integer id : deleteTargets) {
      if (id == null) {
        return ret;
      }
    }
    
    ret = true;
    return ret;
  }
}
