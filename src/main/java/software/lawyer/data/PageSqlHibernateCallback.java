package software.lawyer.data;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import software.lawyer.service.model.base.PageModel;
import software.lawyer.util.CollectionUtil;

/**
 * 分页的回调函数
 * 
 * @author 曲波
 */
@SuppressWarnings("unchecked")
public class PageSqlHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String sql;
	private List<Object> params;
	private PageModel pageModel;

	public PageSqlHibernateCallback(String sql, PageModel pageModel, List<Object> params) {
		this.sql = sql;
		this.pageModel = pageModel;
		this.params = params;
	}

	public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
		Query query = session.createSQLQuery(sql).setFirstResult(pageModel.getBeginIndex())
				.setMaxResults(pageModel.getPageSize());
		if (!CollectionUtil.listIsNull(params)) {
			for (int i = 0; i < params.size(); i++) {
				Object obj = params.get(i);
				if (obj instanceof String) {
					query.setString(i, (String) obj);
				} else if (obj instanceof Integer) {
					query.setInteger(i, (Integer) obj);
				} else if (obj instanceof Date) {
					query.setDate(i, (Date) obj);
				}
			}
		}
		List<T> list = query.list();

		if (sql != null && sql.trim().equals("")) {
			String countSql = "select count(*) ";
			int index = sql.indexOf("from");
			countSql += sql.substring(0, index);
			Query countQuery = session.createQuery(countSql);
			if (!CollectionUtil.listIsNull(params)) {
				for (int i = 0; i < params.size(); i++) {
					Object obj = params.get(i);
					if (obj instanceof String) {
						countQuery.setString(i, (String) obj);
					} else if (obj instanceof Integer) {
						countQuery.setInteger(i, (Integer) obj);
					} else if (obj instanceof Date) {
						countQuery.setDate(i, (Date) obj);
					}
				}
			}
			List<Object> countList = countQuery.list();
			if (CollectionUtil.listIsNull(countList)) {
				pageModel.setTotalCount(0);
			} else {
				pageModel.setTotalCount((Long) countList.get(0));
			}
		}
		return list;
	}

}