package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IPermissionApp;
import ig.zeus.application.query.IPermissionQueryApp;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private ILogger logger;
    @Autowired
    private StateMessage message;
    @Autowired
    private IPermissionApp iPremissionApp;
    @Autowired
    private IPermissionQueryApp iPremissionQueryApp;

    @RequestMapping(value = "/addRoleSystem", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Object addRoleSystem(int roleId, @RequestParam(value = "systemIds[]") int[] systemIds) {
        message = StateMessage.from(iPremissionApp.addRoleSystem(roleId, systemIds));
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/addRoleMenu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Object addRoleMenu(int roleId, @RequestParam(value = "menuIds[]") int[] menuIds) {
        message = StateMessage.from(iPremissionApp.addRoleMenu(roleId, menuIds));
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/addRoleElement", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Object addRoleElement(int roleId, @RequestParam(value = "elementIds[]") int[] elementIds, @RequestParam(value = "permissions[]") int[] permissions) {
        message = StateMessage.from(iPremissionApp.addRoleElement(roleId, elementIds, permissions));
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/findSystemByRoleId", method = RequestMethod.GET)
    @ResponseBody
    public Object findSystemByRoleId(HttpServletRequest request, int roleId) {
        message = StateMessage.from(iPremissionQueryApp.findSystemByRoleId(roleId));
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/findMenuByRoleId", method = RequestMethod.GET)
    @ResponseBody
    public Object findMenuByRoleId(HttpServletRequest request, int roleId) {
        message = StateMessage.from(iPremissionQueryApp.findMenuByRoleId(roleId));
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/findElementByRoleId", method = RequestMethod.GET)
    @ResponseBody
    public Object findElementByRoleId(HttpServletRequest request, int roleId) {
        message = StateMessage.from(iPremissionQueryApp.findElementByRoleId(roleId));
        logger.debug(message.toString());
        return message;
    }

}
