var Test = Test || {};
(function() {
	Test = {
	    /**
	     * 只是加载用的
	     */	
		init : function() {
			var self = this;
			self.initEvent();
			self.initListener();
		},
		/**
		 * 定义初始化数据
		 */
		initEvent : function() {
			
		},
		/**
		 * 定义事件监听
		 */
		initListener : function() {
		  var self = this;  //拿到当前对象Test	
		  $("#test").click(function(){
			 self._p(); 
		  })
	    },
	    /**
	     * 带_ 的都是在别的事件中调用的
	     */
		_p:function(){
			  $("#test").css("color","red"); 
		}
		  
	}
})();
$(function(){
	Test.init();
})





