/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class GrupoDAO {
	public static Grupo loadGrupoByORMID(int uid) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return loadGrupoByORMID(session, uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo getGrupoByORMID(int uid) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return getGrupoByORMID(session, uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo loadGrupoByORMID(int uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return loadGrupoByORMID(session, uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo getGrupoByORMID(int uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return getGrupoByORMID(session, uid, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo loadGrupoByORMID(PersistentSession session, int uid) throws PersistentException {
		try {
			return (Grupo) session.load(orm.Grupo.class, new Integer(uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo getGrupoByORMID(PersistentSession session, int uid) throws PersistentException {
		try {
			return (Grupo) session.get(orm.Grupo.class, new Integer(uid));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo loadGrupoByORMID(PersistentSession session, int uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Grupo) session.load(orm.Grupo.class, new Integer(uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo getGrupoByORMID(PersistentSession session, int uid, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Grupo) session.get(orm.Grupo.class, new Integer(uid), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGrupo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return queryGrupo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGrupo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return queryGrupo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo[] listGrupoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return listGrupoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo[] listGrupoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return listGrupoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGrupo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Grupo as Grupo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGrupo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Grupo as Grupo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Grupo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo[] listGrupoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGrupo(session, condition, orderBy);
			return (Grupo[]) list.toArray(new Grupo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo[] listGrupoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGrupo(session, condition, orderBy, lockMode);
			return (Grupo[]) list.toArray(new Grupo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo loadGrupoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return loadGrupoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo loadGrupoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return loadGrupoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo loadGrupoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Grupo[] grupos = listGrupoByQuery(session, condition, orderBy);
		if (grupos != null && grupos.length > 0)
			return grupos[0];
		else
			return null;
	}
	
	public static Grupo loadGrupoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Grupo[] grupos = listGrupoByQuery(session, condition, orderBy, lockMode);
		if (grupos != null && grupos.length > 0)
			return grupos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateGrupoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return iterateGrupoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGrupoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.AdministracionContactosPersistentManager.instance().getSession();
			return iterateGrupoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGrupoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Grupo as Grupo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGrupoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Grupo as Grupo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Grupo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo createGrupo() {
		return new orm.Grupo();
	}
	
	public static boolean save(orm.Grupo grupo) throws PersistentException {
		try {
			orm.AdministracionContactosPersistentManager.instance().saveObject(grupo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Grupo grupo) throws PersistentException {
		try {
			orm.AdministracionContactosPersistentManager.instance().deleteObject(grupo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Grupo grupo)throws PersistentException {
		try {
			orm.Membresia[] lMembresias = grupo.membresia.toArray();
			for(int i = 0; i < lMembresias.length; i++) {
				lMembresias[i].setGrupo(null);
			}
			orm.Notificacion[] lNotificacions = grupo.notificacion.toArray();
			for(int i = 0; i < lNotificacions.length; i++) {
				lNotificacions[i].setGrupo(null);
			}
			orm.Actividad[] lActividads = grupo.actividad.toArray();
			for(int i = 0; i < lActividads.length; i++) {
				lActividads[i].setGrupo(null);
			}
			return delete(grupo);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Grupo grupo, org.orm.PersistentSession session)throws PersistentException {
		try {
			orm.Membresia[] lMembresias = grupo.membresia.toArray();
			for(int i = 0; i < lMembresias.length; i++) {
				lMembresias[i].setGrupo(null);
			}
			orm.Notificacion[] lNotificacions = grupo.notificacion.toArray();
			for(int i = 0; i < lNotificacions.length; i++) {
				lNotificacions[i].setGrupo(null);
			}
			orm.Actividad[] lActividads = grupo.actividad.toArray();
			for(int i = 0; i < lActividads.length; i++) {
				lActividads[i].setGrupo(null);
			}
			try {
				session.delete(grupo);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(orm.Grupo grupo) throws PersistentException {
		try {
			orm.AdministracionContactosPersistentManager.instance().getSession().refresh(grupo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Grupo grupo) throws PersistentException {
		try {
			orm.AdministracionContactosPersistentManager.instance().getSession().evict(grupo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Grupo loadGrupoByCriteria(GrupoCriteria grupoCriteria) {
		Grupo[] grupos = listGrupoByCriteria(grupoCriteria);
		if(grupos == null || grupos.length == 0) {
			return null;
		}
		return grupos[0];
	}
	
	public static Grupo[] listGrupoByCriteria(GrupoCriteria grupoCriteria) {
		return grupoCriteria.listGrupo();
	}
}
