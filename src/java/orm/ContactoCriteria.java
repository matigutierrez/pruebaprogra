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

public class ContactoCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression mail;
	public final StringExpression telefono;
	public final StringExpression ciudad;
	public final StringExpression empresa;
	public final StringExpression imagenes;
	public final CollectionExpression membresia;
	public final CollectionExpression actividad_leida;
	public final CollectionExpression notificacion_leida;
	
	public ContactoCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		nombre = new StringExpression("nombre", this);
		apellido = new StringExpression("apellido", this);
		mail = new StringExpression("mail", this);
		telefono = new StringExpression("telefono", this);
		ciudad = new StringExpression("ciudad", this);
		empresa = new StringExpression("empresa", this);
		imagenes = new StringExpression("imagenes", this);
		membresia = new CollectionExpression("ORM_Membresia", this);
		actividad_leida = new CollectionExpression("ORM_Actividad_leida", this);
		notificacion_leida = new CollectionExpression("ORM_Notificacion_leida", this);
	}
	
	public ContactoCriteria(PersistentSession session) {
		this(session.createCriteria(Contacto.class));
	}
	
	public ContactoCriteria() throws PersistentException {
		this(orm.AdministracionContactosPersistentManager.instance().getSession());
	}
	
	public MembresiaCriteria createMembresiaCriteria() {
		return new MembresiaCriteria(createCriteria("ORM_Membresia"));
	}
	
	public Actividad_leidaCriteria createActividad_leidaCriteria() {
		return new Actividad_leidaCriteria(createCriteria("ORM_Actividad_leida"));
	}
	
	public Notificacion_leidaCriteria createNotificacion_leidaCriteria() {
		return new Notificacion_leidaCriteria(createCriteria("ORM_Notificacion_leida"));
	}
	
	public Contacto uniqueContacto() {
		return (Contacto) super.uniqueResult();
	}
	
	public Contacto[] listContacto() {
		java.util.List list = super.list();
		return (Contacto[]) list.toArray(new Contacto[list.size()]);
	}
}

