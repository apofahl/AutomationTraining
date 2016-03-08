package com.xpanxion.automation.dummyapp.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xpanxion.automation.dummyapp.dao.AutoDao;
import com.xpanxion.automation.dummyapp.model.Stylist;

@Service("autoDao")
@Component("autoDao")
public class HibernateAutoDao implements AutoDao {

	private SessionFactory factory;
	
	@Autowired
    public void setSessionFactory(SessionFactory factory) {
        this.factory = factory;
    }

	/** {@inheritDoc */
//	@Override
	public List<Stylist> getAllStylists() {
        Query query = factory.getCurrentSession().getNamedQuery("allStylists");
        @SuppressWarnings("unchecked")
        List<Stylist> retVal = query.list();
        
		return retVal;
	}

}
