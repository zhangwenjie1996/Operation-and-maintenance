package ig.device.controller.customer;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.customer.ICustomerApp;
import ig.device.application.query.customer.ICustomerQueryApp;
import ig.device.domain.service.command.customer.ContactCommand;
import ig.device.domain.service.command.customer.CustomerCommand;
import ig.device.domain.viewmodel.customer.CustomerViewModel;
import ig.zeus.controller.SessionController;
import ig.zeus.data.StateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ILogger logger;
    @Autowired
    private StateMessage message;
    @Autowired
    private ICustomerApp iCustomerApp;
    @Autowired
    private ICustomerQueryApp iCustomerQueryApp;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@RequestParam("customerId") int id) {
        StateData<Boolean> del = iCustomerApp.remove(id);
        message = StateMessage.from(del);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(CustomerCommand customerCommand, HttpSession session) {
        if ("".equals(customerCommand.getRegistrantName()) || null == customerCommand.getRegistrantName()) {
            customerCommand.setRegistrantName(SessionController.getSession(session).getEmployeename());
            customerCommand.setRegistrantID(SessionController.getSession(session).getEmployeeid());
        }
        StateData<Integer> insert = iCustomerApp.add(customerCommand);
        message = StateMessage.from(insert);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(CustomerCommand customerCommand) {
        StateData<Boolean> insert = iCustomerApp.update(customerCommand);
        message = StateMessage.from(insert);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public String getAccountReportFindAll(int current, int rowCount, CustomerViewModel viewModel) {
        PagingData data = new PagingData(current, rowCount);
        message = StateMessage.from(iCustomerQueryApp.findPageData(data, viewModel));
        logger.debug(message.toString());
        return message.toString();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    public String getAccountReportById(@RequestParam("customerId") Integer id) {
        message = StateMessage.from(iCustomerQueryApp.findById(id));
        logger.debug(message.toString());
        return message.toString();
    }

    @RequestMapping(value = "/getContactTreeByCustomerId", method = RequestMethod.GET)
    @ResponseBody
    public String getContactTree(@RequestParam("customerId") int id) {
        message = StateMessage.from(iCustomerQueryApp.findContactTree(id));
        logger.debug(message.toString());
        return message.toString();
    }

    @RequestMapping(value = "/findContactByContactId", method = RequestMethod.GET)
    @ResponseBody
    public String findContactByContactId(@RequestParam("contactId") int id) {
        message = StateMessage.from(iCustomerQueryApp.findContactByContactId(id));
        logger.debug(message.toString());
        return message.toString();
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)

    @ResponseBody
    public String deleteContact(@RequestParam("contactId") int id) {
        message = StateMessage.from(iCustomerApp.deleteContact(id));
        logger.debug(message.toString());
        return message.toString();
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    @ResponseBody
    public String addContact(ContactCommand contactCommand) {
        message = StateMessage.from(iCustomerApp.addContact(contactCommand));
        logger.debug(message.toString());
        return message.toString();
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST)
    @ResponseBody
    public String updateContact(ContactCommand contactCommand) {
        message = StateMessage.from(iCustomerApp.updateContact(contactCommand));
        logger.debug(message.toString());
        return message.toString();
    }
}
