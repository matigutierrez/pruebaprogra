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

public class NotificacionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression uid;
	public final DateExpression fecha;
	public final StringExpression mensaje;
	public final IntegerExpression grupoId;
	public final AssociationExpression grupo;
	public final CollectionExpression notificacion_leida;
	
	public NotificacionDetachedCriteria() {
		super(orm.Notificacion.class, orm.NotificacionCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		mensaje = new StringExpression("mensaje", this.getDetachedCriteria());
		grupoId = new IntegerExpression("grupo.uid", this.getDetachedCriteria());
		grupo = new AssociationExpression("grupo", this.getDetachedCriteria());
		notificacion_leida = new CollectionExpression("ORM_Notificacion_leida", this.getDetachedCriteria());
	}
	
	public NotificacionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.NotificacionCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		mensaje = new StringExpression("mensaje", this.getDetachedCriteria());
		grupoId = new IntegerExpression("grupo.uid", this.getDetachedCriteria());
		grupo = new AssociationExpression("grupo", this.getDetachedCriteria());
		notificacion_leida = new CollectionExpression("ORM_Notificacion_leida", this.getDetachedCriteria());
	}
	
	public GrupoDetachedCriteria createGrupoCriteria() {
		return new GrupoDetachedCriteria(createCriteria("grupo"));
	}
	
	public Notificacion_leidaDetachedCriteria createNotificacion_leidaCriteria() {
		return new Notificacion_leidaDetachedCriteria(createCriteria("ORM_Notificacion_leida"));
	}
	
	public Notificacion uniqueNotificacion(PersistentSession session) {
		return (Notificacion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Notificacion[] listNotificacion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
	}
}

