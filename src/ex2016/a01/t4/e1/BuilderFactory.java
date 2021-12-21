package ex2016.a01.t4.e1;

import java.util.Collection;

interface BuilderFactory {
    // Creates a builder of any list of elements
    <X> ListBuilder<X> makeBasicBuilder();

    // Creates a builder of only lists of given size
    <X> ListBuilder<X> makeBuilderWithSize(int size);

    // Creates a builder of only lists with no elements taken from the argument
    <X> ListBuilder<X> makeBuilderWithoutElements(Collection<X> out);

    // Creates a builder of only lists with no elements taken from the argument and with given size
    <X> ListBuilder<X> makeBuilderWithoutElementsAndWithSize(Collection<X> out, int size);
}