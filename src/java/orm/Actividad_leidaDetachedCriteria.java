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

public class Actividad_leidaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression uid;
	public final StringExpression visto;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	public final IntegerExpression actividadId;
	public final AssociationExpression actividad;
	
	public Actividad_leidaDetachedCriteria() {
		super(orm.Actividad_leida.class, orm.Actividad_leidaCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		visto = new StringExpression("visto", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.uid", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
		actividadId = new IntegerExpression("actividad.uid", this.getDetachedCriteria());
		actividad = new AssociationExpression("actividad", this.getDetachedCriteria());
	}
	
	public Actividad_leidaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.Actividad_leidaCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		visto = new StringExpression("visto", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.uid", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
		actividadId = new IntegerExpression("actividad.uid", this.getDetachedCriteria());
		actividad = new AssociationExpression("actividad", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria createContactoCriteria() {
		return new ContactoDetachedCriteria(createCriteria("contacto"));
	}
	
	public ActividadDetachedCriteria createActividadCriteria() {
		return new ActividadDetachedCriteria(createCriteria("actividad"));
	}
	
	public Actividad_leida uniqueActividad_leida(PersistentSession session) {
		return (Actividad_leida) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Actividad_leida[] listActividad_leida(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Actividad_leida[]) list.toArray(new Actividad_leida[list.size()]);
	}
}

