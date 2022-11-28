package Controller;

import Entity.User;
import Service.UserService;
import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@Slf4j
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside User post method of controller");
        return userService.saveUser(user);
    }
@GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable long userId){
        return userService.getUserWithDepartment(userId);
    }
}
