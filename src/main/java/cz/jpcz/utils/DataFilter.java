package cz.jpcz.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DataFilter<T> {

    List<T> data;

    public DataFilter() {}
    public DataFilter(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getFiltered(List<Predicate<T>> predicates) {
        List<T> result = new ArrayList<>();

        Predicate<T> superPredicate = predicates.stream()
                .reduce(t -> true, Predicate::and);

        for (T o : data) {
            if (superPredicate.test(o)) result.add(o);
        }
        return result;
    }
}
