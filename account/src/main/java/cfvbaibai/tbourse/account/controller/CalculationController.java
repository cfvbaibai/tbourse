package cfvbaibai.tbourse.account.controller;

import cfvbaibai.tbourse.core.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/calc")
public class CalculationController {
    @Resource(name = "calculator")
    private Calculator calculator;

    @GetMapping(path="/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calculator.add(a, b);
    }
}
