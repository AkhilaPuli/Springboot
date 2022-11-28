package Service;

import Entity.User;
import Repository.UserRepository;
import VO.Department;
import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
@Autowired
    private UserRepository userRepository;
@Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        log.info("Inside saveUser of service");
    return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" +user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}

