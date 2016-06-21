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

public class Grupo {
	public Grupo() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_GRUPO_MEMBRESIA) {
			return ORM_membresia;
		}
		else if (key == orm.ORMConstants.KEY_GRUPO_NOTIFICACION) {
			return ORM_notificacion;
		}
		else if (key == orm.ORMConstants.KEY_GRUPO_ACTIVIDAD) {
			return ORM_actividad;
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
	
	private String descripcion;
	
	private java.util.Date fecha;
	
	private java.util.Set ORM_membresia = new java.util.HashSet();
	
	private java.util.Set ORM_notificacion = new java.util.HashSet();
	
	private java.util.Set ORM_actividad = new java.util.HashSet();
	
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
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setFecha(java.util.Date value) {
		this.fecha = value;
	}
	
	public java.util.Date getFecha() {
		return fecha;
	}
	
	private void setORM_Membresia(java.util.Set value) {
		this.ORM_membresia = value;
	}
	
	private java.util.Set getORM_Membresia() {
		return ORM_membresia;
	}
	
	public final orm.MembresiaSetCollection membresia = new orm.MembresiaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_GRUPO_MEMBRESIA, orm.ORMConstants.KEY_MEMBRESIA_GRUPO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Notificacion(java.util.Set value) {
		this.ORM_notificacion = value;
	}
	
	private java.util.Set getORM_Notificacion() {
		return ORM_notificacion;
	}
	
	public final orm.NotificacionSetCollection notificacion = new orm.NotificacionSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_GRUPO_NOTIFICACION, orm.ORMConstants.KEY_NOTIFICACION_GRUPO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Actividad(java.util.Set value) {
		this.ORM_actividad = value;
	}
	
	private java.util.Set getORM_Actividad() {
		return ORM_actividad;
	}
	
	public final orm.ActividadSetCollection actividad = new orm.ActividadSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_GRUPO_ACTIVIDAD, orm.ORMConstants.KEY_ACTIVIDAD_GRUPO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
