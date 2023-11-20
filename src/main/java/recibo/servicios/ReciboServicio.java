/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recibo.servicios;

import recibo.entidades.Recibo;
import recibo.excepciones.MiException;
import recibo.repositorios.ReciboRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FraNko
 */
@Service
public class ReciboServicio {

    @Autowired
    private ReciboRepositorio reciboRepositorio;

    public Recibo calcularRecibo(double valorHoraNormal, double valorHoraNoRem, double diasPrimeraQ, double diasSegundaQ, double diasprimeraQui, double sepelio,
            String legajo, String apellido, String nombre, String segundonombre, String mes, String anio, String respuesta, double feriado1EraQ, double feriado2DaQ,
            double HsExtra50EraQ, double HsExtra50DaQ, double bonificado, double HsExtra100EraQ, double HsExtra100DaQ, double HsEnNegro, double HsNoct1EraQ,
            double HsNoct2DaQ, double HsExtraNoct50EraQ, double HsExtraNoct50DaQ, double permiso1eraQ, double permiso2DaQ,
            double ajustedeSueldo, double descuentoajuste, double bonificacion, double ADELANTO, double SUSPENSIONera,
            double SUSPENSIONda, double Comedor, double pollo, double supremacrispy, double bocadito, double medallon,
            double nuguets, double rikosaurio, double cuartotrasero, double salchichas, double Comedor1, double pollo1,
            double supremacrispy1, double bocadito1, double medallon1, double nuguets1, double rikosaurio1, double cuartotrasero1,
            double salchichas1, double comMer, double merca, double TotalDescuentos, double diassegundaQui) throws MiException {

        Recibo recibo = new Recibo();
        //*******************************************************************//
        diasprimeraQui = diasPrimeraQ * 8.8;
        diasprimeraQui = diasPrimeraQ - SUSPENSIONera;
        diasprimeraQui = (diasPrimeraQ * 8.8) - HsNoct1EraQ - permiso1eraQ;

        //*******************************************************************//
        diassegundaQui = diasSegundaQ * 8.8;
        diassegundaQui = diasSegundaQ - SUSPENSIONda;
        diassegundaQui = (diasSegundaQ * 8.8) - HsNoct2DaQ - permiso2DaQ;
        /*========================================================================================================================*/
        double auxDiasP = diasPrimeraQ;
        double auxFeriado1 = feriado1EraQ;
        double auxHsExtra50Era = HsExtra50EraQ;
        double auxHsExtra100Era = HsExtra100EraQ;
        double auxHsNoct1EraQ = HsNoct1EraQ;
        double auxHsExtraNoct50EraQ = HsExtraNoct50EraQ;

        double feriado1 = feriado1EraQ;
        double feriado2 = feriado2DaQ;
        double horanorem = valorHoraNoRem;

        //VALORES NO REMUNERATIVOS PRIMERA QUINCENA
        double noremnormal1 = (((diasPrimeraQ - SUSPENSIONera + feriado1) * 8.8) - permiso1eraQ - HsNoct1EraQ) * horanorem;
        double noctnorem1 = HsNoct1EraQ * (horanorem * 1.133);
        double noct50norem1 = HsExtraNoct50EraQ * ((horanorem * 1.5) * 1.133);
        double extra1 = HsExtra50EraQ * (horanorem * 1.5);
        double extraCien1 = HsExtra100EraQ * (horanorem * 2);

        double valornorem1 = (noremnormal1 + noctnorem1 + noct50norem1 + extra1 + extraCien1);
        double premiorem1 = valornorem1 * 0.11;
        if (SUSPENSIONera >= 1) {
            premiorem1 = 0;
        }
        //VALORES NO REMUNERATIVOS SEGUNDA QUINCENA
        double noremnormal2 = (((diasSegundaQ - SUSPENSIONda + feriado2) * 8.8) - permiso2DaQ - HsNoct2DaQ) * horanorem;
        double noctnorem2 = HsNoct2DaQ * (horanorem * 1.133);
        double noct50norem2 = HsExtraNoct50DaQ * ((horanorem * 1.5) * 1.133);
        double extra2 = HsExtra50DaQ * (horanorem * 1.5);
        double extraCien2 = HsExtra100DaQ * (horanorem * 2);

        double valornorem2 = (noremnormal2 + noctnorem2 + noct50norem2 + extra2 + extraCien2);
        double premiorem2 = valornorem2 * 0.11;
        if (SUSPENSIONda >= 1) {
            premiorem2 = 0;
        }

        //-------------------------------------------------------------------------------      
        //Valor $ DIAS PRIMERA QUINCENA
        diasPrimeraQ = diasPrimeraQ - SUSPENSIONera;
        diasPrimeraQ = ((diasPrimeraQ * 8.8) - HsNoct1EraQ - permiso1eraQ) * valorHoraNormal;

        //Valor $ DIAS PRIMERA QUINCENA NO REM
        auxDiasP = auxDiasP - SUSPENSIONera;
        auxDiasP = ((auxDiasP * 8.8) - HsNoct1EraQ - permiso1eraQ) * valorHoraNoRem;
//-------------------------------------------------------------------------------        
        //Valor $ FERIADO 1ERA QUINCENA
        feriado1EraQ = (feriado1EraQ * 8.8) * valorHoraNormal;

        //Valor $ FERIADO 1ERA QUINCENA NO REM
        auxFeriado1 = (auxFeriado1 * 8.8) * valorHoraNoRem;
//-------------------------------------------------------------------------------     
        //Valor $ HS EXTRAS 50% 1ERA QUINCENA
        HsExtra50EraQ = (HsExtra50EraQ * (valorHoraNormal * 1.5));

        //Valor $ HS EXTRAS 50% 1ERA QUINCENA NO REM
        auxHsExtra50Era = (auxHsExtra50Era * (valorHoraNoRem * 1.5));
//-------------------------------------------------------------------------------        
        //Valor $ HS EXTRAS 100% 1ERA QUINCENA
        HsExtra100EraQ = (HsExtra100EraQ * (valorHoraNormal * 2));

        //Valor $ HS EXTRAS 100% 1ERA QUINCENA NO REM
        auxHsExtra100Era = (auxHsExtra100Era * (valorHoraNoRem * 2));
//--------------------------------------------------------------------------------     
        //Valor $ HS NOCTURNAS 1ERA QUINCENA
        HsNoct1EraQ = (HsNoct1EraQ * (valorHoraNormal * 0.133 + (valorHoraNormal)));

        //Valor $ HS NOCTURNAS 1ERA QUINCENA NO REM
        auxHsNoct1EraQ = (auxHsNoct1EraQ * (valorHoraNoRem * 0.133 + (valorHoraNoRem)));
//--------------------------------------------------------------------------------        
        //Valor $ HS NOCTURNAS EXTRAS 50% 1ERA QUINCENA
        HsExtraNoct50EraQ = (HsExtraNoct50EraQ * ((valorHoraNormal * 1.5) * 0.133 + (valorHoraNormal * 1.5)));

        //Valor $ HS NOCTURNAS EXTRAS 50% 1ERA QUINCENA NO REM
        auxHsExtraNoct50EraQ = (auxHsExtraNoct50EraQ * ((valorHoraNoRem * 1.5) * 0.133 + (valorHoraNoRem * 1.5)));

        double total = diasPrimeraQ + feriado1EraQ + HsExtra50EraQ + HsExtra100EraQ + HsNoct1EraQ + HsExtraNoct50EraQ;
        double premio1 = total * 0.11;

        //--------------------------------------------------
        //SUSPENDIDO EN LA PRIMERA QUINCENA
        if (SUSPENSIONera >= 1) {
            premio1 = 0;
        }
        //---------------------------------------------------
        double auxDiasS = diasSegundaQ;
        double auxFeriado2 = feriado2DaQ;
        double auxHsExtra50Da = HsExtra50DaQ;
        double auxHsExtra100Da = HsExtra100DaQ;
        double auxHsNoct1DaQ = HsNoct2DaQ;
        double auxHsExtraNoct50DaQ = HsExtraNoct50DaQ;

//-------------------------------------------------------------------------------        
        //Valor $ DIAS SEGUNDA QUINCENA;
        diasSegundaQ = diasSegundaQ - SUSPENSIONda;
        diasSegundaQ = ((diasSegundaQ * 8.8) - HsNoct2DaQ - permiso2DaQ) * valorHoraNormal;

        //Valor $ DIAS PRIMERA QUINCENA NO REM
        auxDiasS = auxDiasS - SUSPENSIONda;
        auxDiasS = ((auxDiasS * 8.8) - HsNoct2DaQ - permiso2DaQ) * valorHoraNoRem;
//-------------------------------------------------------------------------------  
        //Valor $ FERIADO SEGUNDA QUINCENA
        feriado2DaQ = (feriado2DaQ * 8.8) * valorHoraNormal;

        //Valor $ FERIADO 2DA QUINCENA NO REM
        auxFeriado2 = (auxFeriado2 * 8.8) * valorHoraNoRem;
//-------------------------------------------------------------------------------  
        //Valor $ HS EXTRAS SEGUNDA QUINCENA
        HsExtra50DaQ = (HsExtra50DaQ * (valorHoraNormal * 1.5));

        //Valor $ HS EXTRAS 50% 2DA QUINCENA NO REM
        auxHsExtra50Da = (auxHsExtra50Da * (valorHoraNoRem * 1.5));
//-------------------------------------------------------------------------------
        //Valor $ HS EXTRAS 100% 2DA QUINCENA
        HsExtra100DaQ = (HsExtra100DaQ * (valorHoraNormal * 2));

        //Valor $ HS EXTRAS 100% 2DA QUINCENA NO REM
        auxHsExtra100Da = (auxHsExtra100Da * (valorHoraNoRem * 2));
//-------------------------------------------------------------------------------
        //Valor $ HS NOCTURNAS 2DA QUINCENA
        HsNoct2DaQ = (HsNoct2DaQ * (valorHoraNormal * 0.133 + (valorHoraNormal)));

        //Valor $ HS NOCTURNAS 2DA QUINCENA NO REM
        auxHsNoct1DaQ = (auxHsNoct1DaQ * (valorHoraNoRem * 0.133 + (valorHoraNoRem)));
//-------------------------------------------------------------------------------
        //Valor $ HS NOCTURNAS EXTRAS 50% 2DA QUINCENA
        HsExtraNoct50DaQ = (HsExtraNoct50DaQ * ((valorHoraNormal * 1.5) * 0.133 + (valorHoraNormal * 1.5)));

        //Valor $ HS NOCTURNAS EXTRAS 50% 2DA QUINCENA NO REM
        auxHsExtraNoct50DaQ = (auxHsExtraNoct50DaQ * ((valorHoraNoRem * 1.5) * 0.133 + (valorHoraNoRem * 1.5)));

        //getBonificacion contiene el % que ingresa el usuario
        bonificacion = bonificacion / 100;
        bonificado = (diasPrimeraQ + diasSegundaQ) * bonificacion;

        //Bonificacionrem TOMA el mismo valor que tiene bonificacion
        double bonificacionrem1 = bonificacion;
        double bonificadorem1 = auxDiasP * bonificacionrem1;
        double bonificacionrem2 = bonificacion;
        double bonificadorem2 = auxDiasS * bonificacionrem2;
        //----------------------<<<<<<<<<<<<<>>>>>>>>>>---------------//

        double total2 = diasSegundaQ + feriado2DaQ + HsExtra50DaQ + HsExtra100DaQ + HsNoct2DaQ + HsExtraNoct50DaQ;
        double premio2 = total2 * 0.11;

        //--------------------------------------------------
        //SUSPENDIDO EN LA PRIMERA QUINCENA
        if (SUSPENSIONda >= 1) {
            premio2 = 0;
        }
        //---------------------------------------------------

        double jubilacion = (bonificado + diasPrimeraQ + diasSegundaQ + premio1 + premio2 + feriado1EraQ + feriado2DaQ + HsExtra50EraQ + HsExtra50DaQ + HsExtra100EraQ + HsExtra100DaQ + HsNoct1EraQ + HsNoct2DaQ + HsExtraNoct50EraQ + HsExtraNoct50DaQ + ajustedeSueldo) * 0.11;
        double ley19032 = (bonificado + diasPrimeraQ + diasSegundaQ + premio1 + premio2 + feriado1EraQ + feriado2DaQ + HsExtra50EraQ + HsExtra50DaQ + HsExtra100EraQ + HsExtra100DaQ + HsNoct1EraQ + HsNoct2DaQ + HsExtraNoct50EraQ + HsExtraNoct50DaQ + ajustedeSueldo) * 0.03;
        double obrasocial = (bonificado + diasPrimeraQ + diasSegundaQ + premio1 + premio2 + feriado1EraQ + feriado2DaQ + HsExtra50EraQ + HsExtra50DaQ + HsExtra100EraQ + HsExtra100DaQ + HsNoct1EraQ + HsNoct2DaQ + HsExtraNoct50EraQ + HsExtraNoct50DaQ + ajustedeSueldo) * 0.03;
        double federacion = (bonificado + diasPrimeraQ + diasSegundaQ + premio1 + premio2 + feriado1EraQ + feriado2DaQ + HsExtra50EraQ + HsExtra50DaQ + HsExtra100EraQ + HsExtra100DaQ + HsNoct1EraQ + HsNoct2DaQ + HsExtraNoct50EraQ + HsExtraNoct50DaQ + ajustedeSueldo + valornorem1 + valornorem2 + premiorem1 + premiorem2 + bonificadorem1 + bonificadorem2) * 0.02;
        double obrasocialnorem = ((bonificadorem1 + bonificadorem2 + valornorem1 + valornorem2 + premiorem1 + premiorem2) * 0.03) + (((diasprimeraQui + diassegundaQui) * horanorem) * bonificacion) * 0.03;//////

        //Valor total no remunerativo + la bonificacion no remunerativa si es que el operario recibe % de bonificacion
        valornorem1 = valornorem1 + premiorem1 + bonificadorem1;
        valornorem2 = valornorem2 + premiorem2 + bonificadorem2;

        //Calcular horas en negro
        double HSNEGRAS = ((valorHoraNormal * 1.5) * HsEnNegro) * 1.11;
        double auxHSNEGRAS = ((valorHoraNoRem * 1.5) * HsEnNegro) * 1.11;
        double valorHoraNegro = HSNEGRAS + auxHSNEGRAS;

        double TotalRemunerativo = bonificado + diasPrimeraQ + diasSegundaQ + premio1 + premio2 + feriado1EraQ + feriado2DaQ + HsExtra50EraQ + HsExtra50DaQ + HsExtra100EraQ + HsExtra100DaQ + HsNoct1EraQ + HsNoct2DaQ + HsExtraNoct50EraQ + HsExtraNoct50DaQ + ajustedeSueldo;
        double compensacionMensual = 1674;

        if (SUSPENSIONera >= 1 && SUSPENSIONda >= 1) {
            compensacionMensual = 0;
        }
        if (SUSPENSIONera >= 1 || SUSPENSIONda >= 1) {
            compensacionMensual = 0;
        }

        double NoRemunerativo = valornorem1 + valornorem2 + compensacionMensual;

        //------------------------------------------------------------
        //CONDICIONAL DE IF PARA DEFINIR SI ES AFILIADO O NO AL GREMIO
        double CuotaSindical = 0;
        double Resolucion = 0;
        if (respuesta.equalsIgnoreCase("si")) {
            CuotaSindical = 0.015;
            Resolucion = 0.015;
        }
        double REMUNOREMU = TotalRemunerativo + NoRemunerativo;
        double AFILIADO = REMUNOREMU * (CuotaSindical + Resolucion);
        //------------------------------------------------------------ 

        //MERCADERIA
        comMer = Comedor * Comedor1;
        merca = pollo * pollo1 + supremacrispy * supremacrispy1 + bocadito * bocadito1 + medallon * medallon1 + nuguets * nuguets1 + rikosaurio * rikosaurio1 + cuartotrasero * cuartotrasero1 + salchichas * salchichas1;
        //TOTAL DESCUENTOS
        TotalDescuentos = AFILIADO + jubilacion + ley19032 + obrasocial + obrasocialnorem + federacion + sepelio + merca + comMer + descuentoajuste + ADELANTO;

        //TOTAL NETO A COBRAR
        double Neto = TotalRemunerativo + NoRemunerativo + valorHoraNegro - TotalDescuentos;

        //CONDICIONAL PARA DAR EL VALOR SI O NO EN LA PARTE SUPERIOR DEL RECIBO "SINDICATO"
        String resp = respuesta;
        if (respuesta.equalsIgnoreCase("si")) {
            respuesta = "1.5%";
        }

        //************************************************FIN DE LA LOGICA****************************************************\\
        //REDONDEAR VALORES CON DOS DECIMALES
        diasprimeraQui = redondearDosDecimales(diasprimeraQui);
        diassegundaQui = redondearDosDecimales(diassegundaQui);
        diasPrimeraQ = redondearDosDecimales(diasPrimeraQ);
        diasSegundaQ = redondearDosDecimales(diasSegundaQ);
        premio1 = redondearDosDecimales(premio1);
        premio2 = redondearDosDecimales(premio2);
        feriado1EraQ = redondearDosDecimales(feriado1EraQ);
        feriado2DaQ = redondearDosDecimales(feriado2DaQ);
        HsExtra50EraQ = redondearDosDecimales(HsExtra50EraQ);
        HsExtra50DaQ = redondearDosDecimales(HsExtra50DaQ);
        bonificacion = redondearDosDecimales(bonificacion);
        bonificado = redondearDosDecimales(bonificado);
        HsExtra100EraQ = redondearDosDecimales(HsExtra100EraQ);
        HsExtra100DaQ = redondearDosDecimales(HsExtra100DaQ);
        HsNoct1EraQ = redondearDosDecimales(HsNoct1EraQ);
        HsNoct2DaQ = redondearDosDecimales(HsNoct2DaQ);
        HsExtraNoct50EraQ = redondearDosDecimales(HsExtraNoct50EraQ);
        HsExtraNoct50DaQ = redondearDosDecimales(HsExtraNoct50DaQ);
        permiso1eraQ = redondearDosDecimales(permiso1eraQ);
        permiso2DaQ = redondearDosDecimales(permiso2DaQ);
        ajustedeSueldo = redondearDosDecimales(ajustedeSueldo);
        descuentoajuste = redondearDosDecimales(descuentoajuste);
        compensacionMensual = redondearDosDecimales(compensacionMensual);

        double valornorem = valornorem1 + valornorem2;
        valornorem = redondearDosDecimales(valornorem);

        jubilacion = redondearDosDecimales(jubilacion);
        ley19032 = redondearDosDecimales(ley19032);
        obrasocial = redondearDosDecimales(obrasocial);
        obrasocialnorem = redondearDosDecimales(obrasocialnorem);
        federacion = redondearDosDecimales(federacion);
        ADELANTO = redondearDosDecimales(ADELANTO);
        AFILIADO = redondearDosDecimales(AFILIADO);
        comMer = redondearDosDecimales(comMer);
        merca = redondearDosDecimales(merca);
        TotalRemunerativo = redondearDosDecimales(TotalRemunerativo);
        NoRemunerativo = redondearDosDecimales(NoRemunerativo);
        TotalDescuentos = redondearDosDecimales(TotalDescuentos);
        Neto = redondearDosDecimales(Neto);

        //LLAMAR CON SETTERS LAS VARIABLES QUE SE QUIERAN MOSTRAR EN LA WEB\\
        recibo.setValorHoraNormal(valorHoraNormal);
        recibo.setValorHoraNoRem(valorHoraNoRem);
        recibo.setLegajo(legajo);
        recibo.setApellido(apellido);
        recibo.setNombre(nombre);
        recibo.setSegundonombre(segundonombre);
        recibo.setMes(mes);
        recibo.setDiasprimeraQui(diasprimeraQui);
        recibo.setDiassegundaQui(diassegundaQui);
        recibo.setDiasPrimeraQ(diasPrimeraQ);
        recibo.setDiasSegundaQ(diasSegundaQ);
        recibo.setPremio1(premio1);
        recibo.setPremio2(premio2);
        recibo.setFeriado1EraQ(feriado1EraQ);
        recibo.setFeriado2DaQ(feriado2DaQ);
        recibo.setHsExtra50EraQ(HsExtra50EraQ);
        recibo.setHsExtra50DaQ(HsExtra50DaQ);
        recibo.setBonificacion(bonificacion);
        recibo.setBonificado(bonificado);
        recibo.setHsExtra100EraQ(HsExtra100EraQ);
        recibo.setHsExtra100DaQ(HsExtra100DaQ);
        recibo.setHsNoct1EraQ(HsNoct1EraQ);
        recibo.setHsNoct2DaQ(HsNoct2DaQ);
        recibo.setHsExtraNoct50EraQ(HsExtraNoct50EraQ);
        recibo.setHsExtraNoct50DaQ(HsExtraNoct50DaQ);
        recibo.setPermiso1eraQ(permiso1eraQ);
        recibo.setPermiso2DaQ(permiso2DaQ);
        recibo.setAjustedeSueldo(ajustedeSueldo);
        recibo.setDescuentoajuste(descuentoajuste);
        recibo.setCompensacionMensual(compensacionMensual);
        recibo.setValornorem(valornorem);
        recibo.setJubilacion(jubilacion);
        recibo.setLey19032(ley19032);
        recibo.setObrasocial(obrasocial);
        recibo.setObrasocialnorem(obrasocialnorem);
        recibo.setFederacion(federacion);
        recibo.setResp(resp);
        recibo.setRespuesta(respuesta);
        recibo.setAFILIADO(AFILIADO);
        recibo.setADELANTO(ADELANTO);
        recibo.setSepelio(sepelio);
        recibo.setComMer(comMer);
        recibo.setMerca(merca);
        recibo.setSUSPENSIONera(SUSPENSIONera);
        recibo.setSUSPENSIONda(SUSPENSIONda);
        recibo.setTotalRemunerativo(TotalRemunerativo);
        recibo.setNoRemunerativo(NoRemunerativo);
        recibo.setTotalDescuentos(TotalDescuentos);
        recibo.setNeto(Neto);
        reciboRepositorio.save(recibo);
        return recibo;

    }

    public double redondearDosDecimales(double valor) {
        // Usamos Math.round para redondear al número entero más cercano
        // y luego dividimos por 100.0 para obtener 2 decimales
        return Math.round(valor * 100.0) / 100.0;
    }

}
