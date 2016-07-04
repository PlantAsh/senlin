package cn.edu.zucc.senlin.commondao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository("baseDAO")
public abstract class BaseDAOimpl<T> implements BaseDAO<T> {
	
	private SessionFactory sessionFactory;
	private Class<T> entityClass;
	
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    public Session getCurrent() {
    	return this.getSessionFactory().getCurrentSession();
    }
    
    public BaseDAOimpl() {
    	Type type = getClass().getGenericSuperclass();
    	entityClass = (Class<T>) ((ParameterizedType)type).getActualTypeArguments()[0];
    }

	public void add(T obj) throws Exception {
        try {
        	this.getCurrent().save(obj);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void delete(T obj) throws Exception {
        try {
        	this.getCurrent().delete(obj);
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(T obj) throws Exception {
        try {
        	this.getCurrent().update(obj);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //根据指定的hql进行查询，并返回查询结果
    public List<T> findByHQL(String hql) throws Exception {
        try {
            Query queryObject = this.getCurrent().createQuery(hql);
            return queryObject.list();
        } catch (Exception e) {
        	e.printStackTrace();
            throw e;
        }
    }

    //根据指定的实体类型和主键的值，查找实体对象
	public T findById(Serializable key) throws Exception {
        try {
            T instance = (T) this.getCurrent().get(entityClass, key);
            return instance;
        } catch (Exception e) {
            throw e;
        }
    }
	
	//根据指定的位置和数量，查找对象
    public List<T> findByQuantity(String hql,int first,int quantity) throws Exception {
        try {
        	Query queryObject = this.getCurrent().createQuery(hql);
        	queryObject.setFirstResult(first);
        	queryObject.setMaxResults(quantity);
            return queryObject.list();
        } catch (Exception e) {
            throw e;
        }
    }
	@Override
	public int findQuantity(String hql) throws Exception {
		try {
            int quantity = (int) this.getCurrent().createQuery(hql).uniqueResult();
            return quantity;
        } catch (Exception e) {
        	e.printStackTrace();
            throw e;
        }
	}
	
}
