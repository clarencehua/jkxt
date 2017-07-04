package software.lawyer.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import software.lawyer.data.dataobject.RoleModule;
import software.lawyer.data.dataobject.RoleUser;
import software.lawyer.data.dataobject.User;
import software.lawyer.service.UserService;

public class AuthRealm extends AuthorizingRealm {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 授权 当jsp页面出现Shiro标签时，就会执行授权方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("授权");
		User user = (User) pc.fromRealm(this.getName()).iterator().next();// 根据realm的名字去找对应的realm
		List<String> permissions = new ArrayList<String>();
		Set<RoleUser> roles = user.getRoleUserPs();// 对象导航
		for (RoleUser roleUser : roles) {
			Set<RoleModule> roleModules = roleUser.getRole().getRoleModulePs();
			for (RoleModule roleModule : roleModules) {
				permissions.add(roleModule.getModule().getName());
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);// 添加用户的模块（权限）
		return info;
	}

	// 认证 token 代表用户在界面输入的用户名和密码
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证");

		// 1.向下转型
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		// 2.调用业务方法，实现根据用户名查询
		User user = userService.findUserByUsername(upToken.getUsername());
		if (user != null) {
			AuthenticationInfo info = new SimpleAuthenticationInfo(user,
					user.getPassword(), this.getName());
			return info; // 此处如果返回，就会立即进入到密码比较器
		}
		return null;// 就会出现异常
	}

}
