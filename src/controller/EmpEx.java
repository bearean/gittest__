package controller;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	public static void main(String[] args) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession(true);
		// sqlSession 에 SQL 연결하기
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		
		Emp dto = new Emp();
		Scanner sc = new Scanner(System.in);
		
		List<Emp> list = dao.selectAll();
		System.out.println("dao.selectAll");
		System.out.println(list);
		System.out.println("==============");
		
		System.out.print("EMPNO : ");
		int empno = Integer.parseInt(sc.nextLine());
		
		
		System.out.print("ENAME : ");
		String ename = sc.nextLine();
		
		System.out.print("JOB : ");
		String job = sc.nextLine();
		
		System.out.print("MGR : ");
		int mgr =Integer.parseInt(sc.nextLine());
		
		System.out.print("SAL : ");
		int sal =Integer.parseInt(sc.nextLine());
		
		System.out.print("COMM : ");
		int comm = Integer.parseInt(sc.nextLine());
		
		System.out.print("DEPTNO : ");
		int deptno = Integer.parseInt(sc.nextLine());
		
		dto.setComm(comm);
		dto.setDeptno(deptno);
		dto.setEmpno(empno);
		
		Date date = new Date(System.currentTimeMillis());
		
		dto.setHiredate(date);
		dto.setEname(ename);
		dto.setJob(job);
		dto.setMgr(mgr);
		dto.setSal(sal);
		
		dao.insertEmp(dto);
		
		System.out.println(dao.selectByEmpNo(dto));
		
		
		int dempno = empno-1 ;
		dto.setEmpno(dempno);
		dao.deleteByEmpNo(dto);
		
		System.out.println("==============");
		List<Emp> list2 = dao.selectAll();
		System.out.println("dao.selectAll");
		System.out.println(list2);
		System.out.println("==============");
		System.out.println("뀨");
		
		
	}

}
