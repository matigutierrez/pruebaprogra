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

public class GrupoCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final DateExpression fecha;
	public final CollectionExpression membresia;
	public final CollectionExpression notificacion;
	public final CollectionExpression actividad;
	
	public GrupoCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		fecha = new DateExpression("fecha", this);
		membresia = new CollectionExpression("ORM_Membresia", this);
		notificacion = new CollectionExpression("ORM_Notificacion", this);
		actividad = new CollectionExpression("ORM_Actividad", this);
	}
	
	public GrupoCriteria(PersistentSession session) {
		this(session.createCriteria(Grupo.class));
	}
	
	public GrupoCriteria() throws PersistentException {
		this(orm.AdministracionContactosPersistentManager.instance().getSession());
	}
	
	public MembresiaCriteria createMembresiaCriteria() {
		return new MembresiaCriteria(createCriteria("ORM_Membresia"));
	}
	
	public NotificacionCriteria createNotificacionCriteria() {
		return new NotificacionCriteria(createCriteria("ORM_Notificacion"));
	}
	
	public ActividadCriteria createActividadCriteria() {
		return new ActividadCriteria(createCriteria("ORM_Actividad"));
	}
	
	public Grupo uniqueGrupo() {
		return (Grupo) super.uniqueResult();
	}
	
	public Grupo[] listGrupo() {
		java.util.List list = super.list();
		return (Grupo[]) list.toArray(new Grupo[list.size()]);
	}
}

