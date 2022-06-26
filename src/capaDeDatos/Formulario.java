package capaDeDatos;

import formulario.CargaHoraria;
import formulario.EstudiosCursados;
import formulario.ExperienciaPrevia;
import formulario.FactoryCargaHoraria;
import formulario.FactoryEstudiosCursados;
import formulario.FactoryExperienciaPrevia;
import formulario.FactoryLocacion;
import formulario.FactoryRangoEtario;
import formulario.FactoryRemuneracion;
import formulario.FactoryTipodePuesto;
import formulario.Locacion;
import formulario.RangoEtario;
import formulario.Remuneracion;
import formulario.TipodePuesto;

/**
 * <br>
 * Formulario de busqueda con los datos necesarios para operar.
 */
public class Formulario {
    private Locacion locacion;
    private Remuneracion remuneracion;
    private CargaHoraria cargaHoraria;
    private TipodePuesto tipoPuesto;
    private ExperienciaPrevia experienciaprevia;
    private RangoEtario rangoEtario;
    private EstudiosCursados cursados;
    private double remuneraciondoub;

    public Formulario(String locacion, double remuneracion, String cargaHoraria, String tipoPuesto, int rangoEtario,
            String experienciaprevia, String cursados) {

        this.locacion = FactoryLocacion.getLocacion(locacion);   
        this.remuneracion = FactoryRemuneracion.getRemuneracion(remuneracion);
        this.cargaHoraria = FactoryCargaHoraria.getCargaHoraria(cargaHoraria);
        this.tipoPuesto = FactoryTipodePuesto.getTipodePuesto(tipoPuesto);
        this.rangoEtario = FactoryRangoEtario.getRangoEtario(rangoEtario);
        this.experienciaprevia = FactoryExperienciaPrevia.getExperienciaPrevia(experienciaprevia);
        this.cursados = FactoryEstudiosCursados.getEstudiosCursados(cursados);
        this.remuneraciondoub=remuneracion;
    }

    
    public Locacion getLocacion() {
        return locacion;
    }

    public double getRemuneraciondoub() {
		return remuneraciondoub;
	}

	public Remuneracion getRemuneracion() {
        return remuneracion;
    }

    public CargaHoraria getCargaHoraria() {
        return cargaHoraria;
    }

    public TipodePuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public ExperienciaPrevia getExperienciaPrevia() {
        return experienciaprevia;
    }

    public RangoEtario getRangoEtario() {
        return rangoEtario;
    }

    public EstudiosCursados getEstudiosCursados() {
        return cursados;
    }


	@Override
	public String toString() {
		return  "\nLocacion: "+locacion + "\n" +"Remuneracion: "+ remuneraciondoub  + "\n" +"Carga horaria: "+ cargaHoraria
				+ "\n" +"Tipo de puesto: "+ tipoPuesto  + "\n" +"Experiencia previa: "+ experienciaprevia 
				+ "\n" +"Rango etario: "+ rangoEtario + "\n" +"Estudios cursados: "+ cursados ;
	}


}