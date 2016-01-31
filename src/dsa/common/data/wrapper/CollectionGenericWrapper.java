package dsa.common.data.wrapper;

import java.util.Collection;

public class CollectionGenericWrapper {
	public Collection<?> data;
	public Class<?> contentClass;
	public <T> CollectionGenericWrapper(Collection<T> data,Class<T> contentClass) {
		this.data = data;
		this.contentClass = contentClass;
	}
}
