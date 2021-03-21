package hola;


public class XMLDaoFactory extends DaoFactory {

	@Override
	public Dao<Empleado> getEmpleadoDao() {
		// TODO Esbozo de m�todo generado autom�ticamente
		return new XmlEmpleadoDao();
	}

	@Override
	public Dao<Ong> getOngDao() {
		// TODO Esbozo de m�todo generado autom�ticamente
		return new XMLOngDao();
	}


}
