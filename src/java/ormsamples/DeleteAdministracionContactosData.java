/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteAdministracionContactosData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByQuery(null, null);
			// Delete the persistent object
			orm.ContactoDAO.delete(lormContacto);
			orm.Grupo lormGrupo = orm.GrupoDAO.loadGrupoByQuery(null, null);
			// Delete the persistent object
			orm.GrupoDAO.delete(lormGrupo);
			orm.Membresia lormMembresia = orm.MembresiaDAO.loadMembresiaByQuery(null, null);
			// Delete the persistent object
			orm.MembresiaDAO.delete(lormMembresia);
			orm.Notificacion lormNotificacion = orm.NotificacionDAO.loadNotificacionByQuery(null, null);
			// Delete the persistent object
			orm.NotificacionDAO.delete(lormNotificacion);
			orm.Actividad lormActividad = orm.ActividadDAO.loadActividadByQuery(null, null);
			// Delete the persistent object
			orm.ActividadDAO.delete(lormActividad);
			orm.Notificacion_leida lormNotificacion_leida = orm.Notificacion_leidaDAO.loadNotificacion_leidaByQuery(null, null);
			// Delete the persistent object
			orm.Notificacion_leidaDAO.delete(lormNotificacion_leida);
			orm.Actividad_leida lormActividad_leida = orm.Actividad_leidaDAO.loadActividad_leidaByQuery(null, null);
			// Delete the persistent object
			orm.Actividad_leidaDAO.delete(lormActividad_leida);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteAdministracionContactosData deleteAdministracionContactosData = new DeleteAdministracionContactosData();
			try {
				deleteAdministracionContactosData.deleteTestData();
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
