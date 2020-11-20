package com.example.ProjectDemo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ProjectDemo.Model.Division;
import com.example.ProjectDemo.Projection.HMaster;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
	
	@Query(value ="SELECT a.division_no as DivisionNo , a.DIVISION_NAME as DivisionName , b.GROUP_NO as GroupNo ,"
			+ " b.GROUP_NAME as GroupName ,c.dept_no as DepartmentNo ,"
			+ " c.dept_name as DepartmentName FROM division a JOIN grp b "
			+ "ON a.division_no=b.division_no JOIN Department c ON b.group_no=c.group_no;", nativeQuery = true)
				List<HMaster> masterDetails();

}
