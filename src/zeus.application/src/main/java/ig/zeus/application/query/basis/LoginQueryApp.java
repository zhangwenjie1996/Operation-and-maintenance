package ig.zeus.application.query.basis;


import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.ILoginQueryApp;
import ig.zeus.domain.repository.query.IAccountQueryRepository;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;

import java.util.List;

public class LoginQueryApp implements ILoginQueryApp {
    private IAccountQueryRepository iAccountQueryRepository;

    /**
     * @return the iAccountQueryRepository
     */
    public IAccountQueryRepository getiAccountQueryRepository() {
        return iAccountQueryRepository;
    }

    /**
     * @param iAccountQueryRepository the iAccountQueryRepository to set
     */
    public void setiAccountQueryRepository(IAccountQueryRepository iAccountQueryRepository) {
        this.iAccountQueryRepository = iAccountQueryRepository;
    }

    @Override
    public StateData<AccountViewModel> authenticat(String accountName, String accountWord) {
        List<AccountViewModel> list = this.iAccountQueryRepository.findByName(accountName);
        if (list.size() == 0) {
            return new StateData<AccountViewModel>(State.Failure, "用户不存在");
        }
        AccountViewModel av = list.get(0);
        if (av.isAvailability()) {
            String accountWord_db = av.getAccountpass();
            if (!accountWord_db.equalsIgnoreCase(accountWord)) {
                return new StateData<AccountViewModel>(State.Failure, "密码错误");
            }
        } else {
            return new StateData<AccountViewModel>(State.Failure, "账户无效");
        }
        return new StateData<AccountViewModel>(State.Success, "登陆成功", av);
    }

}