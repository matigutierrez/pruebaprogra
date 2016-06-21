/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateAdministracionContactosData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notificacion_leida, actividad_leida, membresia, imagenes, empresa, ciudad, telefono, mail
			orm.ContactoDAO.save(lormContacto);
			orm.Grupo lormGrupo = orm.GrupoDAO.createGrupo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : actividad, notificacion, membresia
			orm.GrupoDAO.save(lormGrupo);
			orm.Membresia lormMembresia = orm.MembresiaDAO.createMembresia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : grupo, contacto
			orm.MembresiaDAO.save(lormMembresia);
			orm.Notificacion lormNotificacion = orm.NotificacionDAO.createNotificacion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notificacion_leida, grupo
			orm.NotificacionDAO.save(lormNotificacion);
			orm.Actividad lormActividad = orm.ActividadDAO.createActividad();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : actividad_leida, grupo
			orm.ActividadDAO.save(lormActividad);
			orm.Notificacion_leida lormNotificacion_leida = orm.Notificacion_leidaDAO.createNotificacion_leida();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contacto, notificacion, visto
			orm.Notificacion_leidaDAO.save(lormNotificacion_leida);
			orm.Actividad_leida lormActividad_leida = orm.Actividad_leidaDAO.createActividad_leida();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : actividad, contacto, visto
			orm.Actividad_leidaDAO.save(lormActividad_leida);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateAdministracionContactosData createAdministracionContactosData = new CreateAdministracionContactosData();
			try {
				createAdministracionContactosData.createTestData();
			}
			finally {
				orm.AdministracionContactosPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
