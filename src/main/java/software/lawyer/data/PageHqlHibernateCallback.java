package software.lawyer.data;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class PageHqlHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String hql;
	private List<Object> params;
	private Map<String,Object> namedParams ;
	private PageModel pageModel;

	public PageHqlHibernateCallback(String hql, PageModel pageModel, List<Object> params) {
		this.hql = hql;
		this.pageModel = pageModel;
		this.params = params;
	}
	
	  public PageHqlHibernateCallback(String hql, PageModel pageModel, Map<String,Object> namedParams) {
        this.hql = hql;
        this.pageModel = pageModel;
        this.namedParams = namedParams;
    }

	public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
		Query query = session.createQuery(hql)
		        .setFirstResult(pageModel.getBeginIndex())
				.setMaxResults(pageModel.getPageSize());
		setParams(query);
		List<T> list = query.list();
		String counthql = null ;
		if(hql.contains("select")){
		    int i = hql.indexOf("from") ;
		    String p1 = hql.substring(6,i) ;
		    String p2 = hql.substring(i) ;
		    counthql = "select count(" + p1 + ") " + p2 ;
		}else{
		    counthql = "select count(*) " + hql;
		}
		Query countQuery = session.createQuery(counthql);
		setParams(countQuery);
		List<Object> countList = countQuery.list();
		if (CollectionUtil.listIsNull(countList)) {
			pageModel.setTotalCount(0);
		} else {
			pageModel.setTotalCount((Long) countList.get(0));
		}
		return list;
	}
	
	private void setParams(Query query){
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
	    if (namedParams!=null&&!namedParams.isEmpty()) {
            for (Map.Entry<String, Object> entry:namedParams.entrySet()) {
                String name = entry.getKey() ;
                Object obj = entry.getValue() ;
                if (obj instanceof String) {
                    query.setString(name, (String) obj);
                } else if (obj instanceof Integer) {
                    query.setInteger(name, (Integer) obj);
                } else if (obj instanceof Date) {
                    query.setDate(name, (Date) obj);
                } else if (obj instanceof Collection) {
                    query.setParameterList(name, (Collection) obj) ;
                }
            }
        }
	}

}