package cn.edu.zucc.senlin.commondao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO {
	public void add(Object obj) throws Exception;

	public void delete(Object obj) throws Exception;

	public void update(Object obj) throws Exception;

	public List<?> findByHQL(String hql) throws Exception;

	public Object findById(Serializable key) throws Exception;
	
	public List<?> findByQuantity(String hql,int first,int quantity) throws Exception;

	public int findQuantity(String hql) throws Exception;
}
