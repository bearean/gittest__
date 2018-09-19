package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	public List<Emp> selectAll();
	public Emp selectByEmpNo(Emp selectEmp);
	public void insertEmp(Emp insertEmp);
	public void deleteByEmpNo(Emp deleteEmp);
}
