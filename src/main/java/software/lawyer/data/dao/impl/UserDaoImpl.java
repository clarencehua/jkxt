package software.lawyer.data.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import software.lawyer.data.dao.UserDao;
import software.lawyer.data.dataobject.Userb;
//@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Userb> implements UserDao{


	/*public void save(Userb userb) {
		getHibernateTemplate().save(userb);
	}*/

}
