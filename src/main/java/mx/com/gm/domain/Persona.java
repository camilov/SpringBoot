package mx.com.gm.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author Janus
 */
//@Data
//@Entity
//@Table()
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono; 
}
