package com.api.crud.services;

import com.api.crud.models.User;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository iUserRepository;

    public ArrayList<User> traerUsuarios() {
        return (ArrayList<User>) iUserRepository.findAll();
    }
    public Optional<User> buscarUsuario_ID(Long id) {
        return iUserRepository.findById(id);
    }
    public User editarUsuario(User newUser,Long id)throws Exception {
        User updateUser;
        Optional<User> userBBDD = iUserRepository.findById(id);

        if(userBBDD.isPresent()) {
            updateUser = userBBDD.get();
            updateUser.setFirstName(newUser.getFirstName());
            updateUser.setLastName(newUser.getLastName());
            updateUser.setEmail(newUser.getEmail());
            iUserRepository.save(updateUser);
        } else {
            throw new Exception("El Usuario con el ID: "+id+" no pudo ser encontrado");
        }
        return updateUser;
    }
    public String eliminarUsuario(Long id) {
        Optional<User> userBBDD = iUserRepository.findById(id);
        if(userBBDD.isPresent()) {
            iUserRepository.delete(userBBDD.get());
            return "El usuario "+userBBDD.get().getFirstName()+" fue eliminado correctamente";
        }
        return "El usuario con el ID "+id+" no fue encontrado";
    }
    public User agregarUsuario(User usuario)throws Exception {
        boolean haveSign = false;

        for(int i=0;i<usuario.getEmail().length();i++) {
            if(usuario.getEmail().charAt(i) == '@') {
                haveSign = true; break;
            }
        }
        if(!haveSign) {
            throw new Exception("El email no posee '@'");
        }

        return iUserRepository.save(usuario);
    }
}
