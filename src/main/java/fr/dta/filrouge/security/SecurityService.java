package fr.dta.filrouge.security;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fr.dta.filrouge.user.User;
import fr.dta.filrouge.user.UserRepository;

@Service(value = "securityService")
public class SecurityService implements Serializable {
	private static final long serialVersionUID = -5202158449829327001L;
	
    @Autowired
    UserRepository utilisateurRepository;
    
    public User getConnectedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if(authentication == null) {
            return null;
        }
        
        org.springframework.security.core.userdetails.User u = (org.springframework.security.core.userdetails.User) authentication
                .getPrincipal();
        return utilisateurRepository.findByEmail(u.getUsername());
    }

}
