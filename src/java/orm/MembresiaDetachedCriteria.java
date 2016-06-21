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

public class MembresiaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression uid;
	public final IntegerExpression contactoId;
	public final AssociationExpression contacto;
	public final IntegerExpression grupoId;
	public final AssociationExpression grupo;
	
	public MembresiaDetachedCriteria() {
		super(orm.Membresia.class, orm.MembresiaCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.uid", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
		grupoId = new IntegerExpression("grupo.uid", this.getDetachedCriteria());
		grupo = new AssociationExpression("grupo", this.getDetachedCriteria());
	}
	
	public MembresiaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.MembresiaCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		contactoId = new IntegerExpression("contacto.uid", this.getDetachedCriteria());
		contacto = new AssociationExpression("contacto", this.getDetachedCriteria());
		grupoId = new IntegerExpression("grupo.uid", this.getDetachedCriteria());
		grupo = new AssociationExpression("grupo", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria createContactoCriteria() {
		return new ContactoDetachedCriteria(createCriteria("contacto"));
	}
	
	public GrupoDetachedCriteria createGrupoCriteria() {
		return new GrupoDetachedCriteria(createCriteria("grupo"));
	}
	
	public Membresia uniqueMembresia(PersistentSession session) {
		return (Membresia) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Membresia[] listMembresia(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Membresia[]) list.toArray(new Membresia[list.size()]);
	}
}

