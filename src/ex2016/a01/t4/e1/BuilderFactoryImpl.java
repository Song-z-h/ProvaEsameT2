package ex2016.a01.t4.e1;

import java.util.Collection;

public class BuilderFactoryImpl implements BuilderFactory {

	@Override
	public <X> ListBuilder<X> makeBasicBuilder() {
		return new ListBuilderImpl<>(x -> false, y -> false);
	}

	@Override
	public <X> ListBuilder<X> makeBuilderWithSize(int size) {
		return new ListBuilderImpl<>(x -> false, y -> y.size() != size);
	}

	@Override
	public <X> ListBuilder<X> makeBuilderWithoutElements(Collection<X> out) {
		return new ListBuilderImpl<>(x -> out.contains(x), y -> false);
	}

	@Override
	public <X> ListBuilder<X> makeBuilderWithoutElementsAndWithSize(Collection<X> out, int size) {
		return new ListBuilderImpl<>(x -> out.contains(x), y -> y.size() != size);
	}

}
