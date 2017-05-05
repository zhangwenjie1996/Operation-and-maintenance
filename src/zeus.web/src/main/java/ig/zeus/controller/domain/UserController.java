package ig.zeus.controller.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import ig.archer.infrastructure.data.type.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IUserApp;
import ig.zeus.application.query.IUserQueryApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.repository.viewmodel.EmployeeViewModel;
import ig.zeus.domain.service.command.AccountCommand;
import ig.zeus.domain.service.command.EmployeeCommand;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ILogger logger;
    @Autowired
    private StateMessage message;
    @Autowired
    private IUserApp iUserApp;
    @Autowired
    private IUserQueryApp iUserQueryApp;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:鍏佽杈撳叆绌哄�硷紝false:涓嶈兘涓虹┖鍊�
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Object delete(@RequestParam("employeeid") int id) {
        StateData<Boolean> del = iUserApp.removeEmployee(id);
        if (State.Failure.equals(del.getState())) {
            throw new RuntimeException(del.getMessage());
        }
        message = StateMessage.from(del);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(EmployeeCommand employeeCommand) {
        StateData<Integer> insert = iUserApp.addEmployee(employeeCommand);
        message = StateMessage.from(insert);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(EmployeeCommand employeeCommand) {
        StateData<Boolean> insert = iUserApp.updateEmployee(employeeCommand);
        message = StateMessage.from(insert);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Object addAccount(AccountCommand accountCommand,
                             Integer employeeid) {
        StateData<Boolean> insert = iUserApp.addAccount(accountCommand, employeeid);
        if (State.Failure.equals(insert.getState())) {
            throw new RuntimeException(insert.getMessage());
        }
        message = StateMessage.from(insert);
        return message;
    }

    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    @ResponseBody
    public Object updateAccount(HttpServletRequest request, AccountCommand accountCommand,
                                Integer employeeid) {
        StateData<Boolean> insert = iUserApp.updateAccount(accountCommand, employeeid);
        if (State.Failure.equals(insert.getState())) {
            throw new RuntimeException(insert.getMessage());
        }
        message = StateMessage.from(insert);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public String getAccountReportFindAll(int current, int rowCount, EmployeeViewModel viewModel) {
        PagingData data = new PagingData(current, rowCount);
        message = StateMessage.from(iUserQueryApp.findPageData(data, viewModel));
        logger.debug(message.toString());
        return message.toString();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public String getAccountReportById(@RequestParam("employeeid") Integer id) {
        message = StateMessage.from(iUserQueryApp.findById(id));
        logger.debug(message.toString());
        return message.toString();
    }

    /**
     * 鏍规嵁employeeId鑾峰彇account
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findByAccountEmployeeId", method = RequestMethod.POST)
    public
    @ResponseBody
    String getAccountReportByEmployeeId(@RequestParam("employeeid") Integer id) {
        message = StateMessage.from(iUserQueryApp.findAccountByEmployeeId(id));
        logger.debug(message.toString());
        return message.toString();
    }
    /**
     * 根据部门ID,获取员工集合
     * @param id
     * @return
     */
    @RequestMapping(value = "/findEmployeeByOrganID", method = RequestMethod.GET)
    public
    @ResponseBody
    String findEmployeeByOrganID(Integer organID) {
    	message = StateMessage.from(iUserQueryApp.findEmployeeByOrganID(organID));
    	logger.debug(message.toString());
    	return message.toString();
    }
}
