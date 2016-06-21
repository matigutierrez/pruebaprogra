/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaServicio;

import capaNegocio.Actividad;
import capaNegocio.Contacto;
import capaNegocio.Grupo;
import capaNegocio.notificacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.orm.PersistentException;
import orm.Membresia;
import orm.Notificacion;

/**
 *
 * @author Adrian
 */
@WebService(serviceName = "Servicio")
public class Servicio {

   
    @WebMethod(operationName = "busquedaGruposContacto")
    public String busquedaGruposContacto(@WebParam(name = "uidContacto") int uidContacto) {
        
        String listaResultado = "no se encontro el grupo";
        List<Grupo> lista = new ArrayList<Grupo>();
            Gson gson = new GsonBuilder().create();
            
            capaNegocio.Contacto contacto = new capaNegocio.Contacto();
            contacto.setUid(uidContacto);
          
        try {
            
            lista = contacto.busquedaGruposContacto(contacto.busquedaMembresiaContacto(contacto));
            
          
            listaResultado = gson.toJson(lista);
             
            
        } catch (PersistentException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            return listaResultado;
    }
    
    @WebMethod(operationName = "busquedaContactoGrupos")
    public String busquedaContactoGrupos(@WebParam(name = "uidGrupo") int uidGrupo) {
        
        String listaResultado = "no se encontro el grupo";
        List<Contacto> lista = new ArrayList<Contacto>();
            Gson gson = new GsonBuilder().create();
            
            capaNegocio.Grupo grupo = new capaNegocio.Grupo();
            grupo.setUid(uidGrupo);
          
        try {
            
            lista = grupo.busquedaContactoGrupo(grupo.busquedaMembresiaGrupo(grupo));
            
          
            listaResultado = gson.toJson(lista);
             
            
        } catch (PersistentException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            return listaResultado;
    }

    
    @WebMethod(operationName = "agregarContactoServicioWeb")
    public String agregarContactoServicioWeb(@WebParam(name = "nombreContacto") String nombreContacto,
            @WebParam(name = "apellidoContacto") String apellidoContacto, 
            @WebParam(name = "telefonoContacto") String telefonoContacto, 
            @WebParam(name = "mailContacto") String mailContacto, 
            @WebParam(name = "empresaContacto") String empresaContacto, 
            @WebParam(name = "ciudadContacto") String ciudadContacto,
            @WebParam(name = "imagenContacto") String imagenContacto ){
        
        String respuesta ="no se puede almacenar cotacto";
        
        
        Contacto contacto = new  Contacto();
        contacto.setNombre(nombreContacto);
        contacto.setApellido(apellidoContacto);
        contacto.setCiudad(ciudadContacto);
        contacto.setEmpresa(empresaContacto);
        contacto.setMail(mailContacto);
        contacto.setTelefono(telefonoContacto);
        contacto.setImagenes(imagenContacto);
        
        try{
            int resultado = contacto.agregarContactoCapaNegocio(contacto);
            if (resultado != 0) {
                respuesta = "creacion  del contacto exitoso, su uid  es " + resultado;
                                
            }
        }catch(PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE,null, ex);
        }
                
        
        return respuesta;
    }

    /**
     * Web service operation
     */
     @WebMethod(operationName = "eliminarContactoServicioWeb")
    public String eliminarContactoServicioWeb(@WebParam(name = "uidContacto") int uidContacto
            ) throws PersistentException{
       
        String respuesta = "no se ha podido eliminar el Contacto";
        
        capaNegocio.Contacto contacto = new capaNegocio.Contacto();
        contacto.setUid(uidContacto);
        
        try {
            int resultado = contacto.eliminarContactoCapaNegocio(contacto);
            if (resultado != 0){
                respuesta = "se ha eliminado el Contacto cuyo uid es: " + resultado;
            }
        } catch (PersistentException ex){
            //Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
     

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editarContactoServicioWeb")
    public String editarContactoServicioWeb(@WebParam(name = "uidContacto") int uidContacto,
            @WebParam(name = "nuevoNombreContacto") String nuevoNombreContacto, 
            @WebParam(name = "nuevoApellidoContacto") String nuevoApellidoContacto, 
            @WebParam(name = "nuevoTelefonoContacto") String nuevoTelefonoContacto,
            @WebParam(name = "nuevoMailContacto") String nuevoMailContacto, 
            @WebParam(name = "nuevoCiudadContacto") String nuevoCiudadContacto, 
            @WebParam(name = "nuevoEmpresaContacto") String nuevoEmpresaContacto, 
            @WebParam(name = "nuevoImagenContacto") String nuevoImagenContacto) {
        
        
         String respuesta = "no se ha editado el contacto";
        
        
        Contacto contacto = new Contacto();
        contacto.setUid(uidContacto);
        contacto.setApellido(nuevoApellidoContacto);
        
        contacto.setNombre(nuevoNombreContacto);
        contacto.setMail(nuevoMailContacto);
        contacto.setTelefono(nuevoTelefonoContacto);
        contacto.setCiudad(nuevoCiudadContacto);
        contacto.setEmpresa(nuevoEmpresaContacto);
        contacto.setImagenes(nuevoImagenContacto);
        
        try {
            int resultado = contacto.editarContactoCapanegocio(contacto);
            if (resultado != 0){
                respuesta = "se ha modificado el contacto cuyo uid es: " + resultado;
            }
        } catch (PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "busquedaSimple")
    public String busquedaSimple(@WebParam(name = "textoBusqueda") String textoBusqueda) {
        
        String listaResultado = "";
        List<Contacto> lista = new ArrayList<Contacto>();
            Gson gson = new GsonBuilder().create();
        try {
            Contacto contacto = new Contacto();
            lista = contacto.busquedaSimpleContacto(textoBusqueda);
            listaResultado = gson.toJson(lista );
            
        } catch (PersistentException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listaResultado;
                
     }
    
    /**
     * Web service operation
     * @param nombre
     * @return 
     */
    @WebMethod(operationName = "busquedaAvanzada")
    public String busquedaAvanzada(@WebParam(name = "nombre") String nombre, 
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "telefono") String telefono, 
            @WebParam(name = "mail") String mail, 
            @WebParam(name = "ciudad") String ciudad, 
            @WebParam(name = "empresa") String empresa){
        
    
        String listaResultado = "";
        List<capaNegocio.Contacto> lista = new ArrayList<capaNegocio.Contacto>();
        capaNegocio.Contacto contacto = new capaNegocio.Contacto();
        if (apellido!=null){
            contacto.setApellido(apellido);
        }else{
            contacto.setApellido("");
        }
        if (nombre!=null){
            contacto.setNombre(nombre);
        }else{
            contacto.setNombre("");
        }
        if (telefono!=null){
            contacto.setTelefono(telefono);
        }else{
            contacto.setTelefono("");
        }
        if (mail!=null){
            contacto.setMail(mail);
        }else{
            contacto.setMail("");
        }
        if(ciudad!= null){
            contacto.setCiudad(ciudad);
        }else{
                contacto.setCiudad("");
        }
        if(empresa!=null){
            contacto.setEmpresa(empresa);
        }else{
            contacto.setEmpresa("");
        }
    
        Gson gson = new GsonBuilder().create();
        
        try {
            lista = contacto.busquedaAvanzadaContacto(contacto);
            listaResultado = gson.toJson(lista);
        } catch (PersistentException ex) {
            listaResultado=null;
        }
        return  listaResultado ;
        
    }
    
    @WebMethod(operationName = "agregarGrupoServicioWeb")
    public String agregarGrupoServicioWeb(@WebParam(name = "nombreGrupo") String nombreGrupo, 
            @WebParam(name = "descripcionGrupo") String descripcionGrupo 
            ) throws PersistentException{
        
        String respuesta = "no se pudo almacenar el contacto";
        Grupo grupo = new Grupo();
        grupo.setNombre(nombreGrupo);
        grupo.setDescripcion(descripcionGrupo);
        
        
        try {
            int resultado = grupo.agregarGrupoCapaNegocio(grupo);
            if (resultado != 0){
                respuesta = "creación del grupo exitoso, su uid es: " + resultado;
            }
        } catch (PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    
     @WebMethod(operationName = "editarGrupoServicioWeb")
    public String editarGrupoServicioWeb(@WebParam(name = "uidGrupo") int uidGrupo, 
            @WebParam(name = "nuevoNombreGrupo") String nuevoNombreGrupo, 
            @WebParam(name = "nuevoDescripcionGrupo") String nuevoDescripcionGrupo 
            ) throws PersistentException{
        
        String respuesta = "no se ha editado el Grupo";
        
        Grupo grupo= new Grupo();
        
        grupo.setUid(uidGrupo);
        grupo.setNombre(nuevoNombreGrupo);
        grupo.setDescripcion(nuevoDescripcionGrupo);
        
        
        try {
            int resultado = grupo.editarGrupoCapanegocio(grupo);
            if (resultado != 0){
                respuesta = "se ha modificado el grupo cuyo uid es: " + resultado;
            }
        } catch (PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
         return respuesta;
    }
    
        @WebMethod(operationName = "eliminarGrupoServicioWeb")
    public String eliminarGrupoServicioWeb(@WebParam(name = "uidGrupo") int uidGrupo
            ) throws PersistentException{
       
        String respuesta = "no se ha podido eliminar el Grupo";
        
        Grupo grupo = new Grupo();
        grupo.setUid(uidGrupo);
        
        try {
            int resultado = grupo.eliminarGrupoCapaNegocio(grupo);
            if (resultado != 0){
                respuesta = "se ha eliminado el grupo cuyo uid es: " + resultado;
            }
        } catch (PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
     
    @WebMethod(operationName = "agregarContactoAGrupo")
    public String agregarContactoAGrupo(@WebParam(name = "uidContacto") int uidContacto,
            @WebParam(name = "uidGrupo") int uidGrupo){
        
        String respuesta ="no se puede almacenar cotacto";
        capaNegocio.Contacto contacto =new capaNegocio.Contacto();
        capaNegocio.Grupo grupo = new capaNegocio.Grupo();
        
        contacto.setUid(uidContacto);
        grupo.setUid(uidGrupo);
        
        
        try{
            int resultado = grupo.agregarContactoAGrupo(contacto, grupo);
            if (resultado != 0) {
                respuesta = "se agrego correctamente un contacto al grupo " + resultado;
                                
            }
        }catch(PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE,null, ex);
        }
                
        
        return respuesta;
    }
     @WebMethod(operationName = "agregarActividadAGrupo")
    public String agregarActividadAGrupo(@WebParam(name = "uidActividad") int uidActividad,
            @WebParam(name = "uidContacto") int uidContacto){
        
        String respuesta ="no se puede almacenar cotacto";
        capaNegocio.Actividad actividad =new capaNegocio.Actividad();
        capaNegocio.Contacto grupo = new capaNegocio.Contacto();
        
        actividad.setUid(uidActividad);
        grupo.setUid(uidContacto);
        
        
        try{
            int resultado = actividad.agregarActividadAGrupo(actividad, grupo);
            if (resultado != 0) {
                respuesta = "se agrego la actividad al grupo " + resultado;
                                
            }
        }catch(PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE,null, ex);
        }
                
        
        return respuesta;
    }
    @WebMethod(operationName = "agregarActividadServicioWeb")
    public String agregarActividadServicioWeb(@WebParam(name = "nombreAct") String nombreAct, 
            @WebParam(name = "descripcionAct") String descripcionAct ,
            
            @WebParam(name = "uidGrupo") int uidGrupo
            ) throws PersistentException{
        
        String respuesta = "no se pudo almacenar el contacto";
        Actividad actividad = new Actividad();
        Grupo grupo=new Grupo();
        actividad.setNombre(nombreAct);
        actividad.setDescripcion(descripcionAct);
        
        grupo.setUid(uidGrupo);
        
        try {
            int resultado = actividad.agregarActividadCapaNegocio(actividad,grupo);
            if (resultado != 0){
                respuesta = "creación del grupo exitoso, su uid es: " + resultado;
            }
        } catch (PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    @WebMethod(operationName = "agregarNotificacionServicioWeb")
    public String agregarNotificacionServicioWeb( 
            @WebParam(name = "mensajeNot") String mensajeNot ,
            @WebParam(name = "uidGrupo") int uidGrupo
            ) throws PersistentException{
        
        String respuesta = "no se pudo almacenar el contacto";
        notificacion notifi = new notificacion();
        Grupo grupo=new Grupo();
        notifi.setMensaje(mensajeNot);
        grupo.setUid(uidGrupo);
        
        try {
            int resultado = notifi.agregarNotificacionCapaNegocio(notifi,grupo);
            if (resultado != 0){
                respuesta = "creación de la notificacion exitoso, su uid es: " + resultado;
            }
        } catch (PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    @WebMethod(operationName = "grabarMensajeAunContacto")
    public String grabarMensajeAunContacto(@WebParam(name = "uidNotificacion") int uidNotificacion,
            @WebParam(name = "uidContacto") int uidContacto
            ) throws PersistentException{
        
        String respuesta = "no se pudo crear la actividad";
        capaNegocio.notificacion notificacion = new capaNegocio.notificacion();
        Contacto contacto= new Contacto();
        contacto.setUid(uidContacto);
        notificacion.setUid(uidNotificacion);
 
        
        
        
        try {
            int resultado = notificacion.grabarMensajesAUnContacto(notificacion,contacto);
            if (resultado != 0){
                respuesta = "creación de la actividad exitosa, su uid es: " + resultado;
            }
        } catch (PersistentException ex){
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    @WebMethod(operationName = "busquedaContactosLeidos")
    public String busquedaContactosLeidos(@WebParam(name = "uidNotificacion") int uidNotificacion) {
        
        String listaResultado = "";
        List<Contacto> lista = new ArrayList<Contacto>();
            Gson gson = new GsonBuilder().create();
            
            capaNegocio.notificacion notificacion = new capaNegocio.notificacion();
            
          
        try {
            notificacion.setUid(uidNotificacion);
            lista = notificacion.busquedaContactoleido(notificacion.busquedaNotificacionLeidaGrupo(notificacion));
            
          
            listaResultado = gson.toJson(lista);
             
            
        } catch (PersistentException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            return listaResultado;
    }
    @WebMethod(operationName = "busquedaContactosActividadesLeidas")
    public String busquedaContactosActividadesLeidas(@WebParam(name = "uidActividad") int uidActividad) {
        
        String listaResultado = "";
        List<Contacto> lista = new ArrayList<Contacto>();
            Gson gson = new GsonBuilder().create();
            
            capaNegocio.Actividad actividad = new capaNegocio.Actividad();
            
          
        try {
            actividad.setUid(uidActividad);
            lista = actividad.busquedaContactoleidoActividad(actividad.busquedaActividadLeidaGrupo(actividad));
            
          
            listaResultado = gson.toJson(lista);
             
            
        } catch (PersistentException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            return listaResultado;
    }
}
    
