package wxx.javaPra.anno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import wxx.javaPra.anno.service.PersonService;

/**
 * @author Mr.wxx
 * @create 2021-04-17-8:46
 **/
@Controller
public class PersonController {
    @Autowired
    PersonService personService;
}
