///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package recibo.controladores;
//
///**
// *
// * @author FraNko
// */
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.io.ByteArrayOutputStream;
//import java.io.OutputStream;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.xhtmlrenderer.pdf.ITextRenderer;
//// ... (otras importaciones)
//
//@Controller
//@RequestMapping("/") // localhost:8080
//public class ReciboSueldoController {
//
//
//    @GetMapping("/generar-recibo-pdf")
//    public ResponseEntity<byte[]> generarReciboPDF(Model model) throws Exception {
//        // Llama al método que genera el recibo en HTML
//        String htmlContent = generarRecibo(model);
//
//        // Convierte el HTML a PDF usando Flying Saucer
//        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
//            ITextRenderer renderer = new ITextRenderer();
//            renderer.setDocumentFromString(htmlContent);
//            renderer.layout();
//            renderer.createPDF(os, false);
//            renderer.finishPDF();
//
//            // Configura la respuesta para que el navegador descargue el PDF
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.setContentDispositionFormData("attachment", "recibo-sueldo.pdf");
//
//            // Retorna el contenido del PDF como un array de bytes
//            return new ResponseEntity<>(os.toByteArray(), headers, HttpStatus.OK);
//        }
//    }
//
//   private String generarRecibo(Model model) {
//    StringBuilder htmlBuilder = new StringBuilder();
//    htmlBuilder.append("<html><body>");
//
//    // Encabezado del recibo
//    htmlBuilder.append("<h1>Recibo de Sueldo</h1>");
//
//    // Tabla del recibo
//    htmlBuilder.append("<table>");
//    htmlBuilder.append("<tr><th colspan='2'>Información Personal</th><th colspan='4'>Datos Laborales</th></tr>");
//
//    // Filas con datos personales
//    htmlBuilder.append("<tr><td colspan='2'>Número de Legajo</td><td colspan='4'>APELLIDO Y NOMBRE</td></tr>");
//    htmlBuilder.append("<tr><td>").append(model.getAttribute("${recibo.legajo}")).append("</td>");
//    htmlBuilder.append("<td colspan='2'>").append(model.getAttribute("apellido")).append(", ").append(model.getAttribute("nombre")).append(" ").append(model.getAttribute("segundonombre")).append("</td>");
//    htmlBuilder.append("<td>C.U.I.L.</td><td colspan='2'>FECHA DE INGRESO</td></tr>");
//    htmlBuilder.append("<tr><td>00.00000000.00</td>");
//    htmlBuilder.append("<td colspan='2'>01/01/2023</td>");
//    
//    // Filas con datos laborales
//    htmlBuilder.append("<td>").append(model.getAttribute("mes")).append("</td><td>OBRA SOCIAL</td>");
//    htmlBuilder.append("<td>").append(model.getAttribute("resp")).append("</td>");
//    htmlBuilder.append("<td colspan='2'>A TIEMPO COMPLETO INDETER</td></tr>");
//    
//    htmlBuilder.append("<tr><td>SECTOR/ACTUAL</td><td>CALIFICADO</td>");
//    htmlBuilder.append("<td>CALIFICADO</td><td>").append(model.getAttribute("valorHoraNormal")).append("</td>");
//    htmlBuilder.append("<td colspan='2'>").append(model.getAttribute("valorHoraNoRem")).append("</td></tr>");
//
//    // ... Puedes seguir añadiendo más filas según la estructura de tu tabla
//
//    htmlBuilder.append("</table>");
//
//    htmlBuilder.append("</body></html>");
//System.out.println("Legajo: " + model.getAttribute("legajo"));
//System.out.println("Apellido: " + model.getAttribute("apellido"));
//// Imprime otros datos...
//
//    return htmlBuilder.toString();
//}
//
//}