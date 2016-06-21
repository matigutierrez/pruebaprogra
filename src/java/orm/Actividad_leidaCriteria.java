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

public class Actividad_leidaCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final StringExpression visto;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	public final IntegerExpression actividadId;
	public final AssociationExpression actividad;
	
	public Actividad_leidaCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		visto = new StringExpression("visto", this);
		contactoId = new IntegerExpression("contacto.uid", this);
		contacto = new AssociationExpression("contacto", this);
		actividadId = new IntegerExpression("actividad.uid", this);
		actividad = new AssociationExpression("actividad", this);
	}
	
	public Actividad_leidaCriteria(PersistentSession session) {
		this(session.createCriteria(Actividad_leida.class));
	}
	
	public Actividad_leidaCriteria() throws PersistentException {
		this(orm.AdministracionContactosPersistentManager.instance().getSession());
	}
	
	public ContactoCriteria createContactoCriteria() {
		return new ContactoCriteria(createCriteria("contacto"));
	}
	
	public ActividadCriteria createActividadCriteria() {
		return new ActividadCriteria(createCriteria("actividad"));
	}
	
	public Actividad_leida uniqueActividad_leida() {
		return (Actividad_leida) super.uniqueResult();
	}
	
	public Actividad_leida[] listActividad_leida() {
		java.util.List list = super.list();
		return (Actividad_leida[]) list.toArray(new Actividad_leida[list.size()]);
	}
}

