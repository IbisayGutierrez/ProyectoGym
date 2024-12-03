package Controller;

import Modelo.Usuario.Usuario;
import Modelo.Usuario.UsuarioDAO;
import Modelo.Usuario.UsuarioDTO;
import Modelo.Usuario.UsuarioMapper;
import View.View;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UsuarioController {
    private final UsuarioDAO usuarioDAO;
    private final UsuarioMapper usuarioMapper;
    private final View view;

    public UsuarioController(View view, Connection connection) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO(connection); // Conexión inyectada
        this.usuarioMapper = new UsuarioMapper();
    }

    public void agregarUsuario(Usuario usuario) {
        if (usuario == null || !validarUsuario(usuario)) {
            view.showError("Datos del usuario no válidos o nulos.");
            return;
        }

        try {
            UsuarioDTO dto = usuarioMapper.toDTO(usuario);
            usuarioDAO.create(dto);
            view.showMessage("Usuario agregado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al guardar los datos: " + e.getMessage());
        }
    }

    public Usuario obtenerUsuario(int id) {
        try {
            UsuarioDTO dto = usuarioDAO.read(id);
            return usuarioMapper.toEnt(dto);
        } catch (SQLException e) {
            view.showError("Error al obtener el usuario: " + e.getMessage());
            return null;
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        if (usuario == null || !validarUsuario(usuario)) {
            view.showError("Datos del usuario no válidos o nulos.");
            return;
        }

        try {
            usuarioDAO.update(usuarioMapper.toDTO(usuario));
            view.showMessage("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        try {
            if (!validatePK(id)) {
                view.showError("El ID ingresado no se encuentra registrado.");
                return;
            }
            usuarioDAO.delete(id);
            view.showMessage("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            view.showError("Ocurrió un error al eliminar los datos: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            List<UsuarioDTO> dtoList = usuarioDAO.readAll();
            return dtoList.stream()
                    .map(dto -> {
                        try {
                            return usuarioMapper.toEnt(dto);
                        } catch (Exception e) {
                            throw new RuntimeException("Error al mapear UsuarioDTO a Usuario", e);
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            view.showError("Error al cargar los datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean validarCredenciales(String nombre, String password) {
        
    try {
        List<UsuarioDTO> usuarios = usuarioDAO.readAll();
        
        for (UsuarioDTO usuarioDTO : usuarios) {
            if (usuarioDTO.getNombre().equals(nombre) && usuarioDTO.getPassword().equals(password)) {
                view.showMessage("Credenciales válidas. Bienvenido: " + nombre);
                return true; 
            }
        }
        
        view.showError("Credenciales incorrectas.");
        return false;
        
    } catch (SQLException e) {
        // Manejo de errores, por ejemplo si hay un problema con la consulta
        view.showError("Error al validar las credenciales: " + e.getMessage());
        return false;
    }


    }

    private boolean validarUsuario(Usuario usuario) {
        
        return !usuario.getNombre().trim().isEmpty() &&
               !usuario.getPassword().trim().isEmpty() &&
               (usuario.getRol() != null);
    }

    public boolean validatePK(int id) {
        try {
            return usuarioDAO.validatePK(id);
        } catch (SQLException ex) {
            return false;
        }
    }
}
