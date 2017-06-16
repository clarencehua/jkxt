package software.lawyer.service.convertor;

import java.util.ArrayList;
import java.util.List;

import software.lawyer.data.dataobject.Module;
import software.lawyer.service.model.ModuleDataModel;
import software.lawyer.service.model.ModuleModel;
import software.lawyer.util.BeanUtilsEx;

public class ModuleDataModelConvertor {
	public ModuleDataModel moduleDoConvertor(List<Module> modules){
		ModuleDataModel moduleDataModel=new ModuleDataModel();
		List<ModuleModel> data=new ArrayList<ModuleModel>();
		for (Module module : modules) {
			ModuleModel moduleModel=new ModuleModel();
			BeanUtilsEx.copyProperties(moduleModel, module);
			data.add(moduleModel);
		}
		moduleDataModel.setData(data);
		return moduleDataModel;
	}
}
