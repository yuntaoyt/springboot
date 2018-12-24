package com.taotao.service.weixin.util.button;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Button {
	
	public List<Abutton> getButton() {
		return button;
	}

	public void setButton(List<Abutton> button) {
		this.button = button;
	}

	@XStreamAlias("button")
	List<Abutton>button = new ArrayList<Abutton>();
}
