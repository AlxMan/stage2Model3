思路与实现：

    一、思路
    1、用户通过jsp发送请求到DispatcherServlet
    2、根据xml配置或注解找到相应的Controller并提交请求
    3、controller层->业务层->dao层完成业务处理
    4、处理视图映射并返回模型
    5、Http响应，将结果返回页面
    二、实现
    
    1、controller层 
        LoginController类：继承HttpServlet 并重写dopost与doget方法。设置setCharacterEncoding为utf-8，并通过request的getParameter方法获取login.jsp提交的参数，调用LoginDao的login方法进行数据库校验，
        如果成功则getRequestDispatcher.forward重定向到welcome.jsp，失败则返回login.jsp
        addStudentController类：继承HttpServlet 并重写dopost与doget方法。setContentType("text/html; charset=utf-8")设置编码，通过request.getParameter方法获取add.jsp提交的参数 ,调用studentservice的AddStudent方法将数据存入库中
    2、dao层
        LoginDao类:查询数据库如果login.jsp传入得参数在数据（用户名、密码）库中存在并且一致return成功否则失败
        StudentDao:插入数据，通过实体类getduiyingadd.jsp传入的参数insert into进数据库
    3、entity层
        Login类：实体类提供get/set/构造/toString方法
        Student类：实体类提供get/set/构造/toString方法
    4、filter层
        addStudentFilter类：拦截器,实现Filter接口init、doFilter、destroy方法并通过request.getSession来判断跳转相应的页面，session有用户信息调用filterChain.doFilter放行，否则调用response.sendRedirect重定向login.jsp
    5、service层
        StudentService类：调用AddStudent时，判断用户是否存在
    6、webapp
        web.xml配置servlet(名称、类全名)、servlet-mapping(映射名称、映射路径)与filter(名称、类全名)、filter-mapping(映射名称、映射路径)
        
   
效果：
登录成功
![Image text](https://github.com/AlxMan/stage2Model3/blob/master/src/main/webapp/WEB-INF/image/img_1.png)
失败重定向
![Image text](https://github.com/AlxMan/stage2Model3/blob/master/src/main/webapp/WEB-INF/image/img.png)
