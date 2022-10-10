package com.sample.domain.repository;

import com.sample.domain.model.Client;
import com.sample.mapper.ClientMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ClientRepositoryImpl.
 *
 * @author yttak
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

  @Autowired
  private ClientMapper mapper;

  @Override
  public List<Client> getAll() {
    return mapper.selectAll();
  }

  @Override
  public Client post(Client client) {
    Client ret = null;
    int registeredCount = mapper.insert(client);
    
    // 登録失敗
    if (registeredCount != 1) {
      return ret;
    }
    
    ret = mapper.selectOne(client.getId());
    
    return ret;
  }

  @Override
  public List<Client> updateClients(List<Client> editTargets) {
    List<Client> ret = null;
    
    int beforeCount = editTargets.size();
    int afterCount = mapper.updateMany(editTargets);
    
    if (beforeCount != afterCount) {
      return ret;
    }
    
    ret = new ArrayList<Client>();
    
    for (Client client : editTargets) {
      ret.add(mapper.selectOne(client.getId()));
    }
    
    return ret;
  }

  @Override
  public Integer delete(List<Integer> deleteTargets) {
    return mapper.delete(deleteTargets);
  }
}
