package hola;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="empleados")
public class ListadoEmpleados {
	
	// CAMPOS
    private List<Empleado> listaEmpleados;
    
	// CONSTRUCTORES
	
	/**
	 * Constructor que llama a un nuevo objeto ListadoTrabajadores sin inicializar sus campos.
	 */
	public ListadoEmpleados() {
		super();
	}
	
	
	/**
	 * Constructor que llama a un nuevo objeto ListadoTrabajadores inicializando sus campos.
	 * 
	 * @param listadoTrabajadores Listado con todos los trabajadores de la ONG.
	 */
	public ListadoEmpleados(ArrayList<Empleado> listaEmpleados) {
		super();
		this.listaEmpleados = listaEmpleados;
	}
    
    
	// METODOS
	
    /**
     * Metodo accesor de lectura que nos da el listado de trabajadores de la ONG.
     * 
     * @return Nos devuelve el listado de trabajadores. 
     */
    @XmlElement(name = "empleado")
    public List<Empleado> getListadoEmpleados() {
        return listaEmpleados;
    }

    /**
     * Metodo accesor de escritura que asigna el listado de trabajadores de la ONG.
     * 
     * @param listaEmpleados El listado de trabajadores.
     */
    public void setListadoTrabajadores(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    
    /**
     * Metodo que permite agregar un trabajador al listado de trabajadores.
     * 
     * @param t Trabajador.
     */ 
    public void add(Empleado t) {
    	
        if (this.listaEmpleados == null) {
            this.listaEmpleados = new ArrayList<Empleado>();
        }
        
        this.listaEmpleados.add(t);

    }

}
