package hola;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class XmlEmpleadoDao implements Dao<Empleado> {
	
	private ListadoEmpleados listaEmpleados = new ListadoEmpleados();

	
	public XmlEmpleadoDao() {
	
	}
	
	public XmlEmpleadoDao(ListadoEmpleados listadoEmpleados) {
		super();
		this.listaEmpleados = listaEmpleados;
	}
	
	public ListadoEmpleados getListaEmpelados() {
		return listaEmpleados;
	}
	
	/**
	 * Metodo accesor de escritura que asigna el listado de trabajadores de la ONG.
	 * 
	 * @param listadoTrabajadores El listado de trabajadores de la ONG.
	 */
	public void setListaEmpleados(ListadoEmpleados listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	
	@Override
	public void crearNuevo(Empleado t) throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		
		listaEmpleados.add(t);
		JAXBContext context = JAXBContext.newInstance(Empleado.class);
	    Marshaller mar= context.createMarshaller();
	    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    
	    //Crea el directorio "xml" en caso de que no exista.
	    File f = new File("xml/");
	  	  if (!f.exists()) {
	  	    f.mkdirs();
	  	}
	  	  
	    mar.marshal(t, new File("xml/empleado.xml"));
		System.out.println("Se ha creado un nuevo empleado");
		
	}

	@Override
	public Optional<Empleado> obtener(String id) {
		
		System.out.println("Se ha obtenido un empleado");
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public void actualizar(Empleado t, String[] params) {
		// TODO Esbozo de método generado automáticamente
		
		encontrarEmpleadoPorId(t.getId()).setNombre(t.getNombre()); 
        System.out.println("El empleado con ID " + t.getId()  + " ha sido actualizado"); 
		
		
	}

	@Override
	public void borrar(Empleado t) {
		
		System.out.println("El empleado con ID " + t.getId() + "ha sido eliminado"); 
		// 
		
	}

	@Override
	public List<Empleado> obtenerTodos() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		
		if (listaEmpleados.getListadoEmpleados() != null) {
			System.out.println("La ONG cuenta con " + listaEmpleados.getListadoEmpleados().size() + " trabajadores:");
	    	for (Empleado t : listaEmpleados.getListadoEmpleados()) {
	    		System.out.println(t.toString());
	    	}
	    	
	    	JAXBContext context = JAXBContext.newInstance(Empleado.class);
	    	Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
		    //Crea el directorio "xml" en caso de que no exista.
		    File f = new File("xml/");
		  	  if (!f.exists()) {
		  	    f.mkdirs();
		  	}
			
			marshaller.marshal(listaEmpleados, new File("xml/empleados.xml"));
			
	    } else {
	    	System.out.println("La lista de empleados está vacía.");
	    }
		return listaEmpleados.getListadoEmpleados();
	}
	
	 public Empleado encontrarEmpleadoPorId(String id) {
	    	for (Empleado t : listaEmpleados.getListadoEmpleados()) {
	    		if (t.getId().equals(id)) {
	    			return t;
	    		}
	    	}
	    	return null;	
	    }

	
}
