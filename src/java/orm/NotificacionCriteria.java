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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class NotificacionCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final DateExpression fecha;
	public final StringExpression mensaje;
	public final IntegerExpression grupoId;
	public final AssociationExpression grupo;
	public final CollectionExpression notificacion_leida;
	
	public NotificacionCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		fecha = new DateExpression("fecha", this);
		mensaje = new StringExpression("mensaje", this);
		grupoId = new IntegerExpression("grupo.uid", this);
		grupo = new AssociationExpression("grupo", this);
		notificacion_leida = new CollectionExpression("ORM_Notificacion_leida", this);
	}
	
	public NotificacionCriteria(PersistentSession session) {
		this(session.createCriteria(Notificacion.class));
	}
	
	public NotificacionCriteria() throws PersistentException {
		this(orm.AdministracionContactosPersistentManager.instance().getSession());
	}
	
	public GrupoCriteria createGrupoCriteria() {
		return new GrupoCriteria(createCriteria("grupo"));
	}
	
	public Notificacion_leidaCriteria createNotificacion_leidaCriteria() {
		return new Notificacion_leidaCriteria(createCriteria("ORM_Notificacion_leida"));
	}
	
	public Notificacion uniqueNotificacion() {
		return (Notificacion) super.uniqueResult();
	}
	
	public Notificacion[] listNotificacion() {
		java.util.List list = super.list();
		return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
	}
}

