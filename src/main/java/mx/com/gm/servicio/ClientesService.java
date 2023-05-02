package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Clientes;

/**
 *
 * @author Janus
 */
public interface ClientesService {
    
    public List<Clientes> listarClientes();
    
    public void guardar(Clientes clientes);
    
    public void eliminar(Clientes clientes);
    
    public Clientes encontrarCliente(Clientes clientes);
}
