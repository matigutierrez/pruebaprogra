package capaNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import orm.Notificacion;


public class notificacion {

	private int uid;
	private Date fecha;
	private String mensaje;
	private int uid_grupo;

	public int getUid() {
		return this.uid;
	}

	/**
	 * 
	 * @param uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	/**
	 * 
	 * @param mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void enviarNotificacion() {
		// TODO - implement notificacion.enviarNotificacion
		throw new UnsupportedOperationException();
	}

	public int getUid_grupo() {
		return this.uid_grupo;
	}

	/**
	 * 
	 * @param uid_grupo
	 */
	public void setUid_grupo(int uid_grupo) {
		this.uid_grupo = uid_grupo;
	}
        public int agregarNotificacionCapaNegocio(notificacion notificacion,Grupo grupo) throws PersistentException {
		int respuesta=0;
                PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
                try {
                    orm.Notificacion lormNotificacion = orm.NotificacionDAO.createNotificacion();
                    lormNotificacion.setFecha(Calendar.getInstance().getTime()); 
                    lormNotificacion.setMensaje(notificacion.getMensaje());
                    orm.Grupo grupoOrm = orm.GrupoDAO.loadGrupoByORMID(grupo.getUid());
                    lormNotificacion.setGrupo(grupoOrm);
                    grupoOrm.notificacion.add(lormNotificacion);
                    orm.NotificacionDAO.save(lormNotificacion);
                    t.commit();
                    respuesta = lormNotificacion.getUid();
            } catch (Exception e) {
                 t.rollback();
            }
                return respuesta;
	}
        
        
        /*public int agregarNotificacionAGrupo(Notificacion notificacion,Grupo grupo) throws PersistentException {
        int respuesta = 0;
        PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
        try {
                    
            orm.Notificacion notificacionOrm = orm.NotificacionDAO.loadNotificacionByORMID(notificacion.getUid());
                      
            orm.Grupo grupoOrm = orm.GrupoDAO.loadGrupoByORMID(grupo.getUid());
            
            
            notificacionOrm.setGrupo(grupoOrm);
            grupoOrm.notificacion.add(notificacionOrm);
            
            
           
            t.commit();
            respuesta = notificacionOrm.getUid();
        } catch (Exception e) {
            t.rollback();
        }
        return respuesta;
    }*/
        public int grabarMensajesAUnContacto (notificacion notificacion,Contacto contacto) throws PersistentException{
            
            int respuesta =0;
            PersistentTransaction t = orm.AdministracionContactosPersistentManager.instance().getSession().beginTransaction();
            
            try {
                orm.Notificacion notificacionOrm =  orm.NotificacionDAO.loadNotificacionByORMID(notificacion.getUid());
                orm.Notificacion_leida lormNotificacion_leida = orm.Notificacion_leidaDAO.createNotificacion_leida();
                
                //for ( Contacto contacto : grupo.busquedaContactoGrupo(grupo.busquedaMembresiaGrupo(grupo))){
                
                orm.Contacto contactoOrm = orm.ContactoDAO.loadContactoByORMID(contacto.getUid());
                
                
                lormNotificacion_leida.setVisto("0");
                lormNotificacion_leida.setContacto(contactoOrm);
                lormNotificacion_leida.setNotificacion(notificacionOrm);
                //notificacionOrm.notificacion_leida.add(lormNotificacion_leida);
                orm.Notificacion_leidaDAO.save(lormNotificacion_leida);
               // }
               respuesta=lormNotificacion_leida.getUid();
            } catch (Exception e) {
                t.rollback();
            }
           return respuesta;
        }
        public List<orm.Notificacion_leida> busquedaNotificacionLeidaGrupo(notificacion notificacion) throws PersistentException {
                String busqueda="1";
		List<orm.Notificacion_leida> listaNotificacionesleidas = new ArrayList<orm.Notificacion_leida>();
                List<orm.Notificacion> listaNotificaciones = new ArrayList<orm.Notificacion>();
                 List<orm.Notificacion_leida> listas = new ArrayList<orm.Notificacion_leida>(); 
                
                //listaNotificacionesleidas = orm.Notificacion_leidaDAO.queryNotificacion_leida("notificacion_leida.visto='" + busqueda + "'  or notificacion_leida.notificacion_id='"+notificacion.getUid()+"' ", null);
                listaNotificaciones=orm.NotificacionDAO.queryNotificacion("Notificacion.uid='" + notificacion.getUid() + "' ", null);
                orm.Notificacion_leida [] listaMC = new orm.Notificacion_leida[listaNotificaciones.size()];
                if (listaNotificaciones != null) {
                    for (orm.Notificacion notificacionOrm  : listaNotificaciones) {
                        
                        listaMC = notificacionOrm.notificacion_leida.toArray();
                        
                    }
                    
                }
            listaNotificacionesleidas = Arrays.asList(listaMC);
            for(int i=0; i<listaNotificacionesleidas.size(); i++){
            if(listaNotificacionesleidas.get(i).getVisto().equals("1")){
              listas.add(listaNotificacionesleidas.get(i));
            }
            }
  
            return listas;    
	}
        public List<Contacto> busquedaContactoleido (List<orm.Notificacion_leida>busquedaNotificacionLeida){
            List<Contacto>listaContacto = new ArrayList<Contacto>();
            for (int i = 0; i < busquedaNotificacionLeida.size(); i++) {
                Contacto contacto = new Contacto();
                contacto.setUid(busquedaNotificacionLeida.get(i).getContacto().getUid());
                contacto.setNombre(busquedaNotificacionLeida.get(i).getContacto().getNombre());
                contacto.setApellido(busquedaNotificacionLeida.get(i).getContacto().getApellido());
                contacto.setTelefono(busquedaNotificacionLeida.get(i).getContacto().getTelefono());
                contacto.setMail(busquedaNotificacionLeida.get(i).getContacto().getMail());
                contacto.setCiudad(busquedaNotificacionLeida.get(i).getContacto().getCiudad());
                contacto.setEmpresa(busquedaNotificacionLeida.get(i).getContacto().getEmpresa());
                contacto.setImagenes(busquedaNotificacionLeida.get(i).getContacto().getImagenes());
                
                listaContacto.add(contacto);
            }
            return listaContacto;
        }

}