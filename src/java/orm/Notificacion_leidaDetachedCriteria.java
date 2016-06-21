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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Notificacion_leidaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression uid;
	public final StringExpression visto;
	public final IntegerExpression notificacionId;
	public final AssociationExpression notificacion;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	
	public Notificacion_leidaDetachedCriteria() {
		super(orm.Notificacion_leida.class, orm.Notificacion_leidaCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		visto = new StringExpression("visto", this.getDetachedCriteria());
		notificacionId = new IntegerExpression("notificacion.uid", this.getDetachedCriteria());
		notificacion = new AssociationExpression("notificacion", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.uid", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
	}
	
	public Notificacion_leidaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.Notificacion_leidaCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		visto = new StringExpression("visto", this.getDetachedCriteria());
		notificacionId = new IntegerExpression("notificacion.uid", this.getDetachedCriteria());
		notificacion = new AssociationExpression("notificacion", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.uid", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
	}
	
	public NotificacionDetachedCriteria createNotificacionCriteria() {
		return new NotificacionDetachedCriteria(createCriteria("notificacion"));
	}
	
	public ContactoDetachedCriteria createContactoCriteria() {
		return new ContactoDetachedCriteria(createCriteria("contacto"));
	}
	
	public Notificacion_leida uniqueNotificacion_leida(PersistentSession session) {
		return (Notificacion_leida) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Notificacion_leida[] listNotificacion_leida(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notificacion_leida[]) list.toArray(new Notificacion_leida[list.size()]);
	}
}

