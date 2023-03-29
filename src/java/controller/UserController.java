/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import service.UsersFacade;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {

    private Users user = new Users();
    private String mensaje;

    @EJB
    private UsersFacade usersfacade;

    public String authenticate() {
        // Verificar la autenticación del usuario en la base de datos
        if (isValidUser(getUser().getUsername(), getUser().getPassword())) {
            // Almacenar el usuario en la sesión
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(true);
            session.setAttribute("user", getUser());

            // Redirigir a la página correspondiente según el usuario autenticado
            if (getUser().getUsername().equals("Administrador@gmail.com")) {
                return "/administrador/tableroAdministrador.xhtml?faces-redirect=true";
            } else if (getUser().getUsername().equals("ResidenteDeobra@gmail.com")) {
                return "ResidenteDeobra/tableroResidente.xhtml?faces-redirect=true";
            } else if (getUser().getUsername().equals("AsistenteAdministrativo@gmail.com")) {
                return "AsistenteAdministrativo/tableroAsistente.xhtml?faces-redirect=true";
            } else if (getUser().getUsername().equals("Almacenista@gmail.com")) {
                return "Almacenista/tableroAlmacenista.xhtml?faces-redirect=true";
            } else if (getUser().getUsername().equals("cliente")) {
                return "Cliente/tableroCliente.xhtml?faces-redirect=true";
            } else {
                return null;
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Invalid username or password", null));
            return null;
        }
    }

    public String register() {
        // Insertar un nuevo usuario en la base de datos
        if (isValidRegistration(getUser().getUsername(), getUser().getPassword())) {
            insertUser(getUser().getUsername(), getUser().getPassword());
            return "signin.xhtml?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Username already exists", null));
            return null;
        }
    }

    private boolean isValidUser(String username, String password) {
        // Verificar si el usuario existe en la base de datos
        // y si la contraseña es correcta

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("molding5");
        EntityManager em = emf.createEntityManager();

        boolean isValid = false;

        try {
            Query query = em.createQuery("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            Users user = (Users) query.getSingleResult();
            isValid = (user != null);
        } catch (NoResultException e) {
            // El usuario no existe o la contraseña es incorrecta
        } finally {
            em.close();
            emf.close();
        }

        return isValid;
    }

    private boolean isValidRegistration(String username, String password) {
        // Verificar si el nombre de usuario ya existe en la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("molding5");
        EntityManager em = emf.createEntityManager();
        boolean isValid = true;
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
            query.setParameter("username", username);
            List<Users> users = query.getResultList();
            if (users != null && !users.isEmpty()) {
                // El nombre de usuario ya está en uso
                isValid = false;
            }
        } finally {
            em.close();
            emf.close();
        }
        return isValid;

    }

    private void insertUser(String username, String password) {
        // Insertar un nuevo usuario en la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("molding5");
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar una transacción
            em.getTransaction().begin();

            // Crear un nuevo objeto Users con el nombre de usuario y la contraseña proporcionados
            Users newUser = new Users();
            newUser.setUsername(username);
            newUser.setPassword(password);

            // Insertar el nuevo usuario en la base de datos
            em.persist(newUser);

            // Commit de la transacción
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }

    }

    //cerrar sesion
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "/signin.xhtml?faces-redirect=true";
    }

    //list
    public List<Users> getAllusers() {
        return usersfacade.findAll();
    }

    // Getters y setters
    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the usersfacade
     */
    public UsersFacade getUsersfacade() {
        return usersfacade;
    }

    /**
     * @param usersfacade the usersfacade to set
     */
    public void setUsersfacade(UsersFacade usersfacade) {
        this.usersfacade = usersfacade;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
