package cn.edu.zucc.senlin.commondao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {
	public void add(T obj) throws Exception;

	public void delete(T obj) throws Exception;

	public void update(T obj) throws Exception;

	public List<T> findByHQL(String hql) throws Exception;

	public Object findById(Serializable key) throws Exception;
	
	public List<T> findByQuantity(String hql,int first,int quantity) throws Exception;

	public int findQuantity(String hql) throws Exception;
}
