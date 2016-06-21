/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListAdministracionContactosData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Contacto...");
		orm.Contacto[] ormContactos = orm.ContactoDAO.listContactoByQuery(null, null);
		int length = Math.min(ormContactos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormContactos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Grupo...");
		orm.Grupo[] ormGrupos = orm.GrupoDAO.listGrupoByQuery(null, null);
		length = Math.min(ormGrupos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormGrupos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Membresia...");
		orm.Membresia[] ormMembresias = orm.MembresiaDAO.listMembresiaByQuery(null, null);
		length = Math.min(ormMembresias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormMembresias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Notificacion...");
		orm.Notificacion[] ormNotificacions = orm.NotificacionDAO.listNotificacionByQuery(null, null);
		length = Math.min(ormNotificacions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormNotificacions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Actividad...");
		orm.Actividad[] ormActividads = orm.ActividadDAO.listActividadByQuery(null, null);
		length = Math.min(ormActividads.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormActividads[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Notificacion_leida...");
		orm.Notificacion_leida[] ormNotificacion_leidas = orm.Notificacion_leidaDAO.listNotificacion_leidaByQuery(null, null);
		length = Math.min(ormNotificacion_leidas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormNotificacion_leidas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Actividad_leida...");
		orm.Actividad_leida[] ormActividad_leidas = orm.Actividad_leidaDAO.listActividad_leidaByQuery(null, null);
		length = Math.min(ormActividad_leidas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormActividad_leidas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Contacto by Criteria...");
		orm.ContactoCriteria lormContactoCriteria = new orm.ContactoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormContactoCriteria.uid.eq();
		lormContactoCriteria.setMaxResults(ROW_COUNT);
		orm.Contacto[] ormContactos = lormContactoCriteria.listContacto();
		int length =ormContactos== null ? 0 : Math.min(ormContactos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormContactos[i]);
		}
		System.out.println(length + " Contacto record(s) retrieved."); 
		
		System.out.println("Listing Grupo by Criteria...");
		orm.GrupoCriteria lormGrupoCriteria = new orm.GrupoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormGrupoCriteria.uid.eq();
		lormGrupoCriteria.setMaxResults(ROW_COUNT);
		orm.Grupo[] ormGrupos = lormGrupoCriteria.listGrupo();
		length =ormGrupos== null ? 0 : Math.min(ormGrupos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormGrupos[i]);
		}
		System.out.println(length + " Grupo record(s) retrieved."); 
		
		System.out.println("Listing Membresia by Criteria...");
		orm.MembresiaCriteria lormMembresiaCriteria = new orm.MembresiaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormMembresiaCriteria.uid.eq();
		lormMembresiaCriteria.setMaxResults(ROW_COUNT);
		orm.Membresia[] ormMembresias = lormMembresiaCriteria.listMembresia();
		length =ormMembresias== null ? 0 : Math.min(ormMembresias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormMembresias[i]);
		}
		System.out.println(length + " Membresia record(s) retrieved."); 
		
		System.out.println("Listing Notificacion by Criteria...");
		orm.NotificacionCriteria lormNotificacionCriteria = new orm.NotificacionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormNotificacionCriteria.uid.eq();
		lormNotificacionCriteria.setMaxResults(ROW_COUNT);
		orm.Notificacion[] ormNotificacions = lormNotificacionCriteria.listNotificacion();
		length =ormNotificacions== null ? 0 : Math.min(ormNotificacions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormNotificacions[i]);
		}
		System.out.println(length + " Notificacion record(s) retrieved."); 
		
		System.out.println("Listing Actividad by Criteria...");
		orm.ActividadCriteria lormActividadCriteria = new orm.ActividadCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormActividadCriteria.uid.eq();
		lormActividadCriteria.setMaxResults(ROW_COUNT);
		orm.Actividad[] ormActividads = lormActividadCriteria.listActividad();
		length =ormActividads== null ? 0 : Math.min(ormActividads.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormActividads[i]);
		}
		System.out.println(length + " Actividad record(s) retrieved."); 
		
		System.out.println("Listing Notificacion_leida by Criteria...");
		orm.Notificacion_leidaCriteria lormNotificacion_leidaCriteria = new orm.Notificacion_leidaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormNotificacion_leidaCriteria.uid.eq();
		lormNotificacion_leidaCriteria.setMaxResults(ROW_COUNT);
		orm.Notificacion_leida[] ormNotificacion_leidas = lormNotificacion_leidaCriteria.listNotificacion_leida();
		length =ormNotificacion_leidas== null ? 0 : Math.min(ormNotificacion_leidas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormNotificacion_leidas[i]);
		}
		System.out.println(length + " Notificacion_leida record(s) retrieved."); 
		
		System.out.println("Listing Actividad_leida by Criteria...");
		orm.Actividad_leidaCriteria lormActividad_leidaCriteria = new orm.Actividad_leidaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormActividad_leidaCriteria.uid.eq();
		lormActividad_leidaCriteria.setMaxResults(ROW_COUNT);
		orm.Actividad_leida[] ormActividad_leidas = lormActividad_leidaCriteria.listActividad_leida();
		length =ormActividad_leidas== null ? 0 : Math.min(ormActividad_leidas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormActividad_leidas[i]);
		}
		System.out.println(length + " Actividad_leida record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListAdministracionContactosData listAdministracionContactosData = new ListAdministracionContactosData();
			try {
				listAdministracionContactosData.listTestData();
				//listAdministracionContactosData.listByCriteria();
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
