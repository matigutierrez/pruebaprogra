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

public class Notificacion_leidaCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final StringExpression visto;
	public final IntegerExpression notificacionId;
	public final AssociationExpression notificacion;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	
	public Notificacion_leidaCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		visto = new StringExpression("visto", this);
		notificacionId = new IntegerExpression("notificacion.uid", this);
		notificacion = new AssociationExpression("notificacion", this);
		contactoId = new IntegerExpression("contacto.uid", this);
		contacto = new AssociationExpression("contacto", this);
	}
	
	public Notificacion_leidaCriteria(PersistentSession session) {
		this(session.createCriteria(Notificacion_leida.class));
	}
	
	public Notificacion_leidaCriteria() throws PersistentException {
		this(orm.AdministracionContactosPersistentManager.instance().getSession());
	}
	
	public NotificacionCriteria createNotificacionCriteria() {
		return new NotificacionCriteria(createCriteria("notificacion"));
	}
	
	public ContactoCriteria createContactoCriteria() {
		return new ContactoCriteria(createCriteria("contacto"));
	}
	
	public Notificacion_leida uniqueNotificacion_leida() {
		return (Notificacion_leida) super.uniqueResult();
	}
	
	public Notificacion_leida[] listNotificacion_leida() {
		java.util.List list = super.list();
		return (Notificacion_leida[]) list.toArray(new Notificacion_leida[list.size()]);
	}
}

