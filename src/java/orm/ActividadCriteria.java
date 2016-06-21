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

public class ActividadCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final DateExpression fecha;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final IntegerExpression grupoId;
	public final AssociationExpression grupo;
	public final CollectionExpression actividad_leida;
	
	public ActividadCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		fecha = new DateExpression("fecha", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		grupoId = new IntegerExpression("grupo.uid", this);
		grupo = new AssociationExpression("grupo", this);
		actividad_leida = new CollectionExpression("ORM_Actividad_leida", this);
	}
	
	public ActividadCriteria(PersistentSession session) {
		this(session.createCriteria(Actividad.class));
	}
	
	public ActividadCriteria() throws PersistentException {
		this(orm.AdministracionContactosPersistentManager.instance().getSession());
	}
	
	public GrupoCriteria createGrupoCriteria() {
		return new GrupoCriteria(createCriteria("grupo"));
	}
	
	public Actividad_leidaCriteria createActividad_leidaCriteria() {
		return new Actividad_leidaCriteria(createCriteria("ORM_Actividad_leida"));
	}
	
	public Actividad uniqueActividad() {
		return (Actividad) super.uniqueResult();
	}
	
	public Actividad[] listActividad() {
		java.util.List list = super.list();
		return (Actividad[]) list.toArray(new Actividad[list.size()]);
	}
}

