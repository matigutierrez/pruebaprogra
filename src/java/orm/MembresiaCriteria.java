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

public class MembresiaCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	public final IntegerExpression grupoId;
	public final AssociationExpression grupo;
	
	public MembresiaCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		contactoId = new IntegerExpression("contacto.uid", this);
		contacto = new AssociationExpression("contacto", this);
		grupoId = new IntegerExpression("grupo.uid", this);
		grupo = new AssociationExpression("grupo", this);
	}
	
	public MembresiaCriteria(PersistentSession session) {
		this(session.createCriteria(Membresia.class));
	}
	
	public MembresiaCriteria() throws PersistentException {
		this(orm.AdministracionContactosPersistentManager.instance().getSession());
	}
	
	public ContactoCriteria createContactoCriteria() {
		return new ContactoCriteria(createCriteria("contacto"));
	}
	
	public GrupoCriteria createGrupoCriteria() {
		return new GrupoCriteria(createCriteria("grupo"));
	}
	
	public Membresia uniqueMembresia() {
		return (Membresia) super.uniqueResult();
	}
	
	public Membresia[] listMembresia() {
		java.util.List list = super.list();
		return (Membresia[]) list.toArray(new Membresia[list.size()]);
	}
}

