package recibo.controladores;



import recibo.entidades.Recibo;
import recibo.excepciones.MiException;
import recibo.servicios.ReciboServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FraNko
 */
@Controller
@RequestMapping("/rh")
public class ReciboControlador {

    @Autowired
    private ReciboServicio reciboServicio;

    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "formulario.html"; // Debes crear la vista formulario.html
    }
    @GetMapping("/informacion")
    public String mostrarInformacion() {
        return "informacion.html"; 
    }

    @PostMapping("/resultado")
    public String calcularSuma(@RequestParam String legajo, @RequestParam String apellido, @RequestParam String nombre,
            @RequestParam String segundonombre,
            @RequestParam String mes, @RequestParam String respuesta,
            @RequestParam double valorHoraNormal,
            @RequestParam double valorHoraNoRem,
            @RequestParam double diasPrimeraQ,
            @RequestParam double diasSegundaQ,
            @RequestParam double sepelio,
            @RequestParam(name = "feriado1EraQ", defaultValue = "0.0") double feriado1EraQ,
            @RequestParam(name = "feriado2DaQ", defaultValue = "0.0") double feriado2DaQ,
            @RequestParam(name = "HsExtra50EraQ", defaultValue = "0.0") double HsExtra50EraQ,
            @RequestParam(name = "HsExtra50DaQ", defaultValue = "0.0") double HsExtra50DaQ,
            @RequestParam(name = "HsExtra100EraQ", defaultValue = "0.0") double HsExtra100EraQ,
            @RequestParam(name = "HsExtra100DaQ", defaultValue = "0.0") double HsExtra100DaQ,
            @RequestParam(name = "HsEnNegro", defaultValue = "0.0") double HsEnNegro,
            @RequestParam(name = "HsNoct1EraQ", defaultValue = "0.0") double HsNoct1EraQ,
            @RequestParam(name = "HsNoct2DaQ", defaultValue = "0.0") double HsNoct2DaQ,
            @RequestParam(name = "HsExtraNoct50EraQ", defaultValue = "0.0") double HsExtraNoct50EraQ,
            @RequestParam(name = "HsExtraNoct50DaQ", defaultValue = "0.0") double HsExtraNoct50DaQ,
            @RequestParam(name = "permiso1eraQ", defaultValue = "0.0") double permiso1eraQ,
            @RequestParam(name = "permiso2DaQ", defaultValue = "0.0") double permiso2DaQ,
            @RequestParam(name = "ajustedeSueldo", defaultValue = "0.0") double ajustedeSueldo,
            @RequestParam(name = "descuentoajuste", defaultValue = "0.0") double descuentoajuste,
            @RequestParam(name = "bonificacion", defaultValue = "0.0") double bonificacion,
            @RequestParam(name = "ADELANTO", defaultValue = "0.0") double ADELANTO,
            @RequestParam(name = "SUSPENSIONera", defaultValue = "0.0") double SUSPENSIONera,
            @RequestParam(name = "SUSPENSIONda", defaultValue = "0.0") double SUSPENSIONda,
            @RequestParam(name = "Comedor", defaultValue = "0.0") double Comedor,
            @RequestParam(name = "pollo", defaultValue = "0.0") double pollo,
            @RequestParam(name = "supremacrispy", defaultValue = "0.0") double supremacrispy,
            @RequestParam(name = "bocadito", defaultValue = "0.0") double bocadito,
            @RequestParam(name = "medallon", defaultValue = "0.0") double medallon,
            @RequestParam(name = "nuguets", defaultValue = "0.0") double nuguets,
            @RequestParam(name = "rikosaurio", defaultValue = "0.0") double rikosaurio,
            @RequestParam(name = "cuartotrasero", defaultValue = "0.0") double cuartotrasero,
            @RequestParam(name = "salchichas", defaultValue = "0.0") double salchichas,
            @RequestParam(name = "Comedor1", defaultValue = "0.0") double Comedor1,
            @RequestParam(name = "pollo1", defaultValue = "0.0") double pollo1,
            @RequestParam(name = "supremacrispy1", defaultValue = "0.0") double supremacrispy1,
            @RequestParam(name = "bocadito1", defaultValue = "0.0") double bocadito1,
            @RequestParam(name = "medallon1", defaultValue = "0.0") double medallon1,
            @RequestParam(name = "nuguets1", defaultValue = "0.0") double nuguets1,
            @RequestParam(name = "rikosaurio1", defaultValue = "0.0") double rikosaurio1,
            @RequestParam(name = "cuartotrasero1", defaultValue = "0.0") double cuartotrasero1,
            @RequestParam(name = "salchichas1", defaultValue = "0.0") double salchichas1,
            ModelMap modelo) throws MiException {

        Recibo recibo = reciboServicio.calcularRecibo(valorHoraNormal, valorHoraNoRem, diasPrimeraQ, diasSegundaQ,
                diasPrimeraQ, sepelio, legajo, apellido, nombre, segundonombre, mes, mes, respuesta, feriado1EraQ,
                feriado2DaQ, HsExtra50EraQ, HsExtra50DaQ, bonificacion, HsExtra100EraQ, HsExtra100DaQ, HsEnNegro,
                HsNoct1EraQ, HsNoct2DaQ, HsExtraNoct50EraQ, HsExtraNoct50DaQ, permiso1eraQ, permiso2DaQ, ajustedeSueldo,
                descuentoajuste, bonificacion, ADELANTO, SUSPENSIONera, SUSPENSIONda, Comedor, pollo, supremacrispy,
                bocadito, medallon, nuguets, rikosaurio, cuartotrasero, salchichas, Comedor1, pollo1, supremacrispy1,
                bocadito1, medallon1, nuguets1, rikosaurio1, cuartotrasero1, salchichas1, Comedor, pollo, ADELANTO,
                diasSegundaQ);

        // Datos Principales Requeridos
        modelo.addAttribute("legajo", legajo);
        modelo.addAttribute("apellido", apellido);
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("segundonombre", segundonombre);
        modelo.addAttribute("mes", mes);
        modelo.addAttribute("respuesta", respuesta);
        modelo.addAttribute("valorHoraNormal", valorHoraNormal);
        modelo.addAttribute("valorHoraNoRem", valorHoraNoRem);
        modelo.addAttribute("diasPrimeraQ", diasPrimeraQ);
        modelo.addAttribute("diasSegundaQ", diasSegundaQ);
        modelo.addAttribute("sepelio", sepelio);
        // Datos secundarios
        modelo.addAttribute("feriado1EraQ", feriado1EraQ);
        modelo.addAttribute("feriado2DaQ", feriado2DaQ);
        modelo.addAttribute("HsExtra50EraQ", HsExtra50EraQ);
        modelo.addAttribute("HsExtra50DaQ", HsExtra50DaQ);
        modelo.addAttribute("HsExtra100EraQ", HsExtra100EraQ);
        modelo.addAttribute("HsExtra100DaQ", HsExtra100DaQ);
        modelo.addAttribute("HsEnNegro", HsEnNegro);
        modelo.addAttribute("HsNoct1EraQ", HsNoct1EraQ);
        modelo.addAttribute("HsNoct2DaQ", HsNoct2DaQ);
        modelo.addAttribute("HsExtraNoct50EraQ", HsExtraNoct50EraQ);
        modelo.addAttribute("HsExtraNoct50DaQ", HsExtraNoct50DaQ);
        modelo.addAttribute("permiso1eraQ", permiso1eraQ);
        modelo.addAttribute("permiso2DaQ", permiso2DaQ);
        modelo.addAttribute("ajustedeSueldo", ajustedeSueldo);
        modelo.addAttribute("descuentoajuste", descuentoajuste);
        modelo.addAttribute("bonificacion", bonificacion);
        modelo.addAttribute("ADELANTO", ADELANTO);
        modelo.addAttribute("SUSPENSIONera", SUSPENSIONera);
        modelo.addAttribute("SUSPENSIONda", SUSPENSIONda);
        // Comedor y mercaderia
        modelo.addAttribute("Comedor", Comedor);
        modelo.addAttribute("pollo", pollo);
        modelo.addAttribute("supremacrispy", supremacrispy);
        modelo.addAttribute("bocadito", bocadito);
        modelo.addAttribute("medallon", medallon);
        modelo.addAttribute("nuguets", nuguets);
        modelo.addAttribute("rikosaurio", rikosaurio);
        modelo.addAttribute("cuartotrasero", cuartotrasero);
        modelo.addAttribute("salchichas", salchichas);
        modelo.addAttribute("Comedor1", Comedor1);
        modelo.addAttribute("pollo1", pollo1);
        modelo.addAttribute("supremacrispy1", supremacrispy1);
        modelo.addAttribute("bocadito1", bocadito1);
        modelo.addAttribute("medallon1", medallon1);
        modelo.addAttribute("nuguets1", nuguets1);
        modelo.addAttribute("rikosaurio1", rikosaurio1);
        modelo.addAttribute("cuartotrasero1", cuartotrasero1);
        modelo.addAttribute("salchichas1", salchichas1);

        //////////////////////////////////////////////////////////////////////////////////////////

        modelo.addAttribute("recibo", recibo);

        return "resultado"; // Redirige a la página "resultado.html"
    }

}
