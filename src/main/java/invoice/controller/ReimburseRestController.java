package invoice.controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import invoice.dto.ReimbursementDTO;
import invoice.service.ReimburseService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by song on 2016/12/22.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("reimburse")
public class ReimburseRestController  {

    @Resource
    ReimburseService reimburseService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result add(@RequestBody ReimbursementDTO reimbursementDTO, HttpServletRequest request) {
        reimbursementDTO.setUserId((String) request.getSession().getAttribute("userId"));
        System.out.println(reimbursementDTO.getUserId());
        Result result;
        try {
            result = reimburseService.add(reimbursementDTO);
        }catch (DataIntegrityViolationException exception){
            result = new Result();
            result.setFailed("重复报销!");
        }
        return result;
    }
}
