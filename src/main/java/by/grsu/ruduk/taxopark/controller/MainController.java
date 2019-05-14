package by.grsu.ruduk.taxopark.controller;

import by.grsu.ruduk.taxopark.model.User;
import by.grsu.ruduk.taxopark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


  @GetMapping(value = {"/", "/home"})
  public String getMainPage(Model model) {
    model.addAttribute("isAuhorised", getCurrentUser() != null);
    return "index";
  }

  private User getCurrentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return userRepository.findByUsername(auth.getName());
  }

  @Autowired
  private UserRepository userRepository;
}
