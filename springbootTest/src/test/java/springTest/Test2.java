package springTest;

import com.google.common.annotations.VisibleForTesting;
import com.taotao.service.weixin.util.button.Abutton;
import com.taotao.service.weixin.util.button.Button;
import com.taotao.service.weixin.util.button.ClickButton;
import com.taotao.service.weixin.util.button.SubButton;

import net.sf.json.JSONObject;

public class Test2 {
   public static void main(String[] args) {
	  Test2 te  = new Test2();
	  te.show();
   }
   public void show(){
	   ClickButton  ab = new ClickButton();
	   ab.setName("菜单一");
	   ab.setType("click");
	   ab.setKey("100100");
	   Button  bt = new Button();
	   bt.getButton().add(ab);
	   SubButton  su  = new SubButton();
	   ClickButton  ab1 = new ClickButton();
	   ab1.setName("菜单二");
	   ab1.setType("click");
	   ab1.setKey("100100");
	   ClickButton  ab2 = new ClickButton();
	   ab2.setName("菜单三");
	   ab2.setType("click");
	   ab2.setKey("100100");
	   su.getSub_button().add(ab1);
	   su.getSub_button().add(ab2);
	   bt.getButton().add(su);
	   JSONObject   jb  = JSONObject.fromObject(bt);
	   System.out.println(jb);
	   
   }
}
