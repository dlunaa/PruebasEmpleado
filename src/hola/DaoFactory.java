package hola;


/**
 * Clase abstracta que permite seleccionar la factoria con la que queremos
 * persistir los datos.
 * 
 * @author Yaiza, Teresa y Marc.
 * @version 1.0
 *
 */
public abstract class DaoFactory {
	
	// Lista de tipos DAO soportado por la factoria.
	public static final int XML = 1;
	public static final int SQL = 2;

	// Hay un metodo para cada DAO que puede ser creado.
	// Las factorias tendran que implementar estos metodos.
	public abstract Dao<Empleado> getEmpleadoDao();
	public abstract Dao<Ong> getOngDao();
	//public abstract DAO<Delegacion> getDelegacionDAO();

	public static DaoFactory getDAOFactory(int whichFactory) {
		
		switch (whichFactory) {
			case 1: 
				return new XMLDaoFactory();
	        case 2: 
	            return new SqlDaoFactory();
	        default: 
	            return null;
	    }
		
	}
	
}
