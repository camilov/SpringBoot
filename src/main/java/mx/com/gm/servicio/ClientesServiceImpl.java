package mx.com.gm.servicio;


import mx.com.gm.dao.ClientesDao;
import java.util.List;
import java.util.Optional;
import mx.com.gm.domain.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Janus
 */
@Service
public class ClientesServiceImpl implements ClientesService{

    @Autowired
     private ClientesDao clientesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Clientes> listarClientes() {
    
        return (List<Clientes>) clientesDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Clientes clientes) {
        
        clientesDao.save(clientes);
    }

    @Override
    @Transactional
    public void eliminar(Clientes clientes) {
        
        clientesDao.delete(clientes);
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes encontrarCliente(Clientes clientes) {
        
        return clientesDao.findById(clientes.getIdCliente()).orElse(null);
    }
    
}
