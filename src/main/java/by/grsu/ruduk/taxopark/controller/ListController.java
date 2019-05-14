package by.grsu.ruduk.taxopark.controller;

import by.grsu.ruduk.taxopark.model.BlackList;
import by.grsu.ruduk.taxopark.model.Driver;
import by.grsu.ruduk.taxopark.model.User;
import by.grsu.ruduk.taxopark.repository.BlacklistRepository;
import by.grsu.ruduk.taxopark.repository.DriverRepository;
import by.grsu.ruduk.taxopark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BlacklistRepository blacklistRepository;

  @GetMapping
  public String getListPage(Model model) {
    model.addAttribute("isAuhorised", getCurrentUser() != null);
    model.addAttribute("list", blacklistRepository.findAll());
    return "list";
  }

  @GetMapping("/del/{id}")
  public String deleteCardById(@PathVariable("id") Long id, Model model) {
    blacklistRepository.deleteById(id);
    model.addAttribute("list", blacklistRepository.findAll());
    model.addAttribute("isAuhorised", getCurrentUser() != null);
    return "list";
  }


  @PostMapping
  public String addListPage(@ModelAttribute("form") BlackList aBlackList, Model model) {
    model.addAttribute("isAuhorised", getCurrentUser() != null);
    BlackList blackList = blacklistRepository.findByLogin(aBlackList.getLogin());
    if (blackList != null) {
      model.addAttribute("blackListError", true);
    } else {
      blackList = aBlackList;
      blacklistRepository.save(blackList);
      model.addAttribute("addedSuccessful", true);
    }
    model.addAttribute("list", blacklistRepository.findAll());
    return "list";
  }

  private User getCurrentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return userRepository.findByUsername(auth.getName());
  }
}
