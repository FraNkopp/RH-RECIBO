package recibo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author FraNko
 */
@Entity
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String legajo;
    private String apellido;
    private String nombre;
    private String segundonombre;
    private String Mes;
    private String Anio;
    private String resp;
    private String respuesta;
    private double valorHoraNormal;
    private double valorHoraNoRem;
    private double premio1;
    private double premio2;
    private double feriado1;
    private double feriado2;
    private double extra1era;
    private double extra2da;
    private double bonificado;
    private double Bonificacion;
    private double extra100era;
    private double extra100da;
    private double hsnoct1era;
    private double hsnoct2da;
    private double horanoct50era;
    private double horanoct50da;
    private double ADELANTO;
    private double descuentoajuste;
    private double mercaderia;
    private double Comedor;
    private double pollo;
    private double supremacrispy;
    private double bocadito;
    private double medallon;
    private double nuguets;
    private double rikosaurio;
    private double cuartotrasero;
    private double salchichas;
    private double Comedor1;
    private double pollo1;
    private double supremacrispy1;
    private double bocadito1;
    private double medallon1;
    private double nuguets1;
    private double rikosaurio1;
    private double cuartotrasero1;
    private double salchichas1;
    private double permiso1eraQ;
    private double permiso2DaQ;
    private double compensacionMensual;
    private double valornorem;
    private double jubilacion;
    private double ley19032;
    private double obrasocial;
    private double obrasocialnorem;
    private double federacion;
    private double TotalRemunerativo;
    private double NoRemunerativo;
    private double TotalDescuentos;
    private double Neto;
    private double DiasPrimeraQ;
    private double diasSegundaQ;
    private double diasprimeraQui;
    private double diassegundaQui;
    private double Feriado1EraQ;
    private double Feriado2DaQ;
    private double HsExtra50EraQ;
    private double HsExtra50DaQ;
    private double HsExtra100EraQ;
    private double HsExtra100DaQ;
    private double HsNoct1EraQ;
    private double HsNoct2DaQ;
    private double HsExtraNoct50EraQ;
    private double HsExtraNoct50DaQ;
    private double permiso1era;
    private double permiso2da;
    private double sepelio;
    private double AjustedeSueldo;
    private double hsnoct1;
    private double hsnoct2;
    private double HsEnNegro;
    private double AuxHsEnNegro;
    private double valorHoraNegro;
    private double CuotaSindical;
    private double Resolucion;
    private double AFILIADO;
    private double comMer;
    private double merca;
    private double SUSPENSIONera;
    private double SUSPENSIONda;
