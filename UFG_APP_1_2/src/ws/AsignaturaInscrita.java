// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build R59)

package ws;


public class AsignaturaInscrita {
    protected java.lang.String idAsignatura;
    protected java.lang.String nombreAsignatura;
    protected java.lang.String grupo;
    protected ws.Evaluaciones evaluaciones;
    
    public AsignaturaInscrita() {
    }
    
    public AsignaturaInscrita(java.lang.String idAsignatura, java.lang.String nombreAsignatura, java.lang.String grupo, ws.Evaluaciones evaluaciones) {
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.grupo = grupo;
        this.evaluaciones = evaluaciones;
    }
    
    public java.lang.String getIdAsignatura() {
        return idAsignatura;
    }
    
    public void setIdAsignatura(java.lang.String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    
    public java.lang.String getNombreAsignatura() {
        return nombreAsignatura;
    }
    
    public void setNombreAsignatura(java.lang.String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    
    public java.lang.String getGrupo() {
        return grupo;
    }
    
    public void setGrupo(java.lang.String grupo) {
        this.grupo = grupo;
    }
    
    public ws.Evaluaciones getEvaluaciones() {
        return evaluaciones;
    }
    
    public void setEvaluaciones(ws.Evaluaciones evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
}