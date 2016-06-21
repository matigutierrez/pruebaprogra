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

public class Membresia {
	public Membresia() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_MEMBRESIA_CONTACTO) {
			this.contacto = (orm.Contacto) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_MEMBRESIA_GRUPO) {
			this.grupo = (orm.Grupo) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int uid;
	
	private orm.Contacto contacto;
	
	private orm.Grupo grupo;
	
	private void setUid(int value) {
		this.uid = value;
	}
	
	public int getUid() {
		return uid;
	}
	
	public int getORMID() {
		return getUid();
	}
	
	public void setContacto(orm.Contacto value) {
		if (contacto != null) {
			contacto.membresia.remove(this);
		}
		if (value != null) {
			value.membresia.add(this);
		}
	}
	
	public orm.Contacto getContacto() {
		return contacto;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Contacto(orm.Contacto value) {
		this.contacto = value;
	}
	
	private orm.Contacto getORM_Contacto() {
		return contacto;
	}
	
	public void setGrupo(orm.Grupo value) {
		if (grupo != null) {
			grupo.membresia.remove(this);
		}
		if (value != null) {
			value.membresia.add(this);
		}
	}
	
	public orm.Grupo getGrupo() {
		return grupo;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Grupo(orm.Grupo value) {
		this.grupo = value;
	}
	
	private orm.Grupo getORM_Grupo() {
		return grupo;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