/////////////////////////////////////
    private double noremnormal1;
    private double noctnorem1;
    private double noct50norem1;
    private double extra1;
    private double extraCien1;
    private double valornorem1;
    private double premiorem1;
    private double noremnormal2;
    private double noctnorem2;
    private double noct50norem2;
    private double extra2;
    private double extraCien2;
    private double valornorem2;
    private double premiorem2;

    public Recibo() {
    }

    public Recibo(int id, String legajo, String apellido, String nombre, String segundonombre, String Mes, String Anio, String resp, String respuesta, double valorHoraNormal, double valorHoraNoRem, double premio1, double premio2, double feriado1, double feriado2, double extra1era, double extra2da, double bonificado, double Bonificacion, double extra100era, double extra100da, double hsnoct1era, double hsnoct2da, double horanoct50era, double horanoct50da, double ADELANTO, double descuentoajuste, double mercaderia, double Comedor, double pollo, double supremacrispy, double bocadito, double medallon, double nuguets, double rikosaurio, double cuartotrasero, double salchichas, double Comedor1, double pollo1, double supremacrispy1, double bocadito1, double medallon1, double nuguets1, double rikosaurio1, double cuartotrasero1, double salchichas1, double permiso1eraQ, double permiso2DaQ, double compensacionMensual, double valornorem, double jubilacion, double ley19032, double obrasocial, double obrasocialnorem, double federacion, double TotalRemunerativo, double NoRemunerativo, double TotalDescuentos, double Neto, double DiasPrimeraQ, double diasSegundaQ, double diasprimeraQui, double diassegundaQui, double Feriado1EraQ, double Feriado2DaQ, double HsExtra50EraQ, double HsExtra50DaQ, double HsExtra100EraQ, double HsExtra100DaQ, double HsNoct1EraQ, double HsNoct2DaQ, double HsExtraNoct50EraQ, double HsExtraNoct50DaQ, double permiso1era, double permiso2da, double sepelio, double AjustedeSueldo, double hsnoct1, double hsnoct2, double HsEnNegro, double AuxHsEnNegro, double valorHoraNegro, double CuotaSindical, double Resolucion, double AFILIADO, double comMer, double merca, double SUSPENSIONera, double SUSPENSIONda, double noremnormal1, double noctnorem1, double noct50norem1, double extra1, double extraCien1, double valornorem1, double premiorem1, double noremnormal2, double noctnorem2, double noct50norem2, double extra2, double extraCien2, double valornorem2, double premiorem2) {
        this.id = id;
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.segundonombre = segundonombre;
        this.Mes = Mes;
        this.Anio = Anio;
        this.resp = resp;
        this.respuesta = respuesta;
        this.valorHoraNormal = valorHoraNormal;
        this.valorHoraNoRem = valorHoraNoRem;
        this.premio1 = premio1;
        this.premio2 = premio2;
        this.feriado1 = feriado1;
        this.feriado2 = feriado2;
        this.extra1era = extra1era;
        this.extra2da = extra2da;
        this.bonificado = bonificado;
        this.Bonificacion = Bonificacion;
        this.extra100era = extra100era;
        this.extra100da = extra100da;
        this.hsnoct1era = hsnoct1era;
        this.hsnoct2da = hsnoct2da;
        this.horanoct50era = horanoct50era;
        this.horanoct50da = horanoct50da;
        this.ADELANTO = ADELANTO;
        this.descuentoajuste = descuentoajuste;
        this.mercaderia = mercaderia;
        this.Comedor = Comedor;
        this.pollo = pollo;
        this.supremacrispy = supremacrispy;
        this.bocadito = bocadito;
        this.medallon = medallon;
        this.nuguets = nuguets;
        this.rikosaurio = rikosaurio;
        this.cuartotrasero = cuartotrasero;
        this.salchichas = salchichas;
        this.Comedor1 = Comedor1;
        this.pollo1 = pollo1;
        this.supremacrispy1 = supremacrispy1;
        this.bocadito1 = bocadito1;
        this.medallon1 = medallon1;
        this.nuguets1 = nuguets1;
        this.rikosaurio1 = rikosaurio1;
        this.cuartotrasero1 = cuartotrasero1;
        this.salchichas1 = salchichas1;
        this.permiso1eraQ = permiso1eraQ;
        this.permiso2DaQ = permiso2DaQ;
        this.compensacionMensual = compensacionMensual;
        this.valornorem = valornorem;
        this.jubilacion = jubilacion;
        this.ley19032 = ley19032;
        this.obrasocial = obrasocial;
        this.obrasocialnorem = obrasocialnorem;
        this.federacion = federacion;
        this.TotalRemunerativo = TotalRemunerativo;
        this.NoRemunerativo = NoRemunerativo;
        this.TotalDescuentos = TotalDescuentos;
        this.Neto = Neto;
        this.DiasPrimeraQ = DiasPrimeraQ;
        this.diasSegundaQ = diasSegundaQ;
        this.diasprimeraQui = diasprimeraQui;
        this.diassegundaQui = diassegundaQui;
        this.Feriado1EraQ = Feriado1EraQ;
        this.Feriado2DaQ = Feriado2DaQ;
        this.HsExtra50EraQ = HsExtra50EraQ;
        this.HsExtra50DaQ = HsExtra50DaQ;
        this.HsExtra100EraQ = HsExtra100EraQ;
        this.HsExtra100DaQ = HsExtra100DaQ;
        this.HsNoct1EraQ = HsNoct1EraQ;
        this.HsNoct2DaQ = HsNoct2DaQ;
        this.HsExtraNoct50EraQ = HsExtraNoct50EraQ;
        this.HsExtraNoct50DaQ = HsExtraNoct50DaQ;
        this.permiso1era = permiso1era;
        this.permiso2da = permiso2da;
        this.sepelio = sepelio;
        this.AjustedeSueldo = AjustedeSueldo;
        this.hsnoct1 = hsnoct1;
        this.hsnoct2 = hsnoct2;
        this.HsEnNegro = HsEnNegro;
        this.AuxHsEnNegro = AuxHsEnNegro;
        this.valorHoraNegro = valorHoraNegro;
        this.CuotaSindical = CuotaSindical;
        this.Resolucion = Resolucion;
        this.AFILIADO = AFILIADO;
        this.comMer = comMer;
        this.merca = merca;
        this.SUSPENSIONera = SUSPENSIONera;
        this.SUSPENSIONda = SUSPENSIONda;
        this.noremnormal1 = noremnormal1;
        this.noctnorem1 = noctnorem1;
        this.noct50norem1 = noct50norem1;
        this.extra1 = extra1;
        this.extraCien1 = extraCien1;
        this.valornorem1 = valornorem1;
        this.premiorem1 = premiorem1;
        this.noremnormal2 = noremnormal2;
        this.noctnorem2 = noctnorem2;
        this.noct50norem2 = noct50norem2;
        this.extra2 = extra2;
        this.extraCien2 = extraCien2;
        this.valornorem2 = valornorem2;
        this.premiorem2 = premiorem2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String Anio) {
        this.Anio = Anio;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public double getValorHoraNormal() {
        return valorHoraNormal;
    }

    public void setValorHoraNormal(double valorHoraNormal) {
        this.valorHoraNormal = valorHoraNormal;
    }

    public double getValorHoraNoRem() {
        return valorHoraNoRem;
    }

    public void setValorHoraNoRem(double valorHoraNoRem) {
        this.valorHoraNoRem = valorHoraNoRem;
    }

    public double getPremio1() {
        return premio1;
    }

    public void setPremio1(double premio1) {
        this.premio1 = premio1;
    }

    public double getPremio2() {
        return premio2;
    }

    public void setPremio2(double premio2) {
        this.premio2 = premio2;
    }

    public double getFeriado1() {
        return feriado1;
    }

    public void setFeriado1(double feriado1) {
        this.feriado1 = feriado1;
    }

    public double getFeriado2() {
        return feriado2;
    }

    public void setFeriado2(double feriado2) {
        this.feriado2 = feriado2;
    }

    public double getExtra1era() {
        return extra1era;
    }

    public void setExtra1era(double extra1era) {
        this.extra1era = extra1era;
    }

    public double getExtra2da() {
        return extra2da;
    }

    public void setExtra2da(double extra2da) {
        this.extra2da = extra2da;
    }

    public double getBonificado() {
        return bonificado;
    }

    public void setBonificado(double bonificado) {
        this.bonificado = bonificado;
    }

    public double getBonificacion() {
        return Bonificacion;
    }

    public void setBonificacion(double Bonificacion) {
        this.Bonificacion = Bonificacion;
    }

    public double getExtra100era() {
        return extra100era;
    }

    public void setExtra100era(double extra100era) {
        this.extra100era = extra100era;
    }

    public double getExtra100da() {
        return extra100da;
    }

    public void setExtra100da(double extra100da) {
        this.extra100da = extra100da;
    }

    public double getHsnoct1era() {
        return hsnoct1era;
    }

    public void setHsnoct1era(double hsnoct1era) {
        this.hsnoct1era = hsnoct1era;
    }

    public double getHsnoct2da() {
        return hsnoct2da;
    }

    public void setHsnoct2da(double hsnoct2da) {
        this.hsnoct2da = hsnoct2da;
    }

    public double getHoranoct50era() {
        return horanoct50era;
    }

    public void setHoranoct50era(double horanoct50era) {
        this.horanoct50era = horanoct50era;
    }

    public double getHoranoct50da() {
        return horanoct50da;
    }

    public void setHoranoct50da(double horanoct50da) {
        this.horanoct50da = horanoct50da;
    }

    public double getADELANTO() {
        return ADELANTO;
    }

    public void setADELANTO(double ADELANTO) {
        this.ADELANTO = ADELANTO;
    }

    public double getDescuentoajuste() {
        return descuentoajuste;
    }

    public void setDescuentoajuste(double descuentoajuste) {
        this.descuentoajuste = descuentoajuste;
    }

    public double getMercaderia() {
        return mercaderia;
    }

    public void setMercaderia(double mercaderia) {
        this.mercaderia = mercaderia;
    }

    public double getComedor() {
        return Comedor;
    }

    public void setComedor(double Comedor) {
        this.Comedor = Comedor;
    }

    public double getPollo() {
        return pollo;
    }

    public void setPollo(double pollo) {
        this.pollo = pollo;
    }

    public double getSupremacrispy() {
        return supremacrispy;
    }

    public void setSupremacrispy(double supremacrispy) {
        this.supremacrispy = supremacrispy;
    }

    public double getBocadito() {
        return bocadito;
    }

    public void setBocadito(double bocadito) {
        this.bocadito = bocadito;
    }

    public double getMedallon() {
        return medallon;
    }

    public void setMedallon(double medallon) {
        this.medallon = medallon;
    }

    public double getNuguets() {
        return nuguets;
    }

    public void setNuguets(double nuguets) {
        this.nuguets = nuguets;
    }

    public double getRikosaurio() {
        return rikosaurio;
    }

    public void setRikosaurio(double rikosaurio) {
        this.rikosaurio = rikosaurio;
    }

    public double getCuartotrasero() {
        return cuartotrasero;
    }

    public void setCuartotrasero(double cuartotrasero) {
        this.cuartotrasero = cuartotrasero;
    }

    public double getSalchichas() {
        return salchichas;
    }

    public void setSalchichas(double salchichas) {
        this.salchichas = salchichas;
    }

    public double getComedor1() {
        return Comedor1;
    }

    public void setComedor1(double Comedor1) {
        this.Comedor1 = Comedor1;
    }

    public double getPollo1() {
        return pollo1;
    }

    public void setPollo1(double pollo1) {
        this.pollo1 = pollo1;
    }

    public double getSupremacrispy1() {
        return supremacrispy1;
    }

    public void setSupremacrispy1(double supremacrispy1) {
        this.supremacrispy1 = supremacrispy1;
    }

    public double getBocadito1() {
        return bocadito1;
    }

    public void setBocadito1(double bocadito1) {
        this.bocadito1 = bocadito1;
    }

    public double getMedallon1() {
        return medallon1;
    }

    public void setMedallon1(double medallon1) {
        this.medallon1 = medallon1;
    }

    public double getNuguets1() {
        return nuguets1;
    }

    public void setNuguets1(double nuguets1) {
        this.nuguets1 = nuguets1;
    }

    public double getRikosaurio1() {
        return rikosaurio1;
    }

    public void setRikosaurio1(double rikosaurio1) {
        this.rikosaurio1 = rikosaurio1;
    }

    public double getCuartotrasero1() {
        return cuartotrasero1;
    }

    public void setCuartotrasero1(double cuartotrasero1) {
        this.cuartotrasero1 = cuartotrasero1;
    }

    public double getSalchichas1() {
        return salchichas1;
    }

    public void setSalchichas1(double salchichas1) {
        this.salchichas1 = salchichas1;
    }

    public double getPermiso1eraQ() {
        return permiso1eraQ;
    }

    public void setPermiso1eraQ(double permiso1eraQ) {
        this.permiso1eraQ = permiso1eraQ;
    }

    public double getPermiso2DaQ() {
        return permiso2DaQ;
    }

    public void setPermiso2DaQ(double permiso2DaQ) {
        this.permiso2DaQ = permiso2DaQ;
    }

    public double getCompensacionMensual() {
        return compensacionMensual;
    }

    public void setCompensacionMensual(double compensacionMensual) {
        this.compensacionMensual = compensacionMensual;
    }

    public double getValornorem() {
        return valornorem;
    }

    public void setValornorem(double valornorem) {
        this.valornorem = valornorem;
    }

    public double getJubilacion() {
        return jubilacion;
    }

    public void setJubilacion(double jubilacion) {
        this.jubilacion = jubilacion;
    }

    public double getLey19032() {
        return ley19032;
    }

    public void setLey19032(double ley19032) {
        this.ley19032 = ley19032;
    }

    public double getObrasocial() {
        return obrasocial;
    }

    public void setObrasocial(double obrasocial) {
        this.obrasocial = obrasocial;
    }

    public double getObrasocialnorem() {
        return obrasocialnorem;
    }

    public void setObrasocialnorem(double obrasocialnorem) {
        this.obrasocialnorem = obrasocialnorem;
    }

    public double getFederacion() {
        return federacion;
    }

    public void setFederacion(double federacion) {
        this.federacion = federacion;
    }

    public double getTotalRemunerativo() {
        return TotalRemunerativo;
    }

    public void setTotalRemunerativo(double TotalRemunerativo) {
        this.TotalRemunerativo = TotalRemunerativo;
    }

    public double getNoRemunerativo() {
        return NoRemunerativo;
    }

    public void setNoRemunerativo(double NoRemunerativo) {
        this.NoRemunerativo = NoRemunerativo;
    }

    public double getTotalDescuentos() {
        return TotalDescuentos;
    }

    public void setTotalDescuentos(double TotalDescuentos) {
        this.TotalDescuentos = TotalDescuentos;
    }

    public double getNeto() {
        return Neto;
    }

    public void setNeto(double Neto) {
        this.Neto = Neto;
    }

    public double getDiasPrimeraQ() {
        return DiasPrimeraQ;
    }

    public void setDiasPrimeraQ(double DiasPrimeraQ) {
        this.DiasPrimeraQ = DiasPrimeraQ;
    }

    public double getDiasSegundaQ() {
        return diasSegundaQ;
    }

    public void setDiasSegundaQ(double diasSegundaQ) {
        this.diasSegundaQ = diasSegundaQ;
    }

    public double getDiasprimeraQui() {
        return diasprimeraQui;
    }

    public void setDiasprimeraQui(double diasprimeraQui) {
        this.diasprimeraQui = diasprimeraQui;
    }

    public double getDiassegundaQui() {
        return diassegundaQui;
    }

    public void setDiassegundaQui(double diassegundaQui) {
        this.diassegundaQui = diassegundaQui;
    }

    public double getFeriado1EraQ() {
        return Feriado1EraQ;
    }

    public void setFeriado1EraQ(double Feriado1EraQ) {
        this.Feriado1EraQ = Feriado1EraQ;
    }

    public double getFeriado2DaQ() {
        return Feriado2DaQ;
    }

    public void setFeriado2DaQ(double Feriado2DaQ) {
        this.Feriado2DaQ = Feriado2DaQ;
    }

    public double getHsExtra50EraQ() {
        return HsExtra50EraQ;
    }

    public void setHsExtra50EraQ(double HsExtra50EraQ) {
        this.HsExtra50EraQ = HsExtra50EraQ;
    }

    public double getHsExtra50DaQ() {
        return HsExtra50DaQ;
    }

    public void setHsExtra50DaQ(double HsExtra50DaQ) {
        this.HsExtra50DaQ = HsExtra50DaQ;
    }

    public double getHsExtra100EraQ() {
        return HsExtra100EraQ;
    }

    public void setHsExtra100EraQ(double HsExtra100EraQ) {
        this.HsExtra100EraQ = HsExtra100EraQ;
    }

    public double getHsExtra100DaQ() {
        return HsExtra100DaQ;
    }

    public void setHsExtra100DaQ(double HsExtra100DaQ) {
        this.HsExtra100DaQ = HsExtra100DaQ;
    }

    public double getHsNoct1EraQ() {
        return HsNoct1EraQ;
    }

    public void setHsNoct1EraQ(double HsNoct1EraQ) {
        this.HsNoct1EraQ = HsNoct1EraQ;
    }

    public double getHsNoct2DaQ() {
        return HsNoct2DaQ;
    }

    public void setHsNoct2DaQ(double HsNoct2DaQ) {
        this.HsNoct2DaQ = HsNoct2DaQ;
    }

    public double getHsExtraNoct50EraQ() {
        return HsExtraNoct50EraQ;
    }

    public void setHsExtraNoct50EraQ(double HsExtraNoct50EraQ) {
        this.HsExtraNoct50EraQ = HsExtraNoct50EraQ;
    }

    public double getHsExtraNoct50DaQ() {
        return HsExtraNoct50DaQ;
    }

    public void setHsExtraNoct50DaQ(double HsExtraNoct50DaQ) {
        this.HsExtraNoct50DaQ = HsExtraNoct50DaQ;
    }

    public double getPermiso1era() {
        return permiso1era;
    }

    public void setPermiso1era(double permiso1era) {
        this.permiso1era = permiso1era;
    }

    public double getPermiso2da() {
        return permiso2da;
    }

    public void setPermiso2da(double permiso2da) {
        this.permiso2da = permiso2da;
    }

    public double getSepelio() {
        return sepelio;
    }

    public void setSepelio(double sepelio) {
        this.sepelio = sepelio;
    }

    public double getAjustedeSueldo() {
        return AjustedeSueldo;
    }

    public void setAjustedeSueldo(double AjustedeSueldo) {
        this.AjustedeSueldo = AjustedeSueldo;
    }

    public double getHsnoct1() {
        return hsnoct1;
    }

    public void setHsnoct1(double hsnoct1) {
        this.hsnoct1 = hsnoct1;
    }

    public double getHsnoct2() {
        return hsnoct2;
    }

    public void setHsnoct2(double hsnoct2) {
        this.hsnoct2 = hsnoct2;
    }

    public double getHsEnNegro() {
        return HsEnNegro;
    }

    public void setHsEnNegro(double HsEnNegro) {
        this.HsEnNegro = HsEnNegro;
    }

    public double getAuxHsEnNegro() {
        return AuxHsEnNegro;
    }

    public void setAuxHsEnNegro(double AuxHsEnNegro) {
        this.AuxHsEnNegro = AuxHsEnNegro;
    }

    public double getValorHoraNegro() {
        return valorHoraNegro;
    }

    public void setValorHoraNegro(double valorHoraNegro) {
        this.valorHoraNegro = valorHoraNegro;
    }

    public double getCuotaSindical() {
        return CuotaSindical;
    }

    public void setCuotaSindical(double CuotaSindical) {
        this.CuotaSindical = CuotaSindical;
    }

    public double getResolucion() {
        return Resolucion;
    }

    public void setResolucion(double Resolucion) {
        this.Resolucion = Resolucion;
    }

    public double getAFILIADO() {
        return AFILIADO;
    }

    public void setAFILIADO(double AFILIADO) {
        this.AFILIADO = AFILIADO;
    }

    public double getComMer() {
        return comMer;
    }

    public void setComMer(double comMer) {
        this.comMer = comMer;
    }

    public double getMerca() {
        return merca;
    }

    public void setMerca(double merca) {
        this.merca = merca;
    }

    public double getSUSPENSIONera() {
        return SUSPENSIONera;
    }

    public void setSUSPENSIONera(double SUSPENSIONera) {
        this.SUSPENSIONera = SUSPENSIONera;
    }

    public double getSUSPENSIONda() {
        return SUSPENSIONda;
    }

    public void setSUSPENSIONda(double SUSPENSIONda) {
        this.SUSPENSIONda = SUSPENSIONda;
    }

    public double getNoremnormal1() {
        return noremnormal1;
    }

    public void setNoremnormal1(double noremnormal1) {
        this.noremnormal1 = noremnormal1;
    }

    public double getNoctnorem1() {
        return noctnorem1;
    }

    public void setNoctnorem1(double noctnorem1) {
        this.noctnorem1 = noctnorem1;
    }

    public double getNoct50norem1() {
        return noct50norem1;
    }

    public void setNoct50norem1(double noct50norem1) {
        this.noct50norem1 = noct50norem1;
    }

    public double getExtra1() {
        return extra1;
    }

    public void setExtra1(double extra1) {
        this.extra1 = extra1;
    }

    public double getExtraCien1() {
        return extraCien1;
    }

    public void setExtraCien1(double extraCien1) {
        this.extraCien1 = extraCien1;
    }

    public double getValornorem1() {
        return valornorem1;
    }

    public void setValornorem1(double valornorem1) {
        this.valornorem1 = valornorem1;
    }

    public double getPremiorem1() {
        return premiorem1;
    }

    public void setPremiorem1(double premiorem1) {
        this.premiorem1 = premiorem1;
    }

    public double getNoremnormal2() {
        return noremnormal2;
    }

    public void setNoremnormal2(double noremnormal2) {
        this.noremnormal2 = noremnormal2;
    }

    public double getNoctnorem2() {
        return noctnorem2;
    }

    public void setNoctnorem2(double noctnorem2) {
        this.noctnorem2 = noctnorem2;
    }

    public double getNoct50norem2() {
        return noct50norem2;
    }

    public void setNoct50norem2(double noct50norem2) {
        this.noct50norem2 = noct50norem2;
    }

    public double getExtra2() {
        return extra2;
    }

    public void setExtra2(double extra2) {
        this.extra2 = extra2;
    }

    public double getExtraCien2() {
        return extraCien2;
    }

    public void setExtraCien2(double extraCien2) {
        this.extraCien2 = extraCien2;
    }

    public double getValornorem2() {
        return valornorem2;
    }

    public void setValornorem2(double valornorem2) {
        this.valornorem2 = valornorem2;
    }

    public double getPremiorem2() {
        return premiorem2;
    }

    public void setPremiorem2(double premiorem2) {
        this.premiorem2 = premiorem2;
    }

}
