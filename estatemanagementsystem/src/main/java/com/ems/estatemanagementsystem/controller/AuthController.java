package com.ems.estatemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.estatemanagementsystem.dto.UserDto;
import com.ems.estatemanagementsystem.entity.Property;
import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.Wasiat;
import com.ems.estatemanagementsystem.service.PropertyService;
import com.ems.estatemanagementsystem.service.UserService;
import com.ems.estatemanagementsystem.service.WasiatService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

    private UserService userService;

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private WasiatService wasiatService;



    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm() {
        if (userService.findAllUsers().isEmpty()) {
            userService.initAdmin();
        }
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute UserDto user, BindingResult result,
            Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null,
                    "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.isAuthenticated()) {
            String username = authentication.getName();
            User user = userService.getCurrentUser();
            Long userId = user.getId();


            model.addAttribute("username", username);
            model.addAttribute("userId", userId);
        }
        return "users";
    }

    @GetMapping("/users/editprofile")
    public String editprofileform(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        if (user.getId() == null) {
            // Handle the case where the user ID is null
            // This might involve showing an error message or redirecting to an error page
            return "error";
        }
        return "editprofile";
    }

    // handler method to handle register user form submit request
    @PostMapping("/users/editprofile/save")
    public String editprofile(@ModelAttribute User user, BindingResult result, Model model) {
        // User existing = userService.getCurrentUser();
        if (user.getId() == null) {
            // Handle the case where the user ID is null
            // This might involve showing an error message or redirecting to an error page
            return "error";
        }

        User currentUser = userService.getCurrentUser();
        User existingUser = userService.findByEmail(user.getEmail());

        if (existingUser != null) {
            if (!currentUser.getEmail().equals(existingUser.getEmail())
                    && user.getEmail().equals(existingUser.getEmail())) {
                result.rejectValue("email", null,
                        "There is already an account registered with that email");
            }
            if (result.hasErrors()) {
                // model.addAttribute("user", user);
                System.out.println("Ada error");
                return "redirect:/users/editprofile";
            }
        }

        userService.updateUser(user);
        return "redirect:/users/editprofile";
    }

    @GetMapping("/admin")
    public String listRegisteredUsers(Model model) {
        List<User> pewarisList = userService.findAllPewaris();
        model.addAttribute("pewarisList", pewarisList);
        return "admin";
    }

    @GetMapping("/admin/adminlist")
    public String listAdmin(Model model) {
        List<User> adminList = userService.findAllAdmins();
        model.addAttribute("adminList", adminList);
        return "adminList";
    }

    // handler method to handle user registration request
    @GetMapping("/admin/addadmin")
    public String addAdmin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "adminAdd";
    }

    @PostMapping("/admin/addadmin/save")
    public String addAdmin(@ModelAttribute("admin") User user, Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            model.addAttribute("msg", "Admin with email is already existed.");
            return "redirect:/adminList";
        }
        userService.saveAdmin(user);
        return "redirect:/adminList";
    }

    @GetMapping("/admin/pewarisDetail/{id}")
    public String pewarisDetail(@PathVariable Long id, Model model) {

        User pewaris = userService.findUserById(id);

        model.addAttribute("pewaris", pewaris);

        return "adminUserDetails";
    }

    @GetMapping("/admin/pewarisProperty/{id}")
    public String pewarisProperty(@PathVariable Long id, Model model) {

        List<Property> propertyList = propertyService.getPropertiesByUserId(id);

        model.addAttribute("propertyList", propertyList);

        return "adminUserProperty";
    }

    @GetMapping("/admin/pewarisHeirs/{id}")
    public String pewarisHeirs(@PathVariable Long id, Model model) {
        Wasiat wasiat = wasiatService.getWasiatByUserId(id);
        model.addAttribute("wasiat", wasiat);
        return "adminUserHeirs";
    }

    @GetMapping("/admin/deletePewaris/{id}")
    public String pewarisDelete(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/adminDelete/{id}")
    public String adminDelete(@PathVariable Long id, Model model) {

        userService.deleteUserById(id);

        List<User> adminList = userService.findAllAdmins();
        model.addAttribute("adminList", adminList);
        return "redirect:/admin/adminlist";
    }

    @GetMapping("/admin/pewarisWasiat/{id}")
    public String pewarisWasiat(@PathVariable Long id, Model model) {
        User user = wasiatService.getWasiatDetailsByUserId(id);
        Wasiat wasiat = wasiatService.getWasiatByUserId(user.getId());
        List<Property> propertyList = propertyService.getPropertiesByUserId(user.getId());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("username", username);
        if (wasiat != null) {
            model.addAttribute("propertyList", propertyList);
            model.addAttribute("wasiat", wasiat);
            return "wasiatDetails";
        }

        return "adminUserWasiat";
    }



}
