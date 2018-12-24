package com.taotao.service.weixin.util.button;

import java.util.ArrayList;
import java.util.List;

/**
 * 子菜单
 * @author wangying
 * 下午8:13:41
 * SubButton
 */
public class SubButton extends  Abutton{
	public List<Abutton> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<Abutton> sub_button) {
		this.sub_button = sub_button;
	}
	public   List<Abutton>sub_button =new ArrayList<>();
}
