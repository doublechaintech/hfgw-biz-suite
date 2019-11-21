package com.doublechaintech.hfgw;


import com.terapico.caf.viewpage.SerializeScope;

public class HfgwViewScope extends HfgwBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static HfgwViewScope instance = null;
	public static HfgwViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (HfgwViewScope.class) {
			instance = new HfgwViewScope();
		}
		return instance;
	}
}







