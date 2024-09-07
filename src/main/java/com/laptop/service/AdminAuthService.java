package com.laptop.service;

import com.laptop.dao.AdminDAO;
import com.laptop.dto.AuthRequest;
import com.laptop.dto.AdminDTO;
import com.laptop.dto.RegistrationRequest;
import com.laptop.entity.Admin;
import com.laptop.security.JwtService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Set;

public class AdminAuthService {
    AdminDAO adminDAO;
    public AdminAuthService(){
        adminDAO = new AdminDAO();
    }
    public AdminDTO register(RegistrationRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<RegistrationRequest>> violations =
                validator.validate(request);
        ///Handle Exception
        if(!violations.isEmpty()){
            violations.forEach(violation -> System.out.println(violation.getMessage()));
            return null;
        }
        Admin admin = new Admin();
        admin.setEmail(request.getEmail());
        admin.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        Admin saved = adminDAO.save(admin);
        if(saved == null){
            return null;
        }

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(saved.getId());
        adminDTO.setEmail(admin.getEmail());

        return adminDTO;
    }
    public String loginWithToken(AuthRequest request) {
        try {
            Admin admin = adminDAO.findAdminByEmail(request.getEmail());

            if (BCrypt.checkpw(request.getPassword(), admin.getPassword())) {
                String token = JwtService.generate(admin.getId(),
                        "ADMIN");
                System.out.println(token);
                return token;
            } else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean login(AuthRequest request) {
        try {

            Admin admin = adminDAO.findAdminByEmail(request.getEmail());
            return BCrypt.checkpw(request.getPassword(), admin.getPassword());

        } catch (Exception e) {
            return false;
        }

    }
}
