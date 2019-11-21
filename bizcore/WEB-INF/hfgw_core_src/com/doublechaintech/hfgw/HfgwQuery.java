package com.doublechaintech.hfgw;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class HfgwQuery extends BaseQuery {
	
	public HfgwQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("hfgw");
  }

  public HfgwQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}













