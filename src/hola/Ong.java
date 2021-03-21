package hola;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ong")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder={"nombre","direccion","cif","pais","telefono","web","email","listaEmpleados"})
public class Ong {
	
	private DaoFactory xmlDAOFactory = DaoFactory.getDAOFactory(DaoFactory.XML);
	private Dao<Empleado> empleadoDAO = (XmlEmpleadoDao) xmlDAOFactory.getEmpleadoDao();


	private String Nombre;
	private String Direccion;
	private String CIF;
	private String Pais;
	private String Telefono;
	private String Web;
	private String Email;
	private ArrayList<Empleado> ListaEmpleados;
		
	/**
	 *  
	 */
	public Ong() {
		
		ListaEmpleados = new ArrayList<>();
		
	}
	
	
	@XmlElement(name="nombreOng")
	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	@XmlElement(name="direccionOng")
	public String getDireccion() {
		return Direccion;
	}



	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	@XmlElement(name="cifOng")
	public String getCIF() {
		return CIF;
	}



	public void setCIF(String cIF) {
		CIF = cIF;
	}


	@XmlElement(name="paisOng")
	public String getPais() {
		return Pais;
	}



	public void setPais(String pais) {
		Pais = pais;
	}


	@XmlElement(name="telefonoOng")
	public String getTelefono() {
		return Telefono;
	}



	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	@XmlElement(name="webOng")
	public String getWeb() {
		return Web;
	}



	public void setWeb(String web) {
		Web = web;
	}


	@XmlElement(name="emailOng")
	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	@XmlElement(name="listaEmpleados")
	public ArrayList<Empleado> getListaEmpleados() {
		return ListaEmpleados;
	}

	/**
	 * @param listaEmpleados Establecer listaEmpleados
	 */
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		ListaEmpleados = listaEmpleados;
	}
	
	static Scanner leer = new Scanner(System.in);
	
	public void AgregarEmpleado() {
		
		ArrayList<Empleado> NuevaListaEmpleados = this.getListaEmpleados();
		
		System.out.println("Introduce id");
		
		String Id = leer.nextLine();
		
		System.out.println("Introduce nombre");
		
		String Nombre = leer.nextLine();
		
		System.out.println("Introduce apellido");
		
		String Apellidos = leer.nextLine();
		
		System.out.println("Introduce direccion");
		
		String Direccion = leer.nextLine();
		
		System.out.println("Introduce telefono");
		
		String Telefono = leer.nextLine();
		
		System.out.println("Introduce dni");
		
		String DNI = leer.nextLine();
		
		
		
		Empleado empleado = new Empleado(Id, Nombre, Apellidos, Direccion, Telefono, DNI);
		NuevaListaEmpleados.add(empleado);
		
		try {
			empleadoDAO.crearNuevo(empleado);
		} catch (JAXBException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
	
	
	public void imprimirEmpleados() {
		
		ArrayList<Empleado>NuevaListaEmpleados = this.getListaEmpleados();
		
		
		for(Empleado aux: NuevaListaEmpleados) {
			System.out.println("***************************************************");
			System.out.println("              LISTADO DE EMPLEADOS ");
			System.out.println("***************************************************");
			System.out.println(" Hay " + NuevaListaEmpleados.size() + " empleados almacenados.");
			System.out.println("Nombre del empleado: " + aux.getNombre());
			System.out.println("Apellidos del empleado: " + aux.getApellidos());
			System.out.println("DNI del empleado: " + aux.getDNI());
			System.out.println("Direccion del empleado: " + aux.getDireccion());
						
		}
		
	}
	
	public void EliminarEmpleado() {
		
		ArrayList<Empleado> EliminarListaEmpleados = this.getListaEmpleados();

		if (EliminarListaEmpleados.isEmpty()) {
			System.out.println("No hay empleados a eliminar\n");
		} else {

			for (int i = 0; i < EliminarListaEmpleados.size(); i++) {

				System.out.println("Nombre del empleado: " + EliminarListaEmpleados.get(i).getNombre());
			}
			try {
				System.out.println("Indique el nombre del empleado a eliminar: ");
				String eliminar = leer.nextLine();
				leer.nextLine();
				EliminarListaEmpleados.remove(eliminar);  
																
			} catch (Exception e) {
				System.out.println("El empleado no se encuentra en la lista\n");
			}
		}
		
	}
	
	
}
