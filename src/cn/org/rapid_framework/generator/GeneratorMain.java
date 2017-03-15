package cn.org.rapid_framework.generator;

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
//		 g.printAllTableNames(); //打印数据库中的表名称

		// g.deleteByTable("table_name", "template"); //删除生成的文件
		
		g.deleteOutRootDir(); // 删除生成器的输出目录
		
		// 通过数据库表生成文件,template为模板的根目录
//		g.generateByTable("T_CPS_CLICK", "template"); 
//		g.generateByTable("T_CPS_ORDER", "template");
//		g.generateByTable("t_ws_feedback", "template");
//		g.generateByTable("t_user_gps", "template");
//		g.generateByTable("t_commodity_invalid", "template");

//		g.generateByAllTable("template");

		 g.generateByAllTable("template"); //自动搜索数据库中的所有表并生成文件,template为模板的根目录
		// g.generateByClass(Blog.class,"template_clazz");

		// 打开文件夹
		Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
