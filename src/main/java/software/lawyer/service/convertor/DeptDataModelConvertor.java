package software.lawyer.service.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import software.lawyer.data.dataobject.Dept;
import software.lawyer.service.model.DeptDataModel;
import software.lawyer.service.model.DeptModel;
import software.lawyer.util.MyBeanUtils;

public class DeptDataModelConvertor {
	public DeptDataModel deptDoConvetor(List<Dept> depts) throws Exception{
		DeptDataModel dataModel=new DeptDataModel();
		List<DeptModel> deptModels=new ArrayList<DeptModel>();
		for (Dept dept : depts) {
			DeptModel deptModel=new DeptModel();
			//BeanUtils.copyProperties(deptModel, depts);
			deptModel.setDeptId(dept.getDeptId());
			deptModel.setDeptName(dept.getDeptName());
			deptModel.setState(dept.getState());
			if (dept.getDept()!=null) {
				if (dept.getDept().getDeptId()!=null) {
					deptModel.setFdeptId(dept.getDept().getDeptId());
					deptModel.setFdeptName(dept.getDept().getDeptName());
					deptModel.setFstate(dept.getDept().getState());
					
				}
			}else {
				deptModel.setFdeptId(" ");
				deptModel.setFdeptName(" ");
				deptModel.setFstate(0);
			}
			deptModels.add(deptModel);
			
		}
		
		dataModel.setList(deptModels);
		return dataModel;
	}
}
