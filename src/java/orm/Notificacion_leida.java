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

public class Notificacion_leida {
	public Notificacion_leida() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_NOTIFICACION_LEIDA_NOTIFICACION) {
			this.notificacion = (orm.Notificacion) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_NOTIFICACION_LEIDA_CONTACTO) {
			this.contacto = (orm.Contacto) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int uid;
	
	private String visto;
	
	private orm.Notificacion notificacion;
	
	private orm.Contacto contacto;
	
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
	
	public void setNotificacion(orm.Notificacion value) {
		if (notificacion != null) {
			notificacion.notificacion_leida.remove(this);
		}
		if (value != null) {
			value.notificacion_leida.add(this);
		}
	}
	
	public orm.Notificacion getNotificacion() {
		return notificacion;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Notificacion(orm.Notificacion value) {
		this.notificacion = value;
	}
	
	private orm.Notificacion getORM_Notificacion() {
		return notificacion;
	}
	
	public void setContacto(orm.Contacto value) {
		if (contacto != null) {
			contacto.notificacion_leida.remove(this);
		}
		if (value != null) {
			value.notificacion_leida.add(this);
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
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
