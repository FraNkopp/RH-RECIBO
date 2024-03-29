/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recibos.controladores;

import recibos.entidades.Usuario;
import recibos.enumeraciones.Rol;
import recibos.excepciones.MiException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import recibos.repositorios.UsuarioRepositorio;
import recibos.servicios.UsuarioServicio;

/**
 *
 * @author FraNko
 */
@Controller
@RequestMapping("/") //localhost:8080
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

//    @GetMapping("/")//localhost:8080
//    public String index() {
//        return "index.html";
//
//    }
    @GetMapping("/")//localhost:8080
    public String index(ModelMap modelo, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        if (usuario != null) {
            modelo.put("usuario", usuario);//usuarioServicio.getOne(usuario.getId())
        }
        return "index.html";

    }
     /////////////////
    //RECUPERACION DE PASSWORD
    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
        return "forgot-password"; // Renderiza la vista para solicitar el restablecimiento de contraseña
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam String email, RedirectAttributes redirectAttributes) {
        try {
            usuarioServicio.generarTokenYEnviarCorreo(email);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha enviado un correo electrónico para restablecer la contraseña.");
        } catch (MiException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/login"; // Redirige de vuelta a la página de inicio de sesión
    }

    @GetMapping("/reset-password")
    public String showResetPasswordPage(@RequestParam String token, Model model, RedirectAttributes redirectAttributes) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findByResetToken(token);
        if (usuarioOptional.isPresent()) {
            model.addAttribute("token", token);
            return "reset-password"; // Renderiza la vista para cambiar la contraseña
        } else {
            redirectAttributes.addFlashAttribute("error", "Token inválido para restablecer la contraseña.");
            return "redirect:/login"; // O muestra un mensaje de error y redirige a la página de inicio de sesión
        }
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String newPassword, RedirectAttributes redirectAttributes) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findByResetToken(token);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            try {
                usuario.setPassword(new BCryptPasswordEncoder().encode(newPassword));
                usuario.setResetToken(null); // Borra el token después de cambiar la contraseña
                usuarioRepositorio.save(usuario);
                redirectAttributes.addFlashAttribute("mensaje", "Contraseña restablecida con éxito. Inicia sesión con tu nueva contraseña.");
                return "redirect:/"; // Redirige a la página de inicio de sesión
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Hubo un error al restablecer la contraseña. Inténtalo de nuevo más tarde.");
                return "redirect:/"; // O muestra un mensaje de error y redirige a la página de inicio de sesión
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Token inválido para restablecer la contraseña.");
            return "redirect:/"; // O muestra un mensaje de error y redirige a la página de inicio de sesión
        }
    }
    //FIN DE RECUPERACION DE PASSWORD
    ////////////////
    
    //CORRESPONDE AL ADMIN
    @GetMapping("/lista")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String listarUsuarios(ModelMap modelo) {
        List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("listaUsuarios", listaUsuarios);
        return "listaUsuarios.html";
    }
    //CORRESPONDE AL ADMIN

    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String id, ModelMap model) {
        try {
            usuarioServicio.eliminarUsuario(id);
            return "redirect:../lista";
        } catch (Exception e) {
            model.put("error", e.getMessage());
        }
        return "redirect:../lista";
    }

    @GetMapping("/registrar")//localhost:8080/registrar
    public String registrar() {
        return "login.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email,
            @RequestParam String password, String password2, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaNacimiento,
            @RequestParam String sexo, RedirectAttributes redirectAttributes) throws Exception {
        try {
            usuarioServicio.registrar(nombre, apellido, email, password, password2, fechaNacimiento, sexo);
            redirectAttributes.addFlashAttribute("mensaje", "Registro Exitoso. Ahora puedes Iniciar Sesión.");
            return "redirect:/login";
        } catch (MiException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/registrar";
        }
    }

    @GetMapping("/login")//localhost:8080/login
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o Contraseña Invalidos!");
        }
        return "login.html";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio.html";
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificarContrasena(ModelMap modelo) {
        // Lógica para cargar datos necesarios, si es necesario
        modelo.addAttribute("mensaje", "¡Bienvenido al formulario de modificación de contraseña!");
        return "modificar";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(
            @PathVariable String id,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String email,
            RedirectAttributes redirectAttributes
    ) throws MiException {
        try {

            usuarioServicio.modificarUsuario(id, nombre, apellido, email);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario modificado Correctamente");
            return "redirect:../perfil/{id}";
        } catch (MiException ex) {
            System.out.println(ex.getMessage());
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:../perfil/{id}";
        }
    }

    @GetMapping("/modificar1/{id}")
    public String mostrarFormularioModificarContrasena1(ModelMap modelo) {
        // Lógica para cargar datos necesarios, si es necesario
        modelo.addAttribute("mensaje", "¡Bienvenido al formulario de modificación de contraseña!");
        return "modificar1";
    }

    @PostMapping("/modificar1/{id}")
    public String modificar1(
            @PathVariable String id,
            @RequestParam String currentPassword,
            @RequestParam String newPassword,
            @RequestParam String newPassword2,
            RedirectAttributes redirectAttributes
    ) {
        try {
            if (!newPassword.equals(newPassword2)) {
                throw new MiException("Las contraseñas no coinciden");
            }

            usuarioServicio.actualizarPassword(id, currentPassword, newPassword);
            redirectAttributes.addFlashAttribute("mensaje", "Contraseña modificada correctamente");
            return "redirect:../perfil1/{id}";
        } catch (MiException ex) {
            System.out.println(ex.getMessage());
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:../perfil1/{id}";
        }
    }

    @GetMapping("/modificarAdmin/{id}")
    public String modificarAdmin(ModelMap modelo) {
        // Lógica para cargar datos necesarios, si es necesario
        modelo.addAttribute("mensaje", "¡Bienvenido al formulario de modificación de contraseña!");
        return "modificarAdmin";
    }

    @PostMapping("/modificarAdmin/{id}")
    public String modificarAdmin(
            @PathVariable String id,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String email,
            @RequestParam Rol nuevoRol,
            RedirectAttributes redirectAttributes
    ) throws MiException {
        try {
            usuarioServicio.AdministradorModifica(id, nombre, apellido, email, nuevoRol);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario modificado Correctamente");
            return "redirect:../perfilAdmin/{id}";
        } catch (MiException ex) {
            System.out.println(ex.getMessage());
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:../perfilAdmin/{id}";
        }
    }

    @GetMapping("/perfil/{id}")
    public String mostrarFormulario(@PathVariable String id, ModelMap modelo) {
        // Lógica para obtener el usuario por ID y agregarlo al modelo
        Usuario usuario = usuarioServicio.getOne(id);
        modelo.addAttribute("usuario", usuario);
        return "perfil_usuario.html";
    }

    @PostMapping("/perfil/{id}")
    public String actualizar(@PathVariable String id, @RequestParam String nombre, @RequestParam String apellido,
            @RequestParam String email, @RequestParam String password, ModelMap modelo,
            HttpSession session) throws Exception {
        try {
            System.out.println("Controlador de perfil ejecutado. ID: " + id);

            Usuario usuario = usuarioServicio.actualizar(id, nombre, apellido, email, password);
            session.setAttribute("usuariosession", usuario);
            return "redirect:/";
        } catch (MiException ex) {
            System.out.println("Error en el controlador de perfil: " + ex.getMessage());
            modelo.put("error", ex.getMessage());
            ex.printStackTrace();
            Usuario usuario = usuarioServicio.getOne(id);
            modelo.put("usuario", usuario);
            return "redirect:/perfil/{id}";
        }
    }

    @GetMapping("/perfil1/{id}")
    public String mostrarFormulario1(@PathVariable String id, ModelMap modelo) {
        // Lógica para obtener el usuario por ID y agregarlo al modelo
        Usuario usuario = usuarioServicio.getOne(id);
        modelo.addAttribute("usuario", usuario);
        return "perfil_usuario1.html";
    }

    @PostMapping("/perfil1/{id}")
    public String actualizarContraseña(@PathVariable String id, @RequestParam String password, ModelMap modelo,
            HttpSession session) throws Exception {
        try {
            System.out.println("Controlador de perfil ejecutado. ID: " + id);

            Usuario usuario = usuarioServicio.actualizarPassword(id, password, password);
            session.setAttribute("usuariosession", usuario);
            return "redirect:/";
        } catch (MiException ex) {
            System.out.println("Error en el controlador de perfil: " + ex.getMessage());
            modelo.put("error", ex.getMessage());
            ex.printStackTrace();
            Usuario usuario = usuarioServicio.getOne(id);
            modelo.put("usuario", usuario);
            return "redirect:/perfil/{id}";
        }
    }

    @GetMapping("/perfilAdmin/{id}")
    public String mostrarFormularioAdmin(@PathVariable String id, ModelMap modelo) {
        // Lógica para obtener el usuario por ID y agregarlo al modelo
        Usuario usuario = usuarioServicio.getOne(id);
        modelo.addAttribute("usuario", usuario);
        return "adminModifica.html";
    }

    @PostMapping("/perfilAdmin/{id}")
    public String mostrarFormularioAdmin(@PathVariable String id, @RequestParam String password, ModelMap modelo,
            HttpSession session) throws Exception {
        try {
            System.out.println("Controlador de perfil ejecutado. ID: " + id);

            Usuario usuario = usuarioServicio.actualizarPassword(id, password, password);
            session.setAttribute("usuariosession", usuario);
            return "redirect:/";
        } catch (MiException ex) {
            System.out.println("Error en el controlador de perfil: " + ex.getMessage());
            modelo.put("error", ex.getMessage());
            ex.printStackTrace();
            Usuario usuario = usuarioServicio.getOne(id);
            modelo.put("usuario", usuario);
            return "redirect:/adminModifica/{id}";
        }
    }
}
