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

public class Actividad_leida {
	public Actividad_leida() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_ACTIVIDAD_LEIDA_CONTACTO) {
			this.contacto = (orm.Contacto) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_ACTIVIDAD_LEIDA_ACTIVIDAD) {
			this.actividad = (orm.Actividad) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int uid;
	
	private String visto;
	
	private orm.Contacto contacto;
	
	private orm.Actividad actividad;
	
	private void setUid(int value) {
		this.uid = value;
	}
	
	public int getUid() {
		return uid;
	}
	
	public int getORMID() {
		return getUid();
	}
	
	public void setVisto(String value) {
		this.visto = value;
	}
	
	public String getVisto() {
		return visto;
	}
	
	public void setContacto(orm.Contacto value) {
		if (contacto != null) {
			contacto.actividad_leida.remove(this);
		}
		if (value != null) {
			value.actividad_leida.add(this);
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
	
	public void setActividad(orm.Actividad value) {
		if (actividad != null) {
			actividad.actividad_leida.remove(this);
		}
		if (value != null) {
			value.actividad_leida.add(this);
		}
	}
	
	public orm.Actividad getActividad() {
		return actividad;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Actividad(orm.Actividad value) {
		this.actividad = value;
	}
	
	private orm.Actividad getORM_Actividad() {
		return actividad;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
