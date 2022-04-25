package formulario;


/**
 * @author mikel
 * Crea la clase formulario, para que esta se cree en la funcion que lo invoca, se deben validar todos los datos
 */
public class Formulario {
    private Locacion locacion;
    private Remuneracion remuneracion;
    private CargaHoraria cargaHoraria;
    private TipodePuesto tipoPuesto;
    private ExperienciaPrevia experienciaprevia;
    private RangoEtario rangoEtario;
    private EstudiosCursados cursados;

    public Formulario(String locacion, String remuneracion, String cargaHoraria, String tipoPuesto, String rangoEtario,
            String experienciaprevia, String cursados) {

        this.locacion = FactoryLocacion.getLocacion(locacion);   
        this.remuneracion = FactoryRemuneracion.getRemuneracion(remuneracion);
        this.cargaHoraria = FactoryCargaHoraria.getCargaHoraria(cargaHoraria);
        this.tipoPuesto = FactoryTipodePuesto.getTipodePuesto(tipoPuesto);
        this.rangoEtario = FactoryRangoEtario.getRangoEtario(rangoEtario);
        this.experienciaprevia = FactoryExperienciaPrevia.getExperienciaPrevia(experienciaprevia);
        this.cursados = FactoryEstudiosCursados.getEstudiosCursados(cursados);
    }

    
    public Locacion getLocacion() {
        return locacion;
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
		return "locacion=" + locacion + ", remuneracion=" + remuneracion + ", cargaHoraria=" + cargaHoraria
				+ ", tipoPuesto=" + tipoPuesto + ", experienciaprevia=" + experienciaprevia + ", rangoEtario="
				+ rangoEtario + ", cursados=" + cursados ;
	}


}