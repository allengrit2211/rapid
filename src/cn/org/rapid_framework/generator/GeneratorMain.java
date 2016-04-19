package cn.org.rapid_framework.generator;

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
		// g.printAllTableNames(); //打印数据库中的表名称

		// g.deleteByTable("table_name", "template"); //删除生成的文件
		
		g.deleteOutRootDir(); // 删除生成器的输出目录

//		g.generateByTable("t_activity", "template");
//		g.generateByTable("t_assess", "template");
//		g.generateByTable("t_assess_appeal", "template");
//		g.generateByTable("t_collect", "template");
//		g.generateByTable("t_ddpushUUID", "template");
//		g.generateByTable("t_feedback", "template");
//		g.generateByTable("t_invite", "template");
//		g.generateByTable("t_label", "template");
//		g.generateByTable("t_message", "template");
//		g.generateByTable("t_notice", "template");
//		g.generateByTable("t_notice_img", "template");
//		g.generateByTable("t_notice_lable", "template");
//		g.generateByTable("t_notice_lable_hot", "template");
//		g.generateByTable("t_notice_signup", "template");
//		g.generateByTable("t_photo_stream", "template");
//		g.generateByTable("t_photo_stream_img", "template");
//		g.generateByTable("t_seach_history", "template");
//		g.generateByTable("t_seach_hot", "template");
//		g.generateByTable("t_user", "template");
//		g.generateByTable("t_user_label", "template");
//		g.generateByTable("t_user_label_style", "template");
//		g.generateByTable("t_user_talent", "template");
//		g.generateByTable("t_user_talent_img", "template");
//		g.generateByTable("t_user_talent_lable", "template");
//		g.generateByTable("t_user_talent_lable_hot", "template");
//		g.generateByTable("t_verification", "template");
//		g.generateByTable("t_wx_marketing", "template");
//		g.generateByTable("t_wx_marketing_user", "template");
//		g.generateByTable("t_notice_label", "template");
//		g.generateByTable("t_label_hot", "template");
//		g.generateByTable("t_notice_label_hot", "template");



		 g.generateByAllTable("template"); //自动搜索数据库中的所有表并生成文件,template为模板的根目录
		// g.generateByClass(Blog.class,"template_clazz");

		// 打开文件夹
//		Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
