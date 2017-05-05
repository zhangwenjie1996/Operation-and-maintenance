package ig.zeus.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ig.zeus.data.UploadFile;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.archer.infrastructure.log.ILogger;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private ILogger logger;
    @Autowired
    private StateMessage message;

    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    @ResponseBody
    public Object getSession(HttpServletRequest request, HttpSession session) {
        AccountViewModel av = new AccountViewModel();
        Assertion assertion = (Assertion) (session == null ? request.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION) : session.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION));
        if (session != null) {
            AttributePrincipal principal = assertion.getPrincipal();
            av.setAccountname(principal.getName());
            Map<String, Object> attributes = principal.getAttributes();
            av.setAccountid(Integer.parseInt((String) attributes.get("accountID")));
            av.setAccountpass((String) attributes.get("accountPass"));
            av.setEmployeename((String) attributes.get("employeeName"));
            av.setOrganid(Integer.parseInt((String) attributes.get("organID")));
            av.setEmployeeid(Integer.parseInt((String) attributes.get("employeeID")));
            av.setPostid(Integer.parseInt((String) attributes.get("postID")));
        }
        StateData<AccountViewModel> account = new StateData<AccountViewModel>(State.Success, "请求成功！", av);
        message = StateMessage.from(account);
        logger.debug(message.toString());
        return message;
    }

    public static AccountViewModel getSession(HttpSession session) {
        Assertion assertion = (Assertion) session.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        AttributePrincipal principal = assertion.getPrincipal();
        AccountViewModel av = new AccountViewModel();
        av.setAccountname(principal.getName());
        Map<String, Object> attributes = principal.getAttributes();
        av.setAccountid(Integer.parseInt((String) attributes.get("accountID")));
        av.setAccountpass((String) attributes.get("accountPass"));
        av.setEmployeename((String) attributes.get("employeeName"));
        av.setOrganid(Integer.parseInt((String) attributes.get("organID")));
        av.setEmployeeid(Integer.parseInt((String) attributes.get("employeeID")));
        av.setPostid(Integer.parseInt((String) attributes.get("postID")));
        return av;
    }

    @RequestMapping(value = "/getTest", method = RequestMethod.POST)
    @ResponseBody
    public Object getTest(@RequestParam("file") CommonsMultipartFile[] upfiles) {
        List<String> list = UploadFile.upload(upfiles, "test01\\test02\\");
        StateData<List<String>> account = new StateData<List<String>>(State.Success, "请求成功！", list);
        message = StateMessage.from(account);
        logger.debug(message.toString());
        return message;
    }

    @RequestMapping(value = "/down", method = RequestMethod.GET)
    @ResponseBody
    public void down(String oldname, String path, HttpServletResponse response) {
        response.setHeader("Content-Disposition", "attachment;filename=" + oldname);
        OutputStream out = null;
        InputStream is = null;
        try {
            out = response.getOutputStream();
            is = UploadFile.downLoad("test01\\test02\\"+path);
            int b;
            while ((b = is.read()) != -1) {
                out.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
