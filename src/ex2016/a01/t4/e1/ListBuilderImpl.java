package ex2016.a01.t4.e1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ListBuilderImpl<X> implements ListBuilder<X> {

	private final List<X> list;
	private boolean consumed;
	private final Predicate<List<X>> predicateBuild;
	private final Predicate<X> predicateAdd;

	public ListBuilderImpl(Predicate<X> predicateAdd, Predicate<List<X>> predicateBuild) {
		this.list = new LinkedList<>();
		this.predicateAdd = predicateAdd;
		this.predicateBuild = predicateBuild;
	}

	@Override
	public void add(X x) {
		if (predicateAdd.test(x)) {
			throw new IllegalArgumentException();
		}
		if (consumed) {
			throw new IllegalStateException();
		}
		list.add(x);

	}

	@Override
	public List<X> build() {
		if (consumed || predicateBuild.test(list)) {
			throw new IllegalStateException();
		}
		consumed = true;
		return Collections.unmodifiableList(list);
	}

}
