package dispatch;

import factory.*;
import factory.

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

        this.locacion = FactoryLocacion.factoryGetLocacion(locacion);   
        this.remuneracion = FactoryRemuneracion.factoryGetRemuneracion(remuneracion);
        this.cargaHoraria = FactoryCargaHoraria.factoryGetCargaHoraria(cargaHoraria);
        this.tipoPuesto = FactoryTipodePuesto.factoryGetTipodePuesto(tipoPuesto);
        this.rangoEtario = FactoryRangoEtario.factoryGetRangoEtario(rangoEtario);
        this.experienciaprevia = FactoryExperienciaPrevia.factoryGetExperienciaPrevia(experienciaprevia);
        this.cursados = FactoryEstudiosCursados.factoryGetEstudiosCursados(cursados);
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


}