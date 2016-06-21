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

public class ActividadDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression uid;
	public final DateExpression fecha;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final IntegerExpression grupoId;
	public final AssociationExpression grupo;
	public final CollectionExpression actividad_leida;
	
	public ActividadDetachedCriteria() {
		super(orm.Actividad.class, orm.ActividadCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		grupoId = new IntegerExpression("grupo.uid", this.getDetachedCriteria());
		grupo = new AssociationExpression("grupo", this.getDetachedCriteria());
		actividad_leida = new CollectionExpression("ORM_Actividad_leida", this.getDetachedCriteria());
	}
	
	public ActividadDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ActividadCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		fecha = new DateExpression("fecha", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		grupoId = new IntegerExpression("grupo.uid", this.getDetachedCriteria());
		grupo = new AssociationExpression("grupo", this.getDetachedCriteria());
		actividad_leida = new CollectionExpression("ORM_Actividad_leida", this.getDetachedCriteria());
	}
	
	public GrupoDetachedCriteria createGrupoCriteria() {
		return new GrupoDetachedCriteria(createCriteria("grupo"));
	}
	
	public Actividad_leidaDetachedCriteria createActividad_leidaCriteria() {
		return new Actividad_leidaDetachedCriteria(createCriteria("ORM_Actividad_leida"));
	}
	
	public Actividad uniqueActividad(PersistentSession session) {
		return (Actividad) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Actividad[] listActividad(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Actividad[]) list.toArray(new Actividad[list.size()]);
	}
}

