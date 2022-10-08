package com.sample.domain.repository;

import com.sample.domain.model.Client;
import com.sample.mapper.ClientMapper;
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

}
