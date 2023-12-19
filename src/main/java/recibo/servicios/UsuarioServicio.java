/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recibo.servicios;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import recibo.entidades.Usuario;
import recibo.enumeraciones.Rol;
import recibo.excepciones.MiException;
import recibo.repositorios.UsuarioRepositorio;

/**
 *
 * @author FraNko
 */
@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private EmailServicio emailServicio;

    @Transactional
    public void registrar(String nombre, String apellido, String email, String password, String Password2, Date fechaNacimiento, String sexo) throws Exception {
        //Llamamos al metodo validar
        validar(nombre, apellido, email, password, Password2, fechaNacimiento, sexo);

        Usuario usuarioExistente = usuarioRepositorio.buscarPorEmail(email);
        if (usuarioExistente != null) {
            throw new MiException("El correo electrónico ya está en uso.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setSexo(sexo);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);
    }

    ////////////// 
    // RECUPERACION DE PASSWORD
    @org.springframework.transaction.annotation.Transactional
    public void generarTokenYEnviarCorreo(String email) throws MiException {
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
        if (usuario != null) {
            String token = UUID.randomUUID().toString();
            usuario.setResetToken(token);
            usuarioRepositorio.save(usuario);

            // Aquí llama al servicio de correo para enviar el correo electrónico con el token
            String mensaje = "Utilice este enlace para restablecer su contraseña: http://localhost:8080/reset-password?token=" + token;
            emailServicio.sendEmail("noreply@tuapp.com", email, "Restablecimiento de contraseña", mensaje);
        } else {
            throw new MiException("El correo electrónico proporcionado no está asociado a ninguna cuenta.");
        }
    }
    //FIN DE RECUPERACION DE PASSWORD
    ////////////////
    public Usuario getOne(String id) {
        return usuarioRepositorio.getOne(id);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList();
        usuarios = usuarioRepositorio.findAll();
        return usuarios;
    }

    
    public void eliminarUsuario(String id) throws MiException {
        if (id.isEmpty() || id.equals("")) {
            throw new MiException("el id proporcionado es nulo");
        } else {
            Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
            if (respuesta.isPresent()) {
                Usuario usuario = respuesta.get();
                usuarioRepositorio.delete(usuario);
            }
        }
    }

    @Transactional
    public Usuario actualizar(String id, String nombre, String apellido, String email, String password) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("el apellido no puede ser nulo o estar vacio");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacia, y debe tener mas de 5 digitos");
        }

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            if (!usuario.getEmail().equals(email) && usuarioRepositorio.buscarPorEmail(email) != null) {
                throw new MiException("El email ya está en uso");
            }

            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);

            usuario.setPassword(new BCryptPasswordEncoder().encode(password));
            usuario.setRol(usuario.getRol());

            usuarioRepositorio.save(usuario);

            return usuarioRepositorio.save(usuario);
        } else {
            throw new MiException("Usuario no encontrado"); // Manejo de caso donde el usuario no se encuentra
        }
    }

    @Transactional
    public Usuario AdministradorModifica(String id, String nombre, String apellido, String email, Rol nuevoRol) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("el apellido no puede ser nulo o estar vacio");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
      
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            // Update user information
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            

            // Modificar el rol
            usuario.setRol(nuevoRol);

            usuarioRepositorio.save(usuario);
            return usuario; // Returns the modified user
        } else {
            throw new MiException("Usuario no encontrado");
        }
    }
    @Transactional
    public Usuario actualizarPassword(String id, String currentPassword, String newPassword) throws MiException {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            // Verificar si la contraseña actual ingresada es correcta
            if (!new BCryptPasswordEncoder().matches(currentPassword, usuario.getPassword())) {
                throw new MiException("La contraseña actual no es correcta");
            }

            // Actualizar la contraseña con la nueva
            usuario.setPassword(new BCryptPasswordEncoder().encode(newPassword));

            // Guardar el usuario actualizado
            return usuarioRepositorio.save(usuario);
        } else {
            throw new MiException("Usuario no encontrado");
        }
    }

    /////////////////////
    @Transactional
    public Usuario modificarUsuario(String id, String nombre, String apellido, String email) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("el apellido no puede ser nulo o estar vacio");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            // Update user information
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);

            usuarioRepositorio.save(usuario);
            return usuario; // Returns the modified user
        } else {
            throw new MiException("Usuario no encontrado");
        }
    }

    @Transactional
    public Usuario modificarUsuario1(String id, String password) throws MiException {

        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacia, y debe tener mas de 5 digitos");
        }
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            usuario.setPassword(new BCryptPasswordEncoder().encode(password));

            usuarioRepositorio.save(usuario);
            return usuario; // Returns the modified user
        } else {
            throw new MiException("Usuario no encontrado");
        }
    }

    private void validar(String nombre, String apellido, String email, String password, String password2, Date fechaNacimiento, String sexo) throws Exception {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("el apellido no puede ser nulo o estar vacio");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacia, y debe tener mas de 5 digitos");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }
        if (fechaNacimiento == null) {
            throw new Exception("Fecha de nacimiento no especificada");
        }
        if (sexo.isEmpty() || sexo == null) {
            throw new MiException("el sexo no puede ser nulo o estar vacio");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }

    }

}
