package com.icss.framework.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hibernateBaseDao")
public class HibernateBaseDAO implements IHibernateBaseDAO {
	
	@Autowired
	private SessionFactory hibernateSessionFactory;
	
	private Session getCurrentSession() {
		//return this.hibernateSessionFactory.openSession();
		
		return this.hibernateSessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(Object object) {
		return getCurrentSession().save(object);
	}

	@Override
	public void update(Object object) {
		getCurrentSession().update(object);
	}

	@Override
	public void saveOrUpdate(Object object) {
		getCurrentSession().saveOrUpdate(object);
	}

	@Override
	public Object findById(Class c, Serializable id) {
		return getCurrentSession().get(c, id);
	}

	@Override
	public Object findOne(String hql, Object[] param) {
		List l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public List find(String hql, Object[] param) {
		Query q = getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i ++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	@Override
	public List find(String hql, Object[] param, Integer page, Integer rows) {
		Query q = getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i ++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql, Object[] param) {
		Query q = getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i ++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long)q.uniqueResult();
	}

	@Override
	public void delete(Object object) {
		getCurrentSession().delete(object);
	}

}
