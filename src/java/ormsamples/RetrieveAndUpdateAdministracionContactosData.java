/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateAdministracionContactosData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByQuery(null, null);
			// Update the properties of the persistent object
			orm.ContactoDAO.save(lormContacto);
			orm.Grupo lormGrupo = orm.GrupoDAO.loadGrupoByQuery(null, null);
			// Update the properties of the persistent object
			orm.GrupoDAO.save(lormGrupo);
			orm.Membresia lormMembresia = orm.MembresiaDAO.loadMembresiaByQuery(null, null);
			// Update the properties of the persistent object
			orm.MembresiaDAO.save(lormMembresia);
			orm.Notificacion lormNotificacion = orm.NotificacionDAO.loadNotificacionByQuery(null, null);
			// Update the properties of the persistent object
			orm.NotificacionDAO.save(lormNotificacion);
			orm.Actividad lormActividad = orm.ActividadDAO.loadActividadByQuery(null, null);
			// Update the properties of the persistent object
			orm.ActividadDAO.save(lormActividad);
			orm.Notificacion_leida lormNotificacion_leida = orm.Notificacion_leidaDAO.loadNotificacion_leidaByQuery(null, null);
			// Update the properties of the persistent object
			orm.Notificacion_leidaDAO.save(lormNotificacion_leida);
			orm.Actividad_leida lormActividad_leida = orm.Actividad_leidaDAO.loadActividad_leidaByQuery(null, null);
			// Update the properties of the persistent object
			orm.Actividad_leidaDAO.save(lormActividad_leida);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Contacto by ContactoCriteria");
		orm.ContactoCriteria lormContactoCriteria = new orm.ContactoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormContactoCriteria.uid.eq();
		System.out.println(lormContactoCriteria.uniqueContacto());
		
		System.out.println("Retrieving Grupo by GrupoCriteria");
		orm.GrupoCriteria lormGrupoCriteria = new orm.GrupoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormGrupoCriteria.uid.eq();
		System.out.println(lormGrupoCriteria.uniqueGrupo());
		
		System.out.println("Retrieving Membresia by MembresiaCriteria");
		orm.MembresiaCriteria lormMembresiaCriteria = new orm.MembresiaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormMembresiaCriteria.uid.eq();
		System.out.println(lormMembresiaCriteria.uniqueMembresia());
		
		System.out.println("Retrieving Notificacion by NotificacionCriteria");
		orm.NotificacionCriteria lormNotificacionCriteria = new orm.NotificacionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormNotificacionCriteria.uid.eq();
		System.out.println(lormNotificacionCriteria.uniqueNotificacion());
		
		System.out.println("Retrieving Actividad by ActividadCriteria");
		orm.ActividadCriteria lormActividadCriteria = new orm.ActividadCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormActividadCriteria.uid.eq();
		System.out.println(lormActividadCriteria.uniqueActividad());
		
		System.out.println("Retrieving Notificacion_leida by Notificacion_leidaCriteria");
		orm.Notificacion_leidaCriteria lormNotificacion_leidaCriteria = new orm.Notificacion_leidaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormNotificacion_leidaCriteria.uid.eq();
		System.out.println(lormNotificacion_leidaCriteria.uniqueNotificacion_leida());
		
		System.out.println("Retrieving Actividad_leida by Actividad_leidaCriteria");
		orm.Actividad_leidaCriteria lormActividad_leidaCriteria = new orm.Actividad_leidaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormActividad_leidaCriteria.uid.eq();
		System.out.println(lormActividad_leidaCriteria.uniqueActividad_leida());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateAdministracionContactosData retrieveAndUpdateAdministracionContactosData = new RetrieveAndUpdateAdministracionContactosData();
			try {
				retrieveAndUpdateAdministracionContactosData.retrieveAndUpdateTestData();
				//retrieveAndUpdateAdministracionContactosData.retrieveByCriteria();
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
