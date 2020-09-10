package testgroup.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.crud.model.User;
import testgroup.crud.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public void setFilmService(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView allUsers() {
//        List<User> users = userService.allUsers();
//        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("users");
//        modelAndView.addObject("listUser", users);
//        return modelAndView;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> listUser = userService.allUsers();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listUser", listUser);
        return mav;
    }

    @RequestMapping("/new")
    public String newUserForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.getById(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return "redirect:/";
    }
}