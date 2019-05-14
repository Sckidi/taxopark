package by.grsu.ruduk.taxopark.controller;

import by.grsu.ruduk.taxopark.model.Order;
import by.grsu.ruduk.taxopark.model.User;
import by.grsu.ruduk.taxopark.model.constants.OrderStatus;
import by.grsu.ruduk.taxopark.repository.OrderRepository;
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
@RequestMapping("/orders")
public class OrdersController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @GetMapping
  public String getOrderPage(Model model) {
    model.addAttribute("isAuhorised", getCurrentUser() != null);
    model.addAttribute("orders", orderRepository.findAll());
    model.addAttribute("statuses", OrderStatus.values());
    return "orders";
  }

  @GetMapping("/del/{id}")
  public String deleteCardById(@PathVariable("id") Long id, Model model) {
    orderRepository.deleteById(id);
    model.addAttribute("orders", orderRepository.findAll());
    model.addAttribute("statuses", OrderStatus.values());
    model.addAttribute("isAuhorised", getCurrentUser() != null);
    return "orders";
  }


  @PostMapping
  public String addOrderPage(@ModelAttribute("form") Order aOrder, Model model) {
    model.addAttribute("isAuhorised", getCurrentUser() != null);
    model.addAttribute("statuses", OrderStatus.values());
    Order order = orderRepository.findByNumber(aOrder.getNumber());
    if (order != null) {
      model.addAttribute("orderError", true);
    } else {
      order = aOrder;
      orderRepository.save(order);
      model.addAttribute("addedSuccessful", true);
    }
    model.addAttribute("orders", orderRepository.findAll());
    return "orders";
  }

  private User getCurrentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return userRepository.findByUsername(auth.getName());
  }
}
