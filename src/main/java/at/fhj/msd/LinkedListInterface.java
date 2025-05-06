package at.fhj.msd;

public interface LinkedListInterface<E> {

    int size();

    boolean isEmpty();

    E first();

    void addFirst(E newElement);

    E removeFirst();

    E last();

    void addLast(E newElement);

    void printList();

}
