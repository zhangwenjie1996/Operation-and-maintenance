package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.IUserApp;
import ig.zeus.domain.service.IRoleService;
import ig.zeus.domain.service.IUserService;
import ig.zeus.domain.service.command.AccountCommand;
import ig.zeus.domain.service.command.EmployeeCommand;

public class UserApp implements IUserApp {
    private IUserService iUserService;

    private IRoleService iRoleService;

    /**
     * @return the iRoleService
     */
    public IRoleService getiRoleService() {
        return iRoleService;
    }

    /**
     * @param iRoleService the iRoleService to set
     */
    public void setiRoleService(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    public IUserService getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Override
    public StateData<Boolean> removeEmployee(Integer employeeid) {
        try {
            // 删除员工信息
            // 删除员工,账户也要删除(将删除员工与删除员工账户关系放到一个service中)
            int accountId = this.iUserService.remove(employeeid);
            if (accountId != 0) {
                // 删除账号信息
                this.iRoleService.removeAccount(accountId);
                // 删除账号角色信息
                // 当删除角色时,不会删除账号信息(只删除关系 不放到一个service中)
                this.iRoleService.removeRoleAccount(accountId);
            }
            return new StateData<Boolean>(State.Success, "删除成功", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StateData<Boolean>(State.Failure, "删除失败!", false);
    }

    @Override
    public StateData<Integer> addEmployee(EmployeeCommand entity) {
        try{
           int x =  iUserService.add(entity);
            return new StateData<Integer>(State.Success, "保存成功!",x);
        }catch (Exception e){
            e.printStackTrace();
            return new StateData<Integer>(State.Failure, "保存失败!");
        }
    }

    @Override
    public StateData<Boolean> updateEmployee(EmployeeCommand entity) {
        int insert = iUserService.update(entity);
        if (insert == 1) {
            return new StateData<Boolean>(State.Success, "保存成功!", true);
        } else {
            return new StateData<Boolean>(State.Failure, "更新失败!", false);
        }
    }

    @Override
    public StateData<Boolean> addAccount(AccountCommand accountCommand, Integer employeeid) {
        try {
            // 调用roleService 添加账户
            int accountId = this.iRoleService.addAccount(accountCommand);
            // 添加账户角色关系
            if (-1 != accountCommand.getRoleId()) {
                this.iRoleService.addRoleAccount(accountId, accountCommand.getRoleId());
            }
            // 调用userService 添加员工账户关系
            int employeeAccountId = this.iUserService.addEmployeeAccount(employeeid, accountId);
            if (employeeAccountId == 0) {
                return new StateData<Boolean>(State.Failure, "保存失败!", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new StateData<Boolean>(State.Failure, "保存失败!", false);
        }
        return new StateData<Boolean>(State.Success, "保存成功!", true);
    }

    @Override
    public StateData<Boolean> updateAccount(AccountCommand accountCommand, int employeeid) {
        try {
            // 更新账户
            this.iRoleService.updateAccount(accountCommand);
            // 更新账户角色信息 int roleAccountId =
            if (-1 != accountCommand.getRoleId()) {
                this.iRoleService.updateRoleAccount(accountCommand.getAccountid(), accountCommand.getRoleId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new StateData<Boolean>(State.Failure, "保存失败!", false);
        }
        return new StateData<Boolean>(State.Success, "保存成功!", true);
    }

}
