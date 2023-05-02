package mx.com.gm.domain;

/**
 *
 * @author Janus
 */


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
//import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")

public class Clientes implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCliente")
    private int idCliente;
    
    @NotEmpty
    @Column(name="nombre")
    private String nombre; 
    
    
}
