package by.grsu.ruduk.taxopark.controller;

import by.grsu.ruduk.taxopark.form.RegisterForm;
import by.grsu.ruduk.taxopark.model.User;
import by.grsu.ruduk.taxopark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("form") RegisterForm registerForm, Model model) {
        String username = registerForm.getUsername();
        User user = userRepository.findByUsername(username);
        if (user != null) {
            model.addAttribute("loginError", true);
            return "register";
        } else {
            User newUser = new User();
            newUser.setUsername(registerForm.getUsername());
            newUser.setPassword(passwordEncoder.encode(registerForm.getPassword()));
            userRepository.save(newUser);

            UserDetails userDetails = userDetailsService.loadUserByUsername(newUser.getUsername());
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
              new UsernamePasswordAuthenticationToken(userDetails, registerForm.getPassword(), userDetails.getAuthorities());
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if (usernamePasswordAuthenticationToken.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        return "redirect:/home";
    }
}