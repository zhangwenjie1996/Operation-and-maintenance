package ig.zeus.application.query;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;

/**
 * 
 * <p>
 * Title: ILoginQueryApp
 * </p>
 * <p>
 * Description: 认证授权接口
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author wxf
 */
public interface ILoginQueryApp {
	// 根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
	public StateData<AccountViewModel> authenticat(String userCode, String password);

}
