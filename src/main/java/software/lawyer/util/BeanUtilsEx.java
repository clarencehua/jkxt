package software.lawyer.util;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;

public class BeanUtilsEx extends BeanUtils {
	static {
		ConvertUtils.register(new DateConverter(), java.util.Date.class);
	}
	public static void copyProperties(Object dest, Object orig){
		try{
			BeanUtils.copyProperties(dest, orig);
		} catch(IllegalAccessException ex){
			ex.printStackTrace();
		} catch (InvocationTargetException ex){
			ex.printStackTrace();
		}
	}
}
