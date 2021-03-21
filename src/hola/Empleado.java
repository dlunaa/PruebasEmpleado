package hola;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="empleado")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder= {"nombre","apellidos","direccion","telefono","dni"})

public class Empleado {
	
	private String Id;
	private String Nombre;
	private String Apellidos;
	private String Direccion;
	private String Telefono;
	private String DNI;
	
	public Empleado() {
		
	}
	
	public Empleado (String id, String nombre, String apellidos, String direccion, String telefono, String dNI) {
		Id = id;
		Nombre = nombre;
		Apellidos = apellidos;
		Direccion = direccion;
		Telefono = telefono;
		DNI = dNI;
	}
	
	@XmlElement(name="id")
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@XmlElement(name="apellidos")
	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	@XmlElement(name="direccion")
	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	@XmlElement(name="telefono")
	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	@XmlElement(name="dni")
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public String toString() {
		return "Empleados [Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion + ", Telefono="
				+ Telefono + ", DNI=" + DNI + "]";
	}
	
	

}
