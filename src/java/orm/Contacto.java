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

public class Contacto {
	public Contacto() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_CONTACTO_MEMBRESIA) {
			return ORM_membresia;
		}
		else if (key == orm.ORMConstants.KEY_CONTACTO_ACTIVIDAD_LEIDA) {
			return ORM_actividad_leida;
		}
		else if (key == orm.ORMConstants.KEY_CONTACTO_NOTIFICACION_LEIDA) {
			return ORM_notificacion_leida;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int uid;
	
	private String nombre;
	
	private String apellido;
	
	private String mail;
	
	private String telefono;
	
	private String ciudad;
	
	private String empresa;
	
	private String imagenes;
	
	private java.util.Set ORM_membresia = new java.util.HashSet();
	
	private java.util.Set ORM_actividad_leida = new java.util.HashSet();
	
	private java.util.Set ORM_notificacion_leida = new java.util.HashSet();
	
	private void setUid(int value) {
		this.uid = value;
	}
	
	public int getUid() {
		return uid;
	}
	
	public int getORMID() {
		return getUid();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setMail(String value) {
		this.mail = value;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setCiudad(String value) {
		this.ciudad = value;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setEmpresa(String value) {
		this.empresa = value;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	
	public void setImagenes(String value) {
		this.imagenes = value;
	}
	
	public String getImagenes() {
		return imagenes;
	}
	
	private void setORM_Membresia(java.util.Set value) {
		this.ORM_membresia = value;
	}
	
	private java.util.Set getORM_Membresia() {
		return ORM_membresia;
	}
	
	public final orm.MembresiaSetCollection membresia = new orm.MembresiaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CONTACTO_MEMBRESIA, orm.ORMConstants.KEY_MEMBRESIA_CONTACTO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Actividad_leida(java.util.Set value) {
		this.ORM_actividad_leida = value;
	}
	
	private java.util.Set getORM_Actividad_leida() {
		return ORM_actividad_leida;
	}
	
	public final orm.Actividad_leidaSetCollection actividad_leida = new orm.Actividad_leidaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CONTACTO_ACTIVIDAD_LEIDA, orm.ORMConstants.KEY_ACTIVIDAD_LEIDA_CONTACTO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notificacion_leida(java.util.Set value) {
		this.ORM_notificacion_leida = value;
	}
	
	private java.util.Set getORM_Notificacion_leida() {
		return ORM_notificacion_leida;
	}
	
	public final orm.Notificacion_leidaSetCollection notificacion_leida = new orm.Notificacion_leidaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CONTACTO_NOTIFICACION_LEIDA, orm.ORMConstants.KEY_NOTIFICACION_LEIDA_CONTACTO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
