package mx.com.gm.dao;

import mx.com.gm.domain.Clientes;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Janus
 */


public interface IClientesDao extends CrudRepository<Clientes,Number>{
    
}
