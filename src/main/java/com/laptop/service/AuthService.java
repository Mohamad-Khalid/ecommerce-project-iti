package com.laptop.service;

import com.laptop.dao.CustomerDAO;
import com.laptop.dto.AuthRequest;
import com.laptop.dto.CustomerDTO;
import com.laptop.dto.RegistrationRequest;
import com.laptop.entity.Cart;
import com.laptop.entity.Customer;

import com.laptop.entity.Wishlist;
import com.laptop.security.JwtService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.mindrot.jbcrypt.BCrypt;


import jakarta.persistence.EntityManager;

import java.util.Set;


public class AuthService {
    CustomerDAO customerDAO;
    public AuthService(){
        customerDAO = new CustomerDAO();
    }
    public CustomerDTO register(RegistrationRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<RegistrationRequest>> violations =
                validator.validate(request);
        ///Handle Exception
        if(!violations.isEmpty()){
            violations.forEach(violation -> System.out.println(violation.getMessage()));
            return null;
        }
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setActive(true);

        Customer saved = customerDAO.save(customer);
        if(saved == null){
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(saved.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }
    public String loginWithToken(AuthRequest request) {
        try {
            Customer customer = customerDAO.findCustomerByEmail(request.getEmail());

            if (BCrypt.checkpw(request.getPassword(), customer.getPassword())) {
                // HttpSession httpSession = req.getSession(true);
                // if (req.getParameter("remember") != null &&
                // req.getParameter("remember").equals("on")) {

                // String tokenString = JwtService.generate(user);
                // Token token = new Token(user, RandomStringUtils.randomAlphanumeric(35),
                // java.sql.Date.valueOf(LocalDate.now().plusDays(1)));
                // EntityManager em2 = emf.createEntityManager();
                // TokenDAO tokenDAO = new TokenDAO(em2);
                // tokenDAO.save(token);
                String token = JwtService.generate(customer.getId(),
                        "CUSTOMER");
                System.out.println(token);

                return token;
                // Cookie c = new Cookie("token", token);
                // c.setPath("/myApp/auth");
                // System.out.println("cookie" + c.getPath());

                // c.setMaxAge(60 * 60 * 24);
                // resp.addCookie(c);
                // // }

                // httpSession.setAttribute("name", req.getParameter("username"));
                // String redirect = req.getParameter("redirect");
                // resp.sendRedirect(redirect == null ? "/myApp/app/welcome" : redirect);
            } else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean login(AuthRequest request) {
        try {

            Customer customer = customerDAO.findCustomerByEmail(request.getEmail());
            return BCrypt.checkpw(request.getPassword(), customer.getPassword());

        } catch (Exception e) {
            return false;
        }

    }
}
