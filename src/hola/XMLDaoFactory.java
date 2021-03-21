package hola;


public class XMLDaoFactory extends DaoFactory {

	@Override
	public Dao<Empleado> getEmpleadoDao() {
		// TODO Esbozo de método generado automáticamente
		return new XmlEmpleadoDao();
	}

	@Override
	public Dao<Ong> getOngDao() {
		// TODO Esbozo de método generado automáticamente
		return new XMLOngDao();
	}


}
